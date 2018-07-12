package org.sobotics.boson.framework.services.chat.commands;

import org.sobotics.chatexchange.chat.Message;
import org.sobotics.chatexchange.chat.Room;

public interface Command {
    String getName();
    String getDescription();
    boolean matches(Message message);
    void execute(Message message, Room room, Object... data);
}
