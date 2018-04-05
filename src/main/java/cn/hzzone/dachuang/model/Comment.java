package cn.hzzone.dachuang.model;

public class Comment {
    private String commentId;

    private String postId;

    private String fromOpenid;

    private String toOpenid;

    private String commentContent;

    private String commentTime;

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

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }
}