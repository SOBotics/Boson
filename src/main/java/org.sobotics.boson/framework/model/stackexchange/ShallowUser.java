package org.sobotics.boson.framework.model.stackexchange;

public class ShallowUser {
    private int acceptRate;
    private BadgeCount badgeCounts;
    private String displayName;
    private String link;
    private String profileImage;
    private int reputation;
    private int userId;
    private String userType;

    public ShallowUser(int acceptRate, BadgeCount badgeCounts, String displayName, String link, String profileImage, int reputation, int userId, String userType) {
        this.acceptRate = acceptRate;
        this.badgeCounts = badgeCounts;
        this.displayName = displayName;
        this.link = link;
        this.profileImage = profileImage;
        this.reputation = reputation;
        this.userId = userId;
        this.userType = userType;
    }

    public ShallowUser() {
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(int acceptRate) {
        this.acceptRate = acceptRate;
    }

    public BadgeCount getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(BadgeCount badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "ShallowUser{" +
                "acceptRate=" + acceptRate +
                ", badgeCounts=" + badgeCounts +
                ", displayName='" + displayName + '\'' +
                ", link='" + link + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", reputation=" + reputation +
                ", userId=" + userId +
                ", userType='" + userType + '\'' +
                '}';
    }
}
