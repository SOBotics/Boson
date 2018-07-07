package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;
import java.util.Arrays;

public class Tag {

    private int count;
    private boolean hasSynonyms;
    private boolean isModeratorOnly;
    private boolean isRequired;
    private Instant lastActivityDate;
    private String name;
    private String[] synonyms;
    private Integer userId;


    public Tag(int count, boolean hasSynonyms, boolean isModeratorOnly, boolean isRequired, Instant lastActivityDate, String name, String[] synonyms, Integer userId) {
        this.count = count;
        this.hasSynonyms = hasSynonyms;
        this.isModeratorOnly = isModeratorOnly;
        this.isRequired = isRequired;
        this.lastActivityDate = lastActivityDate;
        this.name = name;
        this.synonyms = synonyms;
        this.userId = userId;
    }

    public Tag() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isHasSynonyms() {
        return hasSynonyms;
    }

    public void setHasSynonyms(boolean hasSynonyms) {
        this.hasSynonyms = hasSynonyms;
    }

    public boolean isModeratorOnly() {
        return isModeratorOnly;
    }

    public void setModeratorOnly(boolean moderatorOnly) {
        isModeratorOnly = moderatorOnly;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public Instant getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Instant lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "count=" + count +
                ", hasSynonyms=" + hasSynonyms +
                ", isModeratorOnly=" + isModeratorOnly +
                ", isRequired=" + isRequired +
                ", lastActivityDate=" + lastActivityDate +
                ", name='" + name + '\'' +
                ", synonyms=" + Arrays.toString(synonyms) +
                ", userId=" + userId +
                '}';
    }
}
