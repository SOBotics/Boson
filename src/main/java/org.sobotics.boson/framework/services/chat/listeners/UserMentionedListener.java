package org.sobotics.boson.framework.services.chat.listeners;

import org.sobotics.boson.framework.services.chat.commands.Command;
import org.sobotics.chatexchange.chat.Message;
import org.sobotics.chatexchange.chat.Room;
import org.sobotics.chatexchange.chat.event.PingMessageEvent;
import org.sobotics.chatexchange.chat.event.UserMentionedEvent;

import java.util.Map;
import java.util.function.Consumer;

public class UserMentionedListener {
    public Consumer<UserMentionedEvent> getUserMentionedEventConsumer(Room room, Map<Command, Object[]> commands){
        return event -> mention(room, event, commands);
    }

    private void mention(Room room, PingMessageEvent event, Map<Command, Object[]> commands) {
        Message message = event.getMessage();
        for(Command command: commands.keySet()){
            if(command.matches(message)){
                command.execute(message, room, commands.get(command));
            }
        }
    }
}
