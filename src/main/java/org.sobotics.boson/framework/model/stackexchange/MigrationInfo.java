package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;

public class MigrationInfo {
    private Instant onDate;
    private Site otherSite;
    private int questionId;

    public MigrationInfo(Instant onDate, Site otherSite, int questionId) {
        this.onDate = onDate;
        this.otherSite = otherSite;
        this.questionId = questionId;
    }

    public MigrationInfo() {
    }

    public Instant getOnDate() {
        return onDate;
    }

    public void setOnDate(Instant onDate) {
        this.onDate = onDate;
    }

    public Site getOtherSite() {
        return otherSite;
    }

    public void setOtherSite(Site otherSite) {
        this.otherSite = otherSite;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "MigrationInfo{" +
                "onDate=" + onDate +
                ", otherSite=" + otherSite +
                ", questionId=" + questionId +
                '}';
    }
}
