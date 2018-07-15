package org.sobotics.boson.framework.services.chat.printers;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.model.stackexchange.Content;

public class ContentOneBoxPrinter<T extends Content> implements PrinterService<T>{
    private ChatRoom chatRoom;

    public ContentOneBoxPrinter(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String print(T content){
        chatRoom.getRoom().send("[ [Boson](https://git.io/vA9TM) ] New "+ content.getType()+
                " posted by [" + content.getOwner().getDisplayName()+"]("+content.getOwner().getLink()+")" );
        return content.getLink();
    }
}
