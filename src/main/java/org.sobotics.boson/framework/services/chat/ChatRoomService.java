package org.sobotics.boson.framework.services.chat;

import fr.tunaki.stackoverflow.chat.event.EventType;
import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.monitors.Monitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

public class ChatRoomService {
    private ChatRoom chatRoom;
    private Monitor[] monitors;

    public ChatRoomService(ChatRoom chatRoom, Monitor[] monitors) {
        this.chatRoom = chatRoom;
        this.monitors = monitors;
    }

    public void startService(){
        if (chatRoom.getUserMentionedEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.USER_MENTIONED, chatRoom.getUserMentionedEventConsumer());

        if (chatRoom.getMessageReplyEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.MESSAGE_REPLY, chatRoom.getMessageReplyEventConsumer());

        if (chatRoom.getMessageEditedEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.MESSAGE_EDITED, chatRoom.getMessageEditedEventConsumer());

        if (chatRoom.getMessagePostedEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.MESSAGE_POSTED, chatRoom.getMessagePostedEventConsumer());

        if (chatRoom.getUserEnteredEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.USER_ENTERED, chatRoom.getUserEnteredEventConsumer());

        if (chatRoom.getUserLeftEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.USER_LEFT, chatRoom.getUserLeftEventConsumer());

        if (chatRoom.getMessageStarredEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.MESSAGE_STARRED, chatRoom.getMessageStarredEventConsumer());

        if (chatRoom.getMessageDeletedEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.MESSAGE_DELETED, chatRoom.getMessageDeletedEventConsumer());

        if (chatRoom.getKickedEventConsumer()!=null)
            chatRoom.getRoom().addEventListener(EventType.KICKED, chatRoom.getKickedEventConsumer());

        List<ScheduledExecutorService> services = new ArrayList<>();
        for(Monitor monitor: monitors){
            services.add(monitor.startMonitor());
        }
    }
}
