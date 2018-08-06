package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Comment;

public class HeatDetectorPrinter implements SpecialPrinterService<Comment> {

    private ChatRoom chatRoom;

    public HeatDetectorPrinter(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @Override
    public String print(Comment comment, String message) {
        chatRoom.getRoom().send("[ [Boson](https://git.io/vA9TM) ] New heated comment: "+message );
        return print(comment);
    }

    @Override
    public String print(Comment comment) {
        return comment.getLink();
    }
}
