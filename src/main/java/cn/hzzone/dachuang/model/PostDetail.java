package cn.hzzone.dachuang.model;


import javafx.geometry.Pos;

import java.util.Date;

public class PostDetail extends Post{
    private String img_url;
    private String user_name;

    public Integer getComment_counts() {
        return comment_counts;
    }

    public void setComment_counts(Integer comment_counts) {
        this.comment_counts = comment_counts;
    }

    private Integer comment_counts;

    public void setSupport(Boolean support) {
        isSupport = support;
    }

    private Boolean isSupport;

    public Boolean getSupport() {
        return isSupport;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {

        return user_name;
    }

    public String getImg_url() {

        return img_url;
    }

    public PostDetail(Post post, String img_url, String user_name, Boolean isSupport, Integer comment_counts) {
        super(post.getPostId(), post.getPostTime(), post.getPostContent(), post.getTitle(), post.getOpenId());
        this.img_url = img_url;
        this.user_name = user_name;
        this.isSupport = isSupport;
        this.comment_counts = comment_counts;
    }
}
