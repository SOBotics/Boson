package org.sobotics.boson.framework.model.stackexchange;

import com.google.gson.JsonObject;

import java.time.Instant;

public class User {

    private String aboutMe;
    private int acceptRate;
    private int accountId;
    private int age;
    private int answerCount;
    private BadgeCount badgeCounts;
    private Instant creationDate;
    private String displayName;
    private int downVoteCount;
    private boolean isEmployee;
    private Instant lastAccessDate;
    private Instant lastModifiedDate;
    private String link;
    private String location;
    private String profileImage;
    private int questionCount;
    private int reputation;
    private int reputationChangeDay;
    private int reputationChangeMonth;
    private int reputationChangeQuarter;
    private int reputationChangeWeek;
    private int reputationChangeYear;
    private Instant timedPenaltyDate;
    private int upVoteCount;
    private int userId;
    private String userType;
    private int viewCount;
    private String websiteUrl;

    public User(String aboutMe, int acceptRate, int accountId, int age, int answerCount, BadgeCount badgeCounts, Instant creationDate, String displayName, int downVoteCount, boolean isEmployee, Instant lastAccessDate, Instant lastModifiedDate, String link, String location, String profileImage, int questionCount, int reputation, int reputationChangeDay, int reputationChangeMonth, int reputationChangeQuarter, int reputationChangeWeek, int reputationChangeYear, Instant timedPenaltyDate, int upVoteCount, int userId, String userType, int viewCount, String websiteUrl) {
        this.aboutMe = aboutMe;
        this.acceptRate = acceptRate;
        this.accountId = accountId;
        this.age = age;
        this.answerCount = answerCount;
        this.badgeCounts = badgeCounts;
        this.creationDate = creationDate;
        this.displayName = displayName;
        this.downVoteCount = downVoteCount;
        this.isEmployee = isEmployee;
        this.lastAccessDate = lastAccessDate;
        this.lastModifiedDate = lastModifiedDate;
        this.link = link;
        this.location = location;
        this.profileImage = profileImage;
        this.questionCount = questionCount;
        this.reputation = reputation;
        this.reputationChangeDay = reputationChangeDay;
        this.reputationChangeMonth = reputationChangeMonth;
        this.reputationChangeQuarter = reputationChangeQuarter;
        this.reputationChangeWeek = reputationChangeWeek;
        this.reputationChangeYear = reputationChangeYear;
        this.timedPenaltyDate = timedPenaltyDate;
        this.upVoteCount = upVoteCount;
        this.userId = userId;
        this.userType = userType;
        this.viewCount = viewCount;
        this.websiteUrl = websiteUrl;
    }

    public User() {
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(int acceptRate) {
        this.acceptRate = acceptRate;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public BadgeCount getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(BadgeCount badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public Instant getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Instant lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getReputationChangeDay() {
        return reputationChangeDay;
    }

    public void setReputationChangeDay(int reputationChangeDay) {
        this.reputationChangeDay = reputationChangeDay;
    }

    public int getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public void setReputationChangeMonth(int reputationChangeMonth) {
        this.reputationChangeMonth = reputationChangeMonth;
    }

    public int getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public void setReputationChangeQuarter(int reputationChangeQuarter) {
        this.reputationChangeQuarter = reputationChangeQuarter;
    }

    public int getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public void setReputationChangeWeek(int reputationChangeWeek) {
        this.reputationChangeWeek = reputationChangeWeek;
    }

    public int getReputationChangeYear() {
        return reputationChangeYear;
    }

    public void setReputationChangeYear(int reputationChangeYear) {
        this.reputationChangeYear = reputationChangeYear;
    }

    public Instant getTimedPenaltyDate() {
        return timedPenaltyDate;
    }

    public void setTimedPenaltyDate(Instant timedPenaltyDate) {
        this.timedPenaltyDate = timedPenaltyDate;
    }

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
