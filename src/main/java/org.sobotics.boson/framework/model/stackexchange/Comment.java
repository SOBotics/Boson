package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;

public class Comment implements Content{
    private String body;
    private String bodyMarkdown;
    private boolean canFlag;
    private int commentId;
    private Instant creationDate;
    private boolean edited;
    private String link;
    private ShallowUser owner;
    private int postId;
    private String postType;
    private ShallowUser replyToUser;
    private int score;

    public Comment(String body, String bodyMarkdown, boolean canFlag, int commentId, Instant creationDate, boolean edited, String link, ShallowUser owner, int postId, String postType, ShallowUser replyToUser, int score) {
        this.body = body;
        this.bodyMarkdown = bodyMarkdown;
        this.canFlag = canFlag;
        this.commentId = commentId;
        this.creationDate = creationDate;
        this.edited = edited;
        this.link = link;
        this.owner = owner;
        this.postId = postId;
        this.postType = postType;
        this.replyToUser = replyToUser;
        this.score = score;
    }

    public Comment() {
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ShallowUser getOwner() {
        return owner;
    }

    public void setOwner(ShallowUser owner) {
        this.owner = owner;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public ShallowUser getReplyToUser() {
        return replyToUser;
    }

    public void setReplyToUser(ShallowUser replyToUser) {
        this.replyToUser = replyToUser;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String getType() {
        return "comment";
    }

    @Override
    public String toString() {
        return "Comment{" +
                "body='" + body + '\'' +
                ", bodyMarkdown='" + bodyMarkdown + '\'' +
                ", canFlag=" + canFlag +
                ", commentId=" + commentId +
                ", creationDate=" + creationDate +
                ", edited=" + edited +
                ", link='" + link + '\'' +
                ", owner=" + owner +
                ", postId=" + postId +
                ", postType='" + postType + '\'' +
                ", replyToUser=" + replyToUser +
                ", score=" + score +
                '}';
    }
}
