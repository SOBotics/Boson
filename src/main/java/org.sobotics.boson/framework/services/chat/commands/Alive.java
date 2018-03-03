package org.sobotics.boson.framework.services.chat.commands;

import fr.tunaki.stackoverflow.chat.Message;
import fr.tunaki.stackoverflow.chat.Room;

public class Alive implements Command {
    @Override
    public String getName() {
        return "alive";
    }

    @Override
    public String getDescription() {
        return "returns a sample response if the bot is alive";
    }

    @Override
    public boolean matches(Message message) {
        return message.getPlainContent().contains("alive");
    }

    @Override
    public void execute(Message message, Room room, Object... data) {
        room.send("Yes, I am alive");
    }
}
