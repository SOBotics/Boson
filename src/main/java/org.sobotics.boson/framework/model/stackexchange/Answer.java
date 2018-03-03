package org.sobotics.boson.framework.model.stackexchange;


import java.time.Instant;
import java.util.Arrays;

public class Answer implements Content{

    private int answerId;
    private int awardedBountyAmount;
    private ShallowUser[] awardedBountyUsers;
    private String body;
    private String bodyMarkdown;
    private boolean canFlag;
    private int commentCount;
    private Comment[] comments;
    private Instant communityOwnedDate;
    private Instant creationDate;
    private int downVoteCount;
    private boolean isAccepted;
    private Instant lastActivityDate;
    private Instant lastEditDate;
    private ShallowUser lastEditor;
    private String link;
    private Instant lockedDate;
    private ShallowUser owner;
    private int questionId;
    private int score;
    private String shareLink;
    private String[] tags;
    private String title;
    private int upVoteCount;

    public Answer(int answerId, int awardedBountyAmount, ShallowUser[] awardedBountyUsers, String body, String bodyMarkdown, boolean canFlag, int commentCount, Comment[] comments, Instant communityOwnedDate, Instant creationDate, int downVoteCount, boolean isAccepted, Instant lastActivityDate, Instant lastEditDate, ShallowUser lastEditor, String link, Instant lockedDate, ShallowUser owner, int questionId, int score, String shareLink, String[] tags, String title, int upVoteCount) {
        this.answerId = answerId;
        this.awardedBountyAmount = awardedBountyAmount;
        this.awardedBountyUsers = awardedBountyUsers;
        this.body = body;
        this.bodyMarkdown = bodyMarkdown;
        this.canFlag = canFlag;
        this.commentCount = commentCount;
        this.comments = comments;
        this.communityOwnedDate = communityOwnedDate;
        this.creationDate = creationDate;
        this.downVoteCount = downVoteCount;
        this.isAccepted = isAccepted;
        this.lastActivityDate = lastActivityDate;
        this.lastEditDate = lastEditDate;
        this.lastEditor = lastEditor;
        this.link = link;
        this.lockedDate = lockedDate;
        this.owner = owner;
        this.questionId = questionId;
        this.score = score;
        this.shareLink = shareLink;
        this.tags = tags;
        this.title = title;
        this.upVoteCount = upVoteCount;
    }

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getAwardedBountyAmount() {
        return awardedBountyAmount;
    }

    public void setAwardedBountyAmount(int awardedBountyAmount) {
        this.awardedBountyAmount = awardedBountyAmount;
    }

    public ShallowUser[] getAwardedBountyUsers() {
        return awardedBountyUsers;
    }

    public void setAwardedBountyUsers(ShallowUser[] awardedBountyUsers) {
        this.awardedBountyUsers = awardedBountyUsers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyMarkdown() {
        return bodyMarkdown;
    }

    public void setBodyMarkdown(String bodyMarkdown) {
        this.bodyMarkdown = bodyMarkdown;
    }

    public boolean isCanFlag() {
        return canFlag;
    }

    public void setCanFlag(boolean canFlag) {
        this.canFlag = canFlag;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }

    public Instant getCommunityOwnedDate() {
        return communityOwnedDate;
    }

    public void setCommunityOwnedDate(Instant communityOwnedDate) {
        this.communityOwnedDate = communityOwnedDate;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Instant getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Instant lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Instant getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Instant lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public ShallowUser getLastEditor() {
        return lastEditor;
    }

    public void setLastEditor(ShallowUser lastEditor) {
        this.lastEditor = lastEditor;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Instant getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Instant lockedDate) {
        this.lockedDate = lockedDate;
    }

    public ShallowUser getOwner() {
        return owner;
    }

    public void setOwner(ShallowUser owner) {
        this.owner = owner;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUpVoteCount() {
        return upVoteCount;
    }

    public void setUpVoteCount(int upVoteCount) {
        this.upVoteCount = upVoteCount;
    }

    @Override
    public String getType() {
        return "answer";
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", awardedBountyAmount=" + awardedBountyAmount +
                ", awardedBountyUsers=" + Arrays.toString(awardedBountyUsers) +
                ", body='" + body + '\'' +
                ", bodyMarkdown='" + bodyMarkdown + '\'' +
                ", canFlag=" + canFlag +
                ", commentCount=" + commentCount +
                ", comments=" + Arrays.toString(comments) +
                ", communityOwnedDate=" + communityOwnedDate +
                ", creationDate=" + creationDate +
                ", downVoteCount=" + downVoteCount +
                ", isAccepted=" + isAccepted +
                ", lastActivityDate=" + lastActivityDate +
                ", lastEditDate=" + lastEditDate +
                ", lastEditor=" + lastEditor +
                ", link='" + link + '\'' +
                ", lockedDate=" + lockedDate +
                ", owner=" + owner +
                ", questionId=" + questionId +
                ", score=" + score +
                ", shareLink='" + shareLink + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", title='" + title + '\'' +
                ", upVoteCount=" + upVoteCount +
                '}';
    }
}
