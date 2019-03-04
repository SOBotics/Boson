package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Comment;

public class HeatDetectorPrinter extends SpecialPrinterService<Comment> {

    private ChatRoom chatRoom;

    public HeatDetectorPrinter(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @Override
    public String print(Comment comment, String dashboard, String intro, String message) {
        String display_message = "New heated comment: " + message;
        chatRoom.getRoom().send(getFinalPrintString(dashboard, intro, display_message));
        return print(comment, dashboard, intro);
    }

    @Override
    public String print(Comment comment, String dashboard, String intro) {
        return comment.getLink();
    }


}
