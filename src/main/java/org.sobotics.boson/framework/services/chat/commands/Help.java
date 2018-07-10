package org.sobotics.boson.framework.services.chat.commands;

import fr.tunaki.stackoverflow.chat.Message;
import fr.tunaki.stackoverflow.chat.Room;

public class Help implements Command {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "returns the description of the bot";
    }

    @Override
    public boolean matches(Message message) {
        return message.getPlainContent().contains("help");
    }

    @Override
    public void execute(Message message, Room room, Object... data) {
        room.send("*helps*");
    }
}
