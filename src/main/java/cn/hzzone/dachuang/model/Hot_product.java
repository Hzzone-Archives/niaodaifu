package cn.hzzone.dachuang.model;

public class Hot_product {
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }
}