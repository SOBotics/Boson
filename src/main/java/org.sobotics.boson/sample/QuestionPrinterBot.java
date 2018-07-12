package org.sobotics.boson.sample;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.ChatRoomService;
import org.sobotics.boson.framework.services.chat.filters.Filter;
import org.sobotics.boson.framework.services.chat.monitors.Monitor;
import org.sobotics.boson.framework.services.chat.monitors.QuestionMonitor;
import org.sobotics.boson.framework.services.chat.printers.CloseVoteQuestionPrinter;
import org.sobotics.chatexchange.chat.Room;

public class QuestionPrinterBot {

    private Room room;
    private String site;
    private int frequency;

    public QuestionPrinterBot(Room room, String site, int frequency) {
        this.room = room;
        this.site = site;
        this.frequency = frequency;
    }

    public void start(){
        ChatRoom chatRoom = new ChatRoom(room.getRoomId(), room.getHost(), room);

        Filter[]  filters = {};//{new HasCloseVoteFilter(3)};
        Monitor[] monitors = {new QuestionMonitor(chatRoom, frequency, site, "", filters, new CloseVoteQuestionPrinter(site))};

        ChatRoomService service = new ChatRoomService(chatRoom, monitors);
        service.startService();

    }
}
