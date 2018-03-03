package org.sobotics.boson.sample;

import fr.tunaki.stackoverflow.chat.Room;
import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.commands.Command;
import org.sobotics.boson.framework.services.chat.listeners.MessageReplyEventListener;
import org.sobotics.boson.framework.services.chat.listeners.UserMentionedListener;
import org.sobotics.boson.sample.commands.Alive;

import java.util.HashMap;
import java.util.Map;

public class SampleRoom {
    public ChatRoom getSampleRoom(Room room){
        ChatRoom chatRoom = new ChatRoom(room.getRoomId(), room.getHost(), room);

        Map<Command, Object[]> userMentionCommands = new HashMap<>();
        userMentionCommands.put(new Alive(), new Object[0]);
        chatRoom.setUserMentionedEventConsumer(new UserMentionedListener().getUserMentionedEventConsumer(room, userMentionCommands));


        Map<Command, Object[]> messageReplyCommands = new HashMap<>();
        messageReplyCommands.put(new Alive(), new Object[0]);
        chatRoom.setMessageReplyEventConsumer(new MessageReplyEventListener().getMessageReplyEventListener(room, messageReplyCommands));



        return chatRoom;
    }
}
