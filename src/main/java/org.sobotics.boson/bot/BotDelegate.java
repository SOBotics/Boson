package org.sobotics.boson.bot;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.ChatRoomService;
import org.sobotics.boson.framework.services.chat.monitors.Monitor;
import org.sobotics.chatexchange.chat.Room;

public class BotDelegate {

    private Room room;
    private Monitor[] monitors;

    public BotDelegate(Room room, Monitor[] monitors) {
        this.room = room;
        this.monitors = monitors;
    }

    public void start(){
        ChatRoom chatRoom = new ChatRoom(room.getRoomId(), room.getHost(), room);
        ChatRoomService service = new ChatRoomService(chatRoom, monitors);
        service.startService();
    }
}
