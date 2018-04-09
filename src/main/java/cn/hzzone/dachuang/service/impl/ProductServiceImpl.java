package cn.hzzone.dachuang.service.impl;

import cn.hzzone.dachuang.dao.*;
import cn.hzzone.dachuang.model.*;
import cn.hzzone.dachuang.service.ProductService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Product> findAllProduct() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        List product = productMapper.selectAllProduct();
        sqlSession.close();
        return product;
    }

    @Override
    public List<Product> findAllHotProduct() {
        List<Product> products = new ArrayList<>();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Hot_productMapper hot_productMapper = sqlSession.getMapper(Hot_productMapper.class);
        List<Hot_product> hot_products = hot_productMapper.selectAllHotProduct();
        for(Hot_product product: hot_products){
            products.add(productMapper.selectByPrimaryKey(product.getProductId()));
        }
        sqlSession.close();
        return products;
    }

    @Override
    public List<Product> findAllNewProduct() {
        List<Product> products = new ArrayList<>();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        New_productMapper new_productMapper = sqlSession.getMapper(New_productMapper.class);
        List<New_product> new_products = new_productMapper.selectAllNewProduct();
        for(New_product product: new_products){
            products.add(productMapper.selectByPrimaryKey(product.getProductId()));
        }
        sqlSession.close();
        return products;
    }

    @Override
    public List<Product_intro_images> findProductIntroImages(String productID) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Product_intro_imagesMapper product_intro_imagesMapper = sqlSession.getMapper(Product_intro_imagesMapper.class);
        List<Product_intro_images> product_intro_images = product_intro_imagesMapper.selectAllProductIntroImages(productID);
        sqlSession.close();
        return product_intro_images;
    }

    @Override
    public List<Product_simple_images> findProductSimpleImages(String productID) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Product_simple_imagesMapper product_simple_imagesMapper = sqlSession.getMapper(Product_simple_imagesMapper.class);
        List<Product_simple_images> product_simple_images = product_simple_imagesMapper.selectAllProductSimpleImages(productID);
        sqlSession.close();
        return product_simple_images;
    }

    @Override
    public List<CartDetail> findCart(String openid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product_simple_imagesMapper product_simple_imagesMapper = sqlSession.getMapper(Product_simple_imagesMapper.class);
        List<Cart> carts = cartMapper.selectByOpenID(openid);
        List<CartDetail> cartDetails = new ArrayList<>();
        for(Cart cart: carts){
            Product product = productMapper.selectByPrimaryKey(cart.getProductId());
            String img_url = product_simple_imagesMapper.selectAllProductSimpleImages(product.getProductId()).get(0).getUrl();
            cartDetails.add(new CartDetail(cart, product.getProductName(), img_url, product.getPrice()));
        }
        sqlSession.close();
        return cartDetails;
    }

    @Override
    public int deleteCartItem(String openid, String productid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        Cart cart = new Cart();
        cart.setOpenId(openid);
        cart.setProductId(productid);
        int d = cartMapper.deleteByPrimaryKey(cart);
        sqlSession.close();
        return d;
    }

    @Override
    public int updateCartItemCounts(String openid, String productid, int counts) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        Cart cart = new Cart();
        cart.setOpenId(openid);
        cart.setProductId(productid);
        cart.setCounts(counts);
        int d = cartMapper.updateByPrimaryKey(cart);
        sqlSession.close();
        return d;
    }

    @Override
    public int insertCartItem(String openid, String productid, int counts) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CartMapper cartMapper = sqlSession.getMapper(CartMapper.class);
        Cart cart = new Cart();
        cart.setOpenId(openid);
        cart.setProductId(productid);
        cart.setCounts(counts);
        int d = 0;
        try {
            d = cartMapper.insert(cart);
        } catch (Exception e){
            d = -1;
        }

        sqlSession.close();
        return d;
    }

    @Override
    public List<OrderDetail> findAllOrderByOpenid(String openid) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order_itemMapper order_itemMapper = sqlSession.getMapper(Order_itemMapper.class);
        List<Order> orderList = orderMapper.selectByOpenid(openid);

        for(Order order: orderList){
            Address address = addressMapper.selectByPrimaryKey(order.getAddressId());
            List<Order_item> order_itemList = order_itemMapper.selectByOrderid(order.getOrderId());
            orderDetails.add(new OrderDetail(order, order_itemList, address));
        }
        sqlSession.close();
        return orderDetails;
    }

    @Override
    public OrderDetail findOrderByOrderid(String order_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order_itemMapper order_itemMapper = sqlSession.getMapper(Order_itemMapper.class);
        Order order = orderMapper.selectByPrimaryKey(order_id);

        Address address = addressMapper.selectByPrimaryKey(order.getAddressId());
        List<Order_item> order_itemList = order_itemMapper.selectByOrderid(order.getOrderId());
        sqlSession.close();
        return new OrderDetail(order, order_itemList, address);
    }

    @Override
    public List<Completed_order> findCompletedOrder(String openid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Completed_orderMapper completed_orderMapper  = sqlSession.getMapper(Completed_orderMapper.class);
        List<Completed_order> d = completed_orderMapper.selectByOpenid(openid);
        sqlSession.close();
        return d;
    }

    @Override
    public List<Tocomplete_order> findToCompletedOrder(String openid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Tocomplete_orderMapper tocomplete_orderMapper  = sqlSession.getMapper(Tocomplete_orderMapper.class);
        List<Tocomplete_order> d = tocomplete_orderMapper.selectByOpenid(openid);
        sqlSession.close();
        return d;
    }

    @Override
    public int insertOrder(Order order) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Integer d = orderMapper.insert(order);
        sqlSession.close();
        return d;
    }

    @Override
    public int insertOrder_item(Order_item order_item) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Order_itemMapper order_itemMapper = sqlSession.getMapper(Order_itemMapper.class);
        Integer d = order_itemMapper.insert(order_item);
        sqlSession.close();
        return d;
    }

    @Override
    public List<Address> findAllAdressByOpenid(String openid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        List<Address> addressList = addressMapper.selectByOpenID(openid);
        sqlSession.close();
        return addressList;
    }


    @Override
    public Address findAddressByID(String address_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Address address = addressMapper.selectByPrimaryKey(address_id);
        sqlSession.close();
        return address;
    }

    @Override
    public int deleteAddress(String address_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Integer d = addressMapper.deleteByPrimaryKey(address_id);
        sqlSession.close();
        return d;
    }

    @Override
    public int updateAddress(Address address) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Integer d = addressMapper.updateByPrimaryKey(address);
        sqlSession.close();
        return d;
    }

    @Override
    public int insertAddress(Address address) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);
        Integer d = addressMapper.insert(address);
        sqlSession.close();
        return d;
    }


    @Override
    public Product findProductByID(String productid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
        Product product = productMapper.selectByPrimaryKey(productid);
        sqlSession.close();
        return product;
    }
}
