package org.sobotics.boson.framework.model.stackexchange;

import java.time.Instant;
import java.util.Arrays;

public class Revision {


    private String body;
    private String comment;
    private Instant creationDate;
    private Boolean isRollback;
    private String lastBody;
    private String[] lastTags;
    private String lastTitle;
    private Integer postId;
    private String postType;
    private String revisionGuid;
    private Integer revisionNumber;
    private String revisionType;
    private Boolean setCommunityWiki;
    private String[] tags;
    private String title;
    private ShallowUser user;

    public Revision() {
    }

    public Revision(String body, String comment, Instant creationDate, Boolean isRollback, String lastBody, String[] lastTags, String lastTitle, Integer postId, String postType, String revisionGuid, Integer revisionNumber, String revisionType, Boolean setCommunityWiki, String[] tags, String title, ShallowUser user) {
        this.body = body;
        this.comment = comment;
        this.creationDate = creationDate;
        this.isRollback = isRollback;
        this.lastBody = lastBody;
        this.lastTags = lastTags;
        this.lastTitle = lastTitle;
        this.postId = postId;
        this.postType = postType;
        this.revisionGuid = revisionGuid;
        this.revisionNumber = revisionNumber;
        this.revisionType = revisionType;
        this.setCommunityWiki = setCommunityWiki;
        this.tags = tags;
        this.title = title;
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getRollback() {
        return isRollback;
    }

    public void setRollback(Boolean rollback) {
        isRollback = rollback;
    }

    public String getLastBody() {
        return lastBody;
    }

    public void setLastBody(String lastBody) {
        this.lastBody = lastBody;
    }

    public String[] getLastTags() {
        return lastTags;
    }

    public void setLastTags(String[] lastTags) {
        this.lastTags = lastTags;
    }

    public String getLastTitle() {
        return lastTitle;
    }

    public void setLastTitle(String lastTitle) {
        this.lastTitle = lastTitle;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getRevisionGuid() {
        return revisionGuid;
    }

    public void setRevisionGuid(String revisionGuid) {
        this.revisionGuid = revisionGuid;
    }

    public Integer getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getRevisionType() {
        return revisionType;
    }

    public void setRevisionType(String revisionType) {
        this.revisionType = revisionType;
    }

    public Boolean getSetCommunityWiki() {
        return setCommunityWiki;
    }

    public void setSetCommunityWiki(Boolean setCommunityWiki) {
        this.setCommunityWiki = setCommunityWiki;
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

    public ShallowUser getUser() {
        return user;
    }

    public void setUser(ShallowUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "body='" + body + '\'' +
                ", comment='" + comment + '\'' +
                ", creationDate=" + creationDate +
                ", isRollback=" + isRollback +
                ", lastBody='" + lastBody + '\'' +
                ", lastTags=" + Arrays.toString(lastTags) +
                ", lastTitle='" + lastTitle + '\'' +
                ", postId=" + postId +
                ", postType='" + postType + '\'' +
                ", revisionGuid='" + revisionGuid + '\'' +
                ", revisionNumber=" + revisionNumber +
                ", revisionType='" + revisionType + '\'' +
                ", setCommunityWiki=" + setCommunityWiki +
                ", tags=" + Arrays.toString(tags) +
                ", title='" + title + '\'' +
                ", user=" + user +
                '}';
    }
}
