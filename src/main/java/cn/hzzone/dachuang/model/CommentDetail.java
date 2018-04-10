package cn.hzzone.dachuang.model;

public class CommentDetail extends Comment {


    public CommentDetail(Comment comment, User from_user, User to_user, Boolean isSupport) {
        super(comment.getCommentId(), comment.getPostId(), comment.getFromOpenid(), comment.getToOpenid(), comment.getCommentContent(), comment.getCommentTime());
        this.from_user = from_user;
        this.to_user = to_user;
        this.isSupport = isSupport;
    }

    private User from_user;
    private User to_user;
    private Boolean isSupport;

    public User getFrom_user() {
        return from_user;
    }

    public User getTo_user() {
        return to_user;
    }

    public Boolean getSupport() {
        return isSupport;
    }

    public void setFrom_user(User from_user) {
        this.from_user = from_user;
    }

    public void setTo_user(User to_user) {
        this.to_user = to_user;
    }

    public void setSupport(Boolean support) {
        isSupport = support;
    }
}
