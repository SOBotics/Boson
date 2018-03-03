package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;

public interface Content {

    String getBody();
    String getLink();
    ShallowUser getOwner();
    Instant getCreationDate();
    int getScore();


    void setBody(String body);
    void setLink(String link);
    void setOwner(ShallowUser owner);
    void setCreationDate(Instant creationDate);
    void setScore(int score);

    String getType();
}
