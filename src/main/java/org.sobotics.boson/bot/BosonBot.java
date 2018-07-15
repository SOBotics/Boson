package org.sobotics.boson.bot;


import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sobotics.boson.bot.model.*;
import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.ChatRoomService;
import org.sobotics.boson.framework.services.chat.commands.Alive;
import org.sobotics.boson.framework.services.chat.commands.Command;
import org.sobotics.boson.framework.services.chat.filters.EmptyFilter;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.filters.LengthFilter;
import org.sobotics.boson.framework.services.chat.filters.ReputationFilter;
import org.sobotics.boson.framework.services.chat.listeners.MessageReplyEventListener;
import org.sobotics.boson.framework.services.chat.listeners.UserMentionedListener;
import org.sobotics.boson.framework.services.chat.monitors.*;
import org.sobotics.boson.framework.services.chat.printers.CommentOneBoxPrinter;
import org.sobotics.boson.framework.services.chat.printers.GenericContentPrinterService;
import org.sobotics.boson.framework.services.chat.printers.ListOfTagsPrinter;
import org.sobotics.chatexchange.chat.ChatHost;
import org.sobotics.chatexchange.chat.Message;
import org.sobotics.chatexchange.chat.Room;
import org.sobotics.chatexchange.chat.StackExchangeClient;
import org.sobotics.chatexchange.chat.event.EventType;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BosonBot {

    private static Logger logger = LoggerFactory.getLogger(BosonBot.class);

    private Room room;
    private StackExchangeClient client;
    private Map<String, Bot> bots;

    public BosonBot(Room room, StackExchangeClient client) {
        this.room = room;
        this.client = client;
        this.bots = new HashMap<>();
    }

    public void start(){
        try {
            room.send("Boson Started");
            logger.info("Started");
            room.addEventListener(EventType.USER_MENTIONED, event -> {
                Message message = event.getMessage();
                System.out.println(message.getPlainContent());
                String arguments[] = message.getPlainContent().split(" ");
                switch (arguments[1]) {
                    case "track":
                        trackCommand(message);
                        break;
                    case "help":
                        room.send("Use the command `track sitename posttype frequency` to start tracking sites " +
                                "(`track -h` gives a longer description)");
                        break;
                    case "alive":
                        room.send("Yes, I'm alive");
                        break;
                    case "stop":
                        stopCommand(arguments[2]);
                        break;
                    case "list":
                        listCommand();
                        break;
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listCommand() {
        room.send(String.join(";", bots.keySet()));
    }

    private void stopCommand(String argument) {
        try {
            if (bots.containsKey(argument)) {
                bots.get(argument).getChatRoomService().stopService();
                int stoppingBotID = bots.get(argument).getChatRoom().getRoomId();
                bots.remove(argument);
                if (findChatRoomByRoomId(stoppingBotID) == null &&
                        stoppingBotID != room.getRoomId()) {
                    bots.get(argument).getChatRoomService().terminateService();
                }
                room.send("Bot " + argument + " stopped");
            } else {
                room.send("Wrong bot ID");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void trackCommand(Message message) {
        String[] splits = message.getPlainContent().split(" ");
        String arguments[] = Arrays.copyOfRange(splits, 2, splits.length);
        try {
            Namespace res = parseArguments(arguments);

            if (res==null) return;

            String site = res.getString("site");
            Type posttype = res.get("type");
            int frequency = res.getInt("frequency");
            Integer otherRoomId = res.getInt("room");
            ChatHost otherHost = res.get("host");
            Filters filter = res.get("filter");
            Integer value = res.get("value");
            Filter[] filters = getFiltersFromFilter(filter, value);
            ChatRoom chatRoom;
            if (otherRoomId!=null) {
                if (otherHost==null)
                    throw new TrackParsingException("Unknown chat host. Use one of STACK_OVERFLOW or STACK_EXCHANGE");
                chatRoom = getChatRoom(otherRoomId, otherHost);
            }
            else {
                chatRoom = new ChatRoom(room);
            }

            chatRoom.getRoom().send("Tracking "+posttype+" on "+site+ " as directed in ["+room.getThumbs().getName()
                    +"]("+ room.getHost().getBaseUrl()+"/rooms/"+room.getRoomId()+")");
            Monitor[] monitors = getMonitors(site, posttype, frequency, chatRoom, filters);
            if(monitors==null) {
                room.send("The only types supported are questions, answers and tags");
            }
            else {
                ChatRoomService service;
                String ID = getUniqueId();
                service = new ChatRoomService(chatRoom, monitors);
                String similarRoom;
                similarRoom = findChatRoomByRoomId(chatRoom.getRoomId());
                if (similarRoom == null && chatRoom.getRoomId() != room.getRoomId()) {
                    service.initializeService();
                }
                service.startService();
                bots.put(ID, new Bot(ID, chatRoom, service,
                        room.getHost().getBaseUrl() + "/messages/" + message.getId() + "/history"));
                room.send("New tracker started: [" + ID + "](" + bots.get(ID).getCreationMessageUrl() + ")");
            }
        }
        catch (TrackParsingException e){
            room.send("    "+e.getMessage().replace("\n", "\n    "));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private Filter[] getFiltersFromFilter(Filters filter, Integer value) {


        switch (filter){
            case HEAT_DETECTOR:
                break;
            case ALL_POSTS:
                break;
            case REPUTATION:
                return new Filter[]{new ReputationFilter(value)};
            case CREATION_DATE:
                break;
            case LENGTH:
                return new Filter[]{new LengthFilter(value)};
        }

        return new Filter[]{new EmptyFilter()};
    }

    private String getUniqueId() {
        char[] characs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random secureRandom = new SecureRandom();
        StringBuilder ID = new StringBuilder();
        for (int i = 0; i < 10; i++)
            ID.append(characs[secureRandom.nextInt(characs.length)]);
        return ID.toString();
    }

    private Monitor[] getMonitors(String site, Type posttype, int frequency, ChatRoom chatRoom) {
        return getMonitors(site, posttype, frequency, chatRoom, new Filter[]{new EmptyFilter<>()});
    }
    private Monitor[] getMonitors(String site, Type posttype, int frequency, ChatRoom chatRoom, Filter[] filters) {

        Monitor[] monitors = null;
        String apiKey = "HYWHTHpYImfSRnhkArqu8Q((";

        switch (posttype) {
            case questions:
                monitors = new Monitor[]{new QuestionMonitor(chatRoom, frequency, site, apiKey, filters,
                        new GenericContentPrinterService<>(site))};
                break;
            case answers:
                monitors = new Monitor[]{new AnswerMonitor(chatRoom, frequency, site, apiKey, filters,
                        new GenericContentPrinterService<>(site))};
                break;
            case comments:
                monitors = new Monitor[]{new CommentMonitor(chatRoom, frequency, site, apiKey, filters,
                        new CommentOneBoxPrinter<>(chatRoom))};
                break;
            case tags:
                monitors = new Monitor[]{new TagMonitor(chatRoom, frequency, site, apiKey, filters,
                        new ListOfTagsPrinter(site))};
                break;
        }
        return monitors;
    }

    private ChatRoom getChatRoom(int otherRoomId, ChatHost otherRoomHost) {
        ChatRoom chatRoom;
        Room otherRoom = client.joinRoom(otherRoomHost, otherRoomId);
        otherRoom.send("Boson started");
        chatRoom = new ChatRoom(otherRoom);
        Map<Command, Object[]> userMentionCommands = new HashMap<>();
        userMentionCommands.put(new Alive(), new Object[0]);
        chatRoom.setUserMentionedEventConsumer(new UserMentionedListener().getUserMentionedEventConsumer(otherRoom, userMentionCommands));

        Map<Command, Object[]> messageReplyCommands = new HashMap<>();
        messageReplyCommands.put(new Alive(), new Object[0]);
        chatRoom.setMessageReplyEventConsumer(new MessageReplyEventListener().getMessageReplyEventListener(otherRoom, messageReplyCommands));
        return chatRoom;
    }

    private String findChatRoomByRoomId(int roomId){
        for (String key: bots.keySet()){
            System.out.println("Searching "+key+" for roomID "+roomId);
            Bot bot = bots.get(key);
            if(bot.getChatRoom().getRoomId()==roomId){
                System.out.println("Found "+key + "for roomID "+roomId);
                return key;
            }
        }
        return null;
    }

    private Namespace parseArguments(String[] args) throws TrackParsingException {

        ArgumentParser parser = ArgumentParsers.newFor("track").addHelp(false).build()
                .description("Argument Parser for the bot.");
        parser.addArgument("site").type(String.class)
                .help("Site where the bot has to be run");
        parser.addArgument("type").type(Type.class).metavar("type")
                .help("Type of the tracker needed. Can be one of {questions,answers,comments,posts,tags}");
        parser.addArgument("frequency").type(Integer.class)
                .help("Frequency of the tracker in seconds");


        parser.addArgument("-r", "--room").type(Integer.class).nargs("?")
                .help("Set the room where it has to run");

        parser.addArgument("-t", "--host").type(ChatHost.class).nargs("?")
                .choices(ChatHost.STACK_OVERFLOW, ChatHost.STACK_EXCHANGE)
                .help("Set the chat host of that room");

        parser.addArgument("-f", "--filter").type(Filters.class).nargs("?")
                .help("Set the filters used by the bot");

        parser.addArgument("-v", "--value").type(Integer.class).nargs("?")
                .help("Set the value needed for the filter, depending on it's type");

        parser.addArgument("-h", "--help").action(new BosonHelpArgumentAction())
                .help("Display this message");

        Namespace res;
        try {
            res = parser.parseArgs(args);
        } catch (BosonHelpScreenParserException e){
            throw new TrackParsingException(e.getParserMessage());
        } catch (ArgumentParserException e){
            StringWriter out = new StringWriter();
            PrintWriter writer = new PrintWriter(out);
            parser.handleError(e, writer);
            throw new TrackParsingException(out.toString());
        }
        System.out.println(res);

        return res;
    }


}





