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

    public int insertCartItem(String openid, String productid, int counts);


    public List<OrderDetail> findAllOrderByOpenid(String openid);

    public OrderDetail findOrderByOrderid(String order_id);

    public List<Completed_order> findCompletedOrder(String openid);

    public List<Tocomplete_order> findToCompletedOrder(String openid);

    public int insertOrder(Order order);

    public int insertOrder_item(Order_item order_item);


    public List<Address> findAllAdressByOpenid(String openid);

    public Address findAddressByID(String address_id);

    public int deleteAddress(String address_id);

    public int updateAddress(Address address);

    public int insertAddress(Address address);



}
