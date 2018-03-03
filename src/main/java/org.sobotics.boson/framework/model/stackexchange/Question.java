package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;
import java.util.Arrays;

public class Question implements Content{

    private int acceptedAnswerId;
    private int answerCount;
    private Answer[] answers;
    private String body;
    private String bodyMarkdown;
    private int bountyAmount;
    private Instant bountyClosesDate;
    private ShallowUser bountyUser;
    private boolean canClose;
    private boolean canFlag;
    private int closeVoteCount;
    private Instant closedDate;
    private ClosedDetails closedDetails;
    private String closedReason;
    private int commentCount;
    private Comment[] comments;
    private Instant communityOwnedDate;
    private Instant creationDate;
    private int deleteVoteCount;
    private int downVoteCount;
    private int favoriteCount;
    private boolean isAnswered;
    private Instant lastActivityDate;
    private Instant lastEditDate;
    private ShallowUser lastEditor;
    private String link;
    private Instant lockedDate;
    private MigrationInfo migratedFrom;
    private MigrationInfo migratedTo;
    private Notice notice;
    private ShallowUser owner;
    private Instant protectedDate;
    private int questionId;
    private int reopenVoteCount;
    private int score;
    private String shareLink;
    private String[] tags;
    private String title;
    private int upVoteCount;
    private int viewCount;


    public Question() {
    }

    public Question(int acceptedAnswerId, int answerCount, Answer[] answers, String body, String bodyMarkdown, int bountyAmount, Instant bountyClosesDate, ShallowUser bountyUser, boolean canClose, boolean canFlag, int closeVoteCount, Instant closedDate, ClosedDetails closedDetails, String closedReason, int commentCount, Comment[] comments, Instant communityOwnedDate, Instant creationDate, int deleteVoteCount, int downVoteCount, int favoriteCount, boolean isAnswered, Instant lastActivityDate, Instant lastEditDate, ShallowUser lastEditor, String link, Instant lockedDate, MigrationInfo migratedFrom, MigrationInfo migratedTo, Notice notice, ShallowUser owner, Instant protectedDate, int questionId, int reopenVoteCount, int score, String shareLink, String[] tags, String title, int upVoteCount, int viewCount) {
        this.acceptedAnswerId = acceptedAnswerId;
        this.answerCount = answerCount;
        this.answers = answers;
        this.body = body;
        this.bodyMarkdown = bodyMarkdown;
        this.bountyAmount = bountyAmount;
        this.bountyClosesDate = bountyClosesDate;
        this.bountyUser = bountyUser;
        this.canClose = canClose;
        this.canFlag = canFlag;
        this.closeVoteCount = closeVoteCount;
        this.closedDate = closedDate;
        this.closedDetails = closedDetails;
        this.closedReason = closedReason;
        this.commentCount = commentCount;
        this.comments = comments;
        this.communityOwnedDate = communityOwnedDate;
        this.creationDate = creationDate;
        this.deleteVoteCount = deleteVoteCount;
        this.downVoteCount = downVoteCount;
        this.favoriteCount = favoriteCount;
        this.isAnswered = isAnswered;
        this.lastActivityDate = lastActivityDate;
        this.lastEditDate = lastEditDate;
        this.lastEditor = lastEditor;
        this.link = link;
        this.lockedDate = lockedDate;
        this.migratedFrom = migratedFrom;
        this.migratedTo = migratedTo;
        this.notice = notice;
        this.owner = owner;
        this.protectedDate = protectedDate;
        this.questionId = questionId;
        this.reopenVoteCount = reopenVoteCount;
        this.score = score;
        this.shareLink = shareLink;
        this.tags = tags;
        this.title = title;
        this.upVoteCount = upVoteCount;
        this.viewCount = viewCount;
    }

    public int getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(int acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public void setAnswers(Answer[] answers) {
        this.answers = answers;
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

    public int getBountyAmount() {
        return bountyAmount;
    }

    public void setBountyAmount(int bountyAmount) {
        this.bountyAmount = bountyAmount;
    }

    public Instant getBountyClosesDate() {
        return bountyClosesDate;
    }

    public void setBountyClosesDate(Instant bountyClosesDate) {
        this.bountyClosesDate = bountyClosesDate;
    }

    public ShallowUser getBountyUser() {
        return bountyUser;
    }

    public void setBountyUser(ShallowUser bountyUser) {
        this.bountyUser = bountyUser;
    }

    public boolean isCanClose() {
        return canClose;
    }

    public void setCanClose(boolean canClose) {
        this.canClose = canClose;
    }

    public boolean isCanFlag() {
        return canFlag;
    }

    public void setCanFlag(boolean canFlag) {
        this.canFlag = canFlag;
    }

    public int getCloseVoteCount() {
        return closeVoteCount;
    }

    public void setCloseVoteCount(int closeVoteCount) {
        this.closeVoteCount = closeVoteCount;
    }

    public Instant getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Instant closedDate) {
        this.closedDate = closedDate;
    }

    public ClosedDetails getClosedDetails() {
        return closedDetails;
    }

    public void setClosedDetails(ClosedDetails closedDetails) {
        this.closedDetails = closedDetails;
    }

    public String getClosedReason() {
        return closedReason;
    }

    public void setClosedReason(String closedReason) {
        this.closedReason = closedReason;
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

    public int getDeleteVoteCount() {
        return deleteVoteCount;
    }

    public void setDeleteVoteCount(int deleteVoteCount) {
        this.deleteVoteCount = deleteVoteCount;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
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

    public MigrationInfo getMigratedFrom() {
        return migratedFrom;
    }

    public void setMigratedFrom(MigrationInfo migratedFrom) {
        this.migratedFrom = migratedFrom;
    }

    public MigrationInfo getMigratedTo() {
        return migratedTo;
    }

    public void setMigratedTo(MigrationInfo migratedTo) {
        this.migratedTo = migratedTo;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public ShallowUser getOwner() {
        return owner;
    }

    public void setOwner(ShallowUser owner) {
        this.owner = owner;
    }

    public Instant getProtectedDate() {
        return protectedDate;
    }

    public void setProtectedDate(Instant protectedDate) {
        this.protectedDate = protectedDate;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getReopenVoteCount() {
        return reopenVoteCount;
    }

    public void setReopenVoteCount(int reopenVoteCount) {
        this.reopenVoteCount = reopenVoteCount;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String getType() {
        return "question";
    }

    @Override
    public String toString() {
        return "Question{" +
                "acceptedAnswerId=" + acceptedAnswerId +
                ", answerCount=" + answerCount +
                ", answers=" + Arrays.toString(answers) +
                ", body='" + body + '\'' +
                ", bodyMarkdown='" + bodyMarkdown + '\'' +
                ", bountyAmount=" + bountyAmount +
                ", bountyClosesDate=" + bountyClosesDate +
                ", bountyUser=" + bountyUser +
                ", canClose=" + canClose +
                ", canFlag=" + canFlag +
                ", closeVoteCount=" + closeVoteCount +
                ", closedDate=" + closedDate +
                ", closedDetails=" + closedDetails +
                ", closedReason='" + closedReason + '\'' +
                ", commentCount=" + commentCount +
                ", comments=" + Arrays.toString(comments) +
                ", communityOwnedDate=" + communityOwnedDate +
                ", creationDate=" + creationDate +
                ", deleteVoteCount=" + deleteVoteCount +
                ", downVoteCount=" + downVoteCount +
                ", favoriteCount=" + favoriteCount +
                ", isAnswered=" + isAnswered +
                ", lastActivityDate=" + lastActivityDate +
                ", lastEditDate=" + lastEditDate +
                ", lastEditor=" + lastEditor +
                ", link='" + link + '\'' +
                ", lockedDate=" + lockedDate +
                ", migratedFrom=" + migratedFrom +
                ", migratedTo=" + migratedTo +
                ", notice=" + notice +
                ", owner=" + owner +
                ", protectedDate=" + protectedDate +
                ", questionId=" + questionId +
                ", reopenVoteCount=" + reopenVoteCount +
                ", score=" + score +
                ", shareLink='" + shareLink + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", title='" + title + '\'' +
                ", upVoteCount=" + upVoteCount +
                ", viewCount=" + viewCount +
                '}';
    }


}
