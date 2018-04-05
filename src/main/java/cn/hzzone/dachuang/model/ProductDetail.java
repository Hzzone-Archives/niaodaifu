package cn.hzzone.dachuang.model;

import java.util.List;

public class ProductDetail extends Product {

    private List<Product_intro_images> product_intro_images;

    private List<Product_simple_images> product_simple_images;

    public void setProduct_intro_images(List<Product_intro_images> product_intro_images) {
        this.product_intro_images = product_intro_images;
    }

    public void setProduct_simple_images(List<Product_simple_images> product_simple_images) {
        this.product_simple_images = product_simple_images;
    }

    public List<Product_intro_images> getProduct_intro_images() {

        return product_intro_images;
    }

    public List<Product_simple_images> getProduct_simple_images() {
        return product_simple_images;
    }

    public ProductDetail(Product product, List<Product_intro_images> product_intro_images, List<Product_simple_images> product_simple_images) {
        this.setPrice(product.getPrice());
        this.setProductId(product.getProductId());
        this.setProductName(product.getProductName());
        this.product_intro_images = product_intro_images;
        this.product_simple_images = product_simple_images;
    }
}
