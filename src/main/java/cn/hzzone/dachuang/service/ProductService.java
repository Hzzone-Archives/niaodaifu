package cn.hzzone.dachuang.service;

import cn.hzzone.dachuang.model.*;

import java.util.List;

public interface ProductService {

    public Product findProductByID(String productid);

    public List<Product> findAllProduct();

    public List<Product> findAllHotProduct();

    public List<Product> findAllNewProduct();



    public List<Product_intro_images> findProductIntroImages(String productID);

    public List<Product_simple_images> findProductSimpleImages(String productID);

    public List<CartDetail> findCart(String openid);


    public int deleteCartItem(String openid, String productid);

    public int updateCartItemCounts(String openid, String productid, int counts);



}
