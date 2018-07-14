package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;
import java.util.Arrays;

public class Post implements Content{

    private String body;
    private String bodyMarkdown;
    private int commentCount;
    private Comment[] comments;
    private Instant creationDate;
    private int downVoteCount;
    private Instant lastActivityDate;
    private Instant lastEditDate;
    private ShallowUser lastEditor;
    private String link;
    private ShallowUser owner;
    private int postId;
    private String postType;
    private int score;
    private String shareLink;
    private String title;
    private int upVoteCount;

    public Post() {
    }

    public Post(String body, String bodyMarkdown, int commentCount, Comment[] comments, Instant creationDate, int downVoteCount, Instant lastActivityDate, Instant lastEditDate, ShallowUser lastEditor, String link, ShallowUser owner, int postId, String postType, int score, String shareLink, String title, int upVoteCount) {
        this.body = body;
        this.bodyMarkdown = bodyMarkdown;
        this.commentCount = commentCount;
        this.comments = comments;
        this.creationDate = creationDate;
        this.downVoteCount = downVoteCount;
        this.lastActivityDate = lastActivityDate;
        this.lastEditDate = lastEditDate;
        this.lastEditor = lastEditor;
        this.link = link;
        this.owner = owner;
        this.postId = postId;
        this.postType = postType;
        this.score = score;
        this.shareLink = shareLink;
        this.title = title;
        this.upVoteCount = upVoteCount;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void setBody(String body) {
        this.body = body;
    }

    public String getBodyMarkdown() {
        return bodyMarkdown;
    }

    public void setBodyMarkdown(String bodyMarkdown) {
        this.bodyMarkdown = bodyMarkdown;
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

    @Override
    public Instant getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public int getDownVoteCount() {
        return downVoteCount;
    }

    public void setDownVoteCount(int downVoteCount) {
        this.downVoteCount = downVoteCount;
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

    @Override
    public String getLink() {
        return link;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public ShallowUser getOwner() {
        return owner;
    }

    @Override
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

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
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
        return "post";
    }

    @Override
    public String toString() {
        return "Post{" +
                "body='" + body + '\'' +
                ", bodyMarkdown='" + bodyMarkdown + '\'' +
                ", commentCount=" + commentCount +
                ", comments=" + Arrays.toString(comments) +
                ", creationDate=" + creationDate +
                ", downVoteCount=" + downVoteCount +
                ", lastActivityDate=" + lastActivityDate +
                ", lastEditDate=" + lastEditDate +
                ", lastEditor=" + lastEditor +
                ", link='" + link + '\'' +
                ", owner=" + owner +
                ", postId=" + postId +
                ", postType='" + postType + '\'' +
                ", score=" + score +
                ", shareLink='" + shareLink + '\'' +
                ", title='" + title + '\'' +
                ", upVoteCount=" + upVoteCount +
                '}';
    }
}
