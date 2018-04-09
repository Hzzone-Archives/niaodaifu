package cn.hzzone.dachuang.model;

public class Completed_order {
    private String orderId;

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOpenId() {

        return openId;
    }

    private String openId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }
}