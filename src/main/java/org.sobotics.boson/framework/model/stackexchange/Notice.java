package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;

public class Notice {
    private String body;
    private Instant creationDate;
    private int ownerUserId;

    public Notice(String body, Instant creationDate, int ownerUserId) {
        this.body = body;
        this.creationDate = creationDate;
        this.ownerUserId = ownerUserId;
    }

    public Notice() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public int getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(int ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "body='" + body + '\'' +
                ", creationDate=" + creationDate +
                ", ownerUserId=" + ownerUserId +
                '}';
    }
}
