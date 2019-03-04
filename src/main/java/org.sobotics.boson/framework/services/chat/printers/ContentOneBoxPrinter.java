package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Content;

public class ContentOneBoxPrinter<T extends Content> extends PrinterService<T>{
    private ChatRoom chatRoom;

    public ContentOneBoxPrinter(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String print(T content, String dashboard, String intro){
        String message = "New " + content.getType() +
                " posted by [" + content.getOwner().getDisplayName() + "](" + content.getOwner().getLink() + ")";
        chatRoom.getRoom().send(getFinalPrintString(dashboard, intro, message));
        return content.getLink();
    }
}
