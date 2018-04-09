package cn.hzzone.dachuang.model;

import java.util.Date;

public class Comment {
    private String commentId;

    private String postId;

    private String fromOpenid;

    private String toOpenid;

    private String commentContent;

    private Date commentTime;

    public Comment(String commentId, String postId, String fromOpenid, String toOpenid, String commentContent, Date commentTime) {
        this.commentId = commentId;
        this.postId = postId;
        this.fromOpenid = fromOpenid;
        this.toOpenid = toOpenid;
        this.commentContent = commentContent;
        this.commentTime = commentTime;
    }

    public Comment(){}

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getFromOpenid() {
        return fromOpenid;
    }

    public void setFromOpenid(String fromOpenid) {
        this.fromOpenid = fromOpenid == null ? null : fromOpenid.trim();
    }

    public String getToOpenid() {
        return toOpenid;
    }

    public void setToOpenid(String toOpenid) {
        this.toOpenid = toOpenid == null ? null : toOpenid.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime == null ? null : commentTime;
    }
}