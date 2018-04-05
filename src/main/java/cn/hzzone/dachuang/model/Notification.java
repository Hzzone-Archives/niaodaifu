package cn.hzzone.dachuang.model;

public class Notification {
    private String notificationId;

    private String fromOpenid;

    private String toOpenid;

    private String postContent;

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId == null ? null : notificationId.trim();
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

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }
}