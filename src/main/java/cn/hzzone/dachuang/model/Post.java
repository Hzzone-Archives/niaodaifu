package cn.hzzone.dachuang.model;

import java.util.Date;

public class Post {
    private String postId;

    private Date postTime;

    public Post() {

    }

    public Post(String postId, Date postTime, String postContent, String title, String openId) {
        this.postId = postId;
        this.postTime = postTime;
        this.postContent = postContent;
        this.title = title;
        this.openId = openId;
    }

    private String postContent;

    private String title;

    private String openId;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }
}