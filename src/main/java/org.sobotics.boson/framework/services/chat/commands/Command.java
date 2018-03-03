package org.sobotics.boson.framework.services.chat.commands;

import fr.tunaki.stackoverflow.chat.Message;
import fr.tunaki.stackoverflow.chat.Room;

public interface Command {
    String getName();
    String getDescription();
    boolean matches(Message message);
    void execute(Message message, Room room, Object... data);
}
