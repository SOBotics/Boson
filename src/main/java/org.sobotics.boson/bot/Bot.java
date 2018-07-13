package org.sobotics.boson.bot;

import org.sobotics.boson.framework.model.chat.ChatRoom;
import org.sobotics.boson.framework.services.chat.ChatRoomService;

public class Bot {
    private String identifier;
    private ChatRoom chatRoom;
    private ChatRoomService chatRoomService;
    private String creationMessageUrl;

    public Bot(String identifier, ChatRoom chatRoom, ChatRoomService chatRoomService, String creationMessageUrl) {
        this.identifier = identifier;
        this.chatRoom = chatRoom;
        this.chatRoomService = chatRoomService;
        this.creationMessageUrl = creationMessageUrl;
    }

    public Bot(String identifier, ChatRoom chatRoom, ChatRoomService chatRoomService, long messageId) {
        this.identifier = identifier;
        this.chatRoom = chatRoom;
        this.chatRoomService = chatRoomService;
        this.creationMessageUrl = chatRoom.getChatHost().getBaseUrl()+"/messages/"+messageId+"/history";
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ChatRoomService getChatRoomService() {
        return chatRoomService;
    }

    public void setChatRoomService(ChatRoomService chatRoomService) {
        this.chatRoomService = chatRoomService;
    }

    public String getCreationMessageUrl() {
        return creationMessageUrl;
    }

    public void setCreationMessageUrl(String creationMessageUrl) {
        this.creationMessageUrl = creationMessageUrl;
    }

    public ChatRoom getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "identifier='" + identifier + '\'' +
                ", chatRoom=" + chatRoom +
                ", chatRoomService=" + chatRoomService +
                ", creationMessageUrl='" + creationMessageUrl + '\'' +
                '}';
    }
}
