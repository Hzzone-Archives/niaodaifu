package cn.hzzone.dachuang.model;

public class CartDetail extends Cart {
    private String product_name;
    private String simple_img_url;
    private Double price;

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setSimple_img_url(String simple_img_url) {
        this.simple_img_url = simple_img_url;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProduct_name() {

        return product_name;
    }

    public String getSimple_img_url() {
        return simple_img_url;
    }

    public Double getPrice() {
        return price;
    }

    public CartDetail(Cart cart, String product_name, String simple_img_url, Double price) {
        this.setCounts(cart.getCounts());
        this.setOpenId(cart.getOpenId());
        this.setProductId(cart.getProductId());
        this.product_name = product_name;
        this.simple_img_url = simple_img_url;
        this.price = price;
    }
}
