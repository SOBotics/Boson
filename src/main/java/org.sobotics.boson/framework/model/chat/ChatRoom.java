package org.sobotics.boson.framework.model.chat;

import fr.tunaki.stackoverflow.chat.ChatHost;
import fr.tunaki.stackoverflow.chat.Room;
import fr.tunaki.stackoverflow.chat.event.*;

import java.util.function.Consumer;

public class ChatRoom {
    private int roomId;
    private ChatHost chatHost;
    private Room room;
    private Consumer<UserMentionedEvent> userMentionedEventConsumer;
    private Consumer<MessageReplyEvent> messageReplyEventConsumer;
    private Consumer<MessageEditedEvent> messageEditedEventConsumer;
    private Consumer<MessagePostedEvent> messagePostedEventConsumer;
    private Consumer<UserEnteredEvent> userEnteredEventConsumer;
    private Consumer<UserLeftEvent> userLeftEventConsumer;
    private Consumer<MessageStarredEvent> messageStarredEventConsumer;
    private Consumer<MessageDeletedEvent> messageDeletedEventConsumer;
    private Consumer<KickedEvent> kickedEventConsumer;

    public ChatRoom(int roomId, ChatHost chatHost, Room room, Consumer<UserMentionedEvent> userMentionedEventConsumer, Consumer<MessageReplyEvent> messageReplyEventConsumer, Consumer<MessageEditedEvent> messageEditedEventConsumer, Consumer<MessagePostedEvent> messagePostedEventConsumer, Consumer<UserEnteredEvent> userEnteredEventConsumer, Consumer<UserLeftEvent> userLeftEventConsumer, Consumer<MessageStarredEvent> messageStarredEventConsumer, Consumer<MessageDeletedEvent> messageDeletedEventConsumer, Consumer<KickedEvent> kickedEventConsumer) {
        this.roomId = roomId;
        this.chatHost = chatHost;
        this.room = room;
        this.userMentionedEventConsumer = userMentionedEventConsumer;
        this.messageReplyEventConsumer = messageReplyEventConsumer;
        this.messageEditedEventConsumer = messageEditedEventConsumer;
        this.messagePostedEventConsumer = messagePostedEventConsumer;
        this.userEnteredEventConsumer = userEnteredEventConsumer;
        this.userLeftEventConsumer = userLeftEventConsumer;
        this.messageStarredEventConsumer = messageStarredEventConsumer;
        this.messageDeletedEventConsumer = messageDeletedEventConsumer;
        this.kickedEventConsumer = kickedEventConsumer;
    }

    public ChatRoom(int roomId, ChatHost chatHost, Room room) {
        this.roomId = roomId;
        this.chatHost = chatHost;
        this.room = room;
        this.userMentionedEventConsumer = null;
        this.messageReplyEventConsumer = null;
        this.messageEditedEventConsumer = null;
        this.messagePostedEventConsumer = null;
        this.userEnteredEventConsumer = null;
        this.userLeftEventConsumer = null;
        this.messageStarredEventConsumer = null;
        this.messageDeletedEventConsumer = null;
        this.kickedEventConsumer = null;
    }

    public ChatRoom() {
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public ChatHost getChatHost() {
        return chatHost;
    }

    public void setChatHost(ChatHost chatHost) {
        this.chatHost = chatHost;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Consumer<UserMentionedEvent> getUserMentionedEventConsumer() {
        return userMentionedEventConsumer;
    }

    public void setUserMentionedEventConsumer(Consumer<UserMentionedEvent> userMentionedEventConsumer) {
        this.userMentionedEventConsumer = userMentionedEventConsumer;
    }

    public Consumer<MessageReplyEvent> getMessageReplyEventConsumer() {
        return messageReplyEventConsumer;
    }

    public void setMessageReplyEventConsumer(Consumer<MessageReplyEvent> messageReplyEventConsumer) {
        this.messageReplyEventConsumer = messageReplyEventConsumer;
    }

    public Consumer<MessageEditedEvent> getMessageEditedEventConsumer() {
        return messageEditedEventConsumer;
    }

    public void setMessageEditedEventConsumer(Consumer<MessageEditedEvent> messageEditedEventConsumer) {
        this.messageEditedEventConsumer = messageEditedEventConsumer;
    }

    public Consumer<MessagePostedEvent> getMessagePostedEventConsumer() {
        return messagePostedEventConsumer;
    }

    public void setMessagePostedEventConsumer(Consumer<MessagePostedEvent> messagePostedEventConsumer) {
        this.messagePostedEventConsumer = messagePostedEventConsumer;
    }

    public Consumer<UserEnteredEvent> getUserEnteredEventConsumer() {
        return userEnteredEventConsumer;
    }

    public void setUserEnteredEventConsumer(Consumer<UserEnteredEvent> userEnteredEventConsumer) {
        this.userEnteredEventConsumer = userEnteredEventConsumer;
    }

    public Consumer<UserLeftEvent> getUserLeftEventConsumer() {
        return userLeftEventConsumer;
    }

    public void setUserLeftEventConsumer(Consumer<UserLeftEvent> userLeftEventConsumer) {
        this.userLeftEventConsumer = userLeftEventConsumer;
    }

    public Consumer<MessageStarredEvent> getMessageStarredEventConsumer() {
        return messageStarredEventConsumer;
    }

    public void setMessageStarredEventConsumer(Consumer<MessageStarredEvent> messageStarredEventConsumer) {
        this.messageStarredEventConsumer = messageStarredEventConsumer;
    }

    public Consumer<MessageDeletedEvent> getMessageDeletedEventConsumer() {
        return messageDeletedEventConsumer;
    }

    public void setMessageDeletedEventConsumer(Consumer<MessageDeletedEvent> messageDeletedEventConsumer) {
        this.messageDeletedEventConsumer = messageDeletedEventConsumer;
    }

    public Consumer<KickedEvent> getKickedEventConsumer() {
        return kickedEventConsumer;
    }

    public void setKickedEventConsumer(Consumer<KickedEvent> kickedEventConsumer) {
        this.kickedEventConsumer = kickedEventConsumer;
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "roomId=" + roomId +
                ", chatHost=" + chatHost +
                ", room=" + room +
                ", userMentionedEventConsumer=" + userMentionedEventConsumer +
                ", messageReplyEventConsumer=" + messageReplyEventConsumer +
                ", messageEditedEventConsumer=" + messageEditedEventConsumer +
                ", messagePostedEventConsumer=" + messagePostedEventConsumer +
                ", userEnteredEventConsumer=" + userEnteredEventConsumer +
                ", userLeftEventConsumer=" + userLeftEventConsumer +
                ", messageStarredEventConsumer=" + messageStarredEventConsumer +
                ", messageDeletedEventConsumer=" + messageDeletedEventConsumer +
                ", kickedEventConsumer=" + kickedEventConsumer +
                '}';
    }
}
