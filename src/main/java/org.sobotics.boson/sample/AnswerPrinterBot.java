package org.sobotics.boson.sample;

import fr.tunaki.stackoverflow.chat.Room;
import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Answer;
import org.sobotics.boson.framework.services.chat.ChatRoomService;
import org.sobotics.boson.framework.services.chat.commands.Alive;
import org.sobotics.boson.framework.services.chat.commands.Command;
import org.sobotics.boson.framework.services.chat.filters.EmptyFilter;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.listeners.MessageReplyEventListener;
import org.sobotics.boson.framework.services.chat.listeners.UserMentionedListener;
import org.sobotics.boson.framework.services.chat.monitors.AnswerMonitor;
import org.sobotics.boson.framework.services.chat.monitors.Monitor;
import org.sobotics.boson.framework.services.chat.printers.GenericContentPrinterService;

import java.util.HashMap;
import java.util.Map;

public class AnswerPrinterBot {

    private Room room;
    private String site;
    private int frequency;

    public AnswerPrinterBot(Room room, String site, int frequency) {
        this.room = room;
        this.site = site;
        this.frequency = frequency;
    }

    public void start(){
        ChatRoom chatRoom = new ChatRoom(room.getRoomId(), room.getHost(), room);

        Map<Command, Object[]> userMentionCommands = new HashMap<>();
        userMentionCommands.put(new Alive(), new Object[0]);
        chatRoom.setUserMentionedEventConsumer(new UserMentionedListener().getUserMentionedEventConsumer(room, userMentionCommands));


        Map<Command, Object[]> messageReplyCommands = new HashMap<>();
        messageReplyCommands.put(new Alive(), new Object[0]);
        chatRoom.setMessageReplyEventConsumer(new MessageReplyEventListener().getMessageReplyEventListener(room, messageReplyCommands));

        Filter[]  filters = {new EmptyFilter<Answer>()};
        Monitor[] monitors = {new AnswerMonitor(chatRoom, frequency, site, filters, new GenericContentPrinterService<Answer>(site))};

        ChatRoomService service = new ChatRoomService(chatRoom, monitors);
        service.startService();

    }
}
