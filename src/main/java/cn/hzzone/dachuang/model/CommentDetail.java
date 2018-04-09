package cn.hzzone.dachuang.model;

public class CommentDetail extends Comment {


    public CommentDetail(Comment comment, String img_url, String user_name, Boolean isSupport) {
        super(comment.getCommentId(), comment.getPostId(), comment.getFromOpenid(), comment.getToOpenid(), comment.getCommentContent(), comment.getCommentTime());
        this.toImg_url = img_url;
        this.toUser_name = user_name;
        this.isSupport = isSupport;
    }

    public void setToImg_url(String toImg_url) {
        this.toImg_url = toImg_url;
    }

    public void setSupport(boolean support) {
        isSupport = support;
    }

    public void setToUser_name(String toUser_name) {
        this.toUser_name = toUser_name;
    }

    private String toImg_url;

    public boolean isSupport() {
        return isSupport;
    }

    private boolean isSupport;

    public String getToImg_url() {
        return toImg_url;
    }

    public String getToUser_name() {
        return toUser_name;
    }

    private String toUser_name;
}
