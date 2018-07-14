package org.sobotics.boson.bot;


import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.model.stackexchange.Comment;
import org.sobotics.boson.framework.model.stackexchange.Question;
import org.sobotics.boson.framework.model.stackexchange.Tag;
import org.sobotics.boson.framework.services.chat.ChatRoomService;
import org.sobotics.boson.framework.services.chat.commands.Alive;
import org.sobotics.boson.framework.services.chat.commands.Command;
import org.sobotics.boson.framework.services.chat.filters.EmptyFilter;
import org.sobotics.boson.framework.services.chat.filters.Filter;
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

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BosonBot {

    private Room room;
    private StackExchangeClient client;
    private Map<String, Bot> bots;

    public BosonBot(Room room, StackExchangeClient client) {
        this.room = room;
        this.client = client;
        this.bots = new HashMap<>();
    }

    public void start(){
        room.send("Boson Started");
        room.addEventListener(EventType.USER_MENTIONED, event-> {
            Message message = event.getMessage();
            System.out.println(message.getPlainContent());
            String arguments[] = message.getPlainContent().split(" ");
            switch (arguments[1]) {
                case "track":
                    trackCommand(message);
                    break;
                case "help":
                    room.send("Use the command `track sitename posttype frequency [roomID chatServer]` to start tracking sites");
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

    private void listCommand() {
        room.send(String.join(";", bots.keySet()));
    }

    private void stopCommand(String argument) {
        if(bots.containsKey(argument)) {
            bots.get(argument).getChatRoomService().stopService();
            if (findChatRoomByRoomId(bots.get(argument).getChatRoom().getRoomId())==null &&
                    bots.get(argument).getChatRoom().getRoomId()!=room.getRoomId()){
                bots.get(argument).getChatRoomService().terminateService();
            }
            bots.remove(argument);
            room.send("Bot "+ argument +" stopped");
        }
        else {
            room.send("Wrong bot ID");
        }
    }

    private void trackCommand(Message message) {
        String arguments1[] = message.getPlainContent().split(" ");
        if (arguments1.length == 5 || arguments1.length == 7) {
            String site = arguments1[2];
            String posttype = arguments1[3];
            int frequency = Integer.parseInt(arguments1[4]);
            ChatRoom chatRoom = getChatRoom(room, arguments1);
            Monitor[] monitors = getMonitors(site, posttype, frequency, chatRoom);
            if(monitors==null) {
                room.send("The only types supported are questions, answers and tags");
            }
            else {
                ChatRoomService service;
                String ID = getUniqueId();
                service = new ChatRoomService(chatRoom, monitors);
                String similarRoom;
                if (chatRoom != null) {
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
        }
        else {
            room.send("Wrong arguments sent.");
        }
    }

    private String getUniqueId() {
        char[] characs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random secureRandom = new SecureRandom();
        StringBuilder ID = new StringBuilder();
        for (int i = 0; i < 10; i++)
            ID.append(characs[secureRandom.nextInt(characs.length)]);
        return ID.toString();
    }

    private Monitor[] getMonitors(String site, String posttype, int frequency, ChatRoom chatRoom) {
        Filter[] filters;
        Monitor[] monitors = null;
        String apiKey = "HYWHTHpYImfSRnhkArqu8Q((";

        switch (posttype) {
            case "question":
            case "questions":
                filters = new Filter[]{new EmptyFilter<Question>()};
                monitors = new Monitor[]{new QuestionMonitor(chatRoom, frequency, site, apiKey, filters,
                        new GenericContentPrinterService<>(site))};
                break;
            case "answer":
            case "answers":
                filters = new Filter[]{new EmptyFilter<Answer>()};
                monitors = new Monitor[]{new AnswerMonitor(chatRoom, frequency, site, apiKey, filters,
                        new GenericContentPrinterService<>(site))};
                break;
            case "comment":
            case "comments":
                filters = new Filter[]{new EmptyFilter<Comment>()};
                monitors = new Monitor[]{new CommentMonitor(chatRoom, frequency, site, apiKey, filters,
                        new CommentOneBoxPrinter<>(chatRoom))};
                break;
            case "tag":
            case "tags":
                filters = new Filter[]{new EmptyFilter<Tag>()};
                monitors = new Monitor[]{new TagMonitor(chatRoom, frequency, site, apiKey, filters,
                        new ListOfTagsPrinter(site))};
                break;
        }
        return monitors;
    }

    private ChatRoom getChatRoom(Room room, String[] arguments) {
        int otherRoomId;
        ChatHost otherRoomHost;
        ChatRoom chatRoom = new ChatRoom(room);
        if (arguments.length == 7) {
            otherRoomId = Integer.parseInt(arguments[5]);
            switch (arguments[6]) {
                case "stackoverflow":
                    otherRoomHost = ChatHost.STACK_OVERFLOW;
                    break;
                case "stackexchange":
                    otherRoomHost = ChatHost.STACK_EXCHANGE;
                    break;
                default:
                    room.send("Chat host can either be `sstackoverflow` or `stackexchange`");
                    return null;
            }

            Room otherRoom = client.joinRoom(otherRoomHost, otherRoomId);
            otherRoom.send("Boson started");

            chatRoom = new ChatRoom(otherRoom);
            Map<Command, Object[]> userMentionCommands = new HashMap<>();
            userMentionCommands.put(new Alive(), new Object[0]);
            chatRoom.setUserMentionedEventConsumer(new UserMentionedListener().getUserMentionedEventConsumer(otherRoom, userMentionCommands));

            Map<Command, Object[]> messageReplyCommands = new HashMap<>();
            messageReplyCommands.put(new Alive(), new Object[0]);
            chatRoom.setMessageReplyEventConsumer(new MessageReplyEventListener().getMessageReplyEventListener(otherRoom, messageReplyCommands));

        }
        chatRoom.getRoom().send("Tracking "+arguments[3]+" on "+arguments[2]+ " as directed in ["+room.getThumbs().getName()
                +"]("+ room.getHost().getBaseUrl()+"/rooms/"+room.getRoomId()+")");
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

}
