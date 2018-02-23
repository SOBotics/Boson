package org.sobotics.boson.framework.model.stackexchange;

import java.util.Arrays;

public class ClosedDetails {
    private ShallowUser[] byUsers;
    private String description;
    private boolean onHold;
    private OriginalQuestion[] originalQuestions;
    private String reason;


    public ClosedDetails(ShallowUser[] byUsers, String description, boolean onHold, OriginalQuestion[] originalQuestions, String reason) {
        this.byUsers = byUsers;
        this.description = description;
        this.onHold = onHold;
        this.originalQuestions = originalQuestions;
        this.reason = reason;
    }

    public ClosedDetails() {
    }

    public ShallowUser[] getByUsers() {
        return byUsers;
    }

    public void setByUsers(ShallowUser[] byUsers) {
        this.byUsers = byUsers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnHold() {
        return onHold;
    }

    public void setOnHold(boolean onHold) {
        this.onHold = onHold;
    }

    public OriginalQuestion[] getOriginalQuestions() {
        return originalQuestions;
    }

    public void setOriginalQuestions(OriginalQuestion[] originalQuestions) {
        this.originalQuestions = originalQuestions;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ClosedDetails{" +
                "byUsers=" + Arrays.toString(byUsers) +
                ", description='" + description + '\'' +
                ", onHold=" + onHold +
                ", originalQuestions=" + Arrays.toString(originalQuestions) +
                ", reason='" + reason + '\'' +
                '}';
    }
}
