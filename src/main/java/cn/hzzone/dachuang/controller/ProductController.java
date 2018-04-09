package cn.hzzone.dachuang.controller;

import cn.hzzone.dachuang.model.*;
import cn.hzzone.dachuang.service.ProductService;
import cn.hzzone.dachuang.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/order_detail")
    public OrderDetail getOrderDetail(@RequestParam("orderid") String orderid) {
        return productService.findOrderByOrderid(orderid);
    }


    @PostMapping("/all_order")
    public List<OrderDetail> getAllOrder(@RequestParam("openid") String openid) {
        return productService.findAllOrderByOpenid(openid);
    }

    @PostMapping("/completed_order")
    public List<String> getCompleteOrder(@RequestParam("openid") String openid) {
        List<Completed_order> orders = productService.findCompletedOrder(openid);
        List<String> order_ids = new ArrayList<>();
        for(Completed_order completed_order: orders){
            order_ids.add(completed_order.getOrderId());
        }
        return order_ids;
    }

    @PostMapping("/tocomplete_order")
    public List<String> getToCompleteOrder(@RequestParam("openid") String openid) {
        List<Tocomplete_order> orders = productService.findToCompletedOrder(openid);
        List<String> order_ids = new ArrayList<>();
        for(Tocomplete_order tocomplete_order: orders){
            order_ids.add(tocomplete_order.getOrderId());
        }
        return order_ids;
    }

    @PostMapping("/add_order")
    public Message<String> addOrder(@RequestParam("openid") String openid,
                                    @RequestParam("address_id") String address_id) {
        System.out.println(address_id);
        Order order = new Order();
        order.setAddressId(address_id);
        order.setOpenId(openid);
        order.setOrderTime(new Date());
        String order_id = UUID.randomUUID().toString();
        order.setOrderId(order_id);
        System.out.println(order.getAddressId());
        productService.insertOrder(order);
        Message<String> message = new Message(order_id, 1, "添加成功");
        return message;
    }

    @PostMapping("/add_order_item")
    public Message<Integer> addOrderItem(@RequestParam("order_id") String order_id,
                                         @RequestParam("product_id") String product_id,
                                         @RequestParam("price") Double price,
                                         @RequestParam("counts") Integer counts) {

        Order_item order_item = new Order_item();
        order_item.setCounts(counts);
        order_item.setOrderId(order_id);
        order_item.setPrice(price);
        order_item.setProductId(product_id);
        Integer d = productService.insertOrder_item(order_item);
        return new Message<Integer>(d, 1, "添加成功");
    }


    @PostMapping("/add_order_items")
    public Message<Integer> addOrderItems(@RequestBody Map<String, String>[] request_body) {

        Integer d = 0;
        for(Map<String, String> order_item_map: request_body) {
            Order_item order_item = new Order_item();
            System.out.println(order_item_map.toString());

            order_item.setCounts(Integer.parseInt(order_item_map.get("num")));
            order_item.setOrderId(order_item_map.get("order_id"));
            order_item.setPrice(Double.parseDouble(order_item_map.get("price")));
            order_item.setProductId(order_item_map.get("id"));
            d += productService.insertOrder_item(order_item);
            System.out.println(d);
        }

        return new Message<Integer>(d, 1, "添加成功");
    }

    @PostMapping("/address")
    public List<Address> getAddressList(@RequestParam("openid") String openid) {
        return productService.findAllAdressByOpenid(openid);
    }

    @PostMapping("/address_detail")
    public Address getAddressDetail(@RequestParam("address_id") String address_id) {
        return productService.findAddressByID(address_id);
    }

    @PostMapping("/delete_address")
    public Message<Integer> deleteAddress(@RequestParam("address_id") String address_id) {
        Message<Integer> message = new Message(1, 1, "");
        Integer d = productService.deleteAddress(address_id);
        message.setData(d);
        message.setMsg("删除成功");
        return message;
    }

    @PostMapping("/update_address")
    public Message<Integer> updateAddress(@RequestParam("address_id") String address_id,
                                          @RequestParam("province") String province,
                                          @RequestParam("city") String city,
                                          @RequestParam("area") String area,
                                          @RequestParam("address_detail") String address_detail,
                                          @RequestParam("user_name") String user_name,
                                          @RequestParam("phone_number") String phone_number,
                                          @RequestParam("openid") String openid) {
        Message<Integer> message = new Message(1, 1, "");
        Integer d = productService.updateAddress(new Address(address_id, province, city, area, address_detail, user_name, phone_number, openid));
        message.setData(d);
        message.setMsg("更新成功");
        return message;
    }

    @PostMapping("/add_address")
    public Message<Integer> addAddress(@RequestParam("province") String province,
                                       @RequestParam("city") String city,
                                       @RequestParam("area") String area,
                                       @RequestParam("address_detail") String address_detail,
                                       @RequestParam("user_name") String user_name,
                                       @RequestParam("phone_number") String phone_number,
                                       @RequestParam("openid") String openid) {
        String address_id = UUID.randomUUID().toString();
        Message<Integer> message = new Message(1, 1, "");
        Integer d = productService.insertAddress(new Address(address_id, province, city, area, address_detail, user_name, phone_number, openid));
        message.setData(d);
        message.setMsg("添加成功");
        return message;
    }

    @PostMapping("/cart_detail")
    public List<CartDetail> getCartDetail(@RequestParam("openid") String openid){
        return productService.findCart(openid);
    }

    /**
     * case 0 删除 cart item
     * case 1 修改 cart item 数量
     * case 2 添加购物车
     * @param openid
     * @param productid
     * @param action
     * @param counts
     * @return
     */
    @PostMapping("/edit_cart")
    public Message<Integer> editCartDetail(@RequestParam("openid") String openid, @RequestParam("productid") String productid, @RequestParam("action") Integer action, @RequestParam("counts") Integer counts){
        int d = 0;
        Message<Integer> message = new Message(d, action, "删除或修改成功");
        switch (action){
            case 0:
//                productService.fin
                d = productService.deleteCartItem(openid, productid);
                System.out.println(d);
                message.setMsg("删除成功");
                break;
            case 1:
                d = productService.updateCartItemCounts(openid, productid, counts);
                System.out.println(d);
                message.setMsg("更新成功");
                break;
            case 2:
                d = productService.insertCartItem(openid, productid, counts);
                System.out.println(d);
                if(d==-1){
                    message.setMsg("购物车已存在");
                }else {
                    message.setMsg("添加成功");
                }
                break;
        }
        message.setData(d);
        return message;
    }

    @GetMapping("/all_product")
    public List<ProductDetail> getAllProduct(){
        List<ProductDetail> productDetails = new ArrayList<>();
        for(Product product: productService.findAllProduct()){
            productDetails.add(new ProductDetail(product, productService.findProductIntroImages(product.getProductId()), productService.findProductSimpleImages(product.getProductId())));
        }
        System.out.println(productDetails);
        return productDetails;
    }


    @GetMapping("/hot_product")
    public List<ProductDetail> getHotProduct(){
        List<ProductDetail> productDetails = new ArrayList<>();
        for(Product product: productService.findAllHotProduct()){
            productDetails.add(new ProductDetail(product, productService.findProductIntroImages(product.getProductId()), productService.findProductSimpleImages(product.getProductId())));
        }
        return productDetails;
    }


    @GetMapping("/new_product")
    public List<ProductDetail> getNewProduct(){
        List<ProductDetail> productDetails = new ArrayList<>();
        for(Product product: productService.findAllNewProduct()){
            productDetails.add(new ProductDetail(product, productService.findProductIntroImages(product.getProductId()), productService.findProductSimpleImages(product.getProductId())));
        }
        return productDetails;
    }

    @PostMapping("/product_info")
    public ProductDetail getProductDetail(@RequestParam("productid") String productid) {
        Product product = productService.findProductByID(productid);
        ProductDetail productDetail = new ProductDetail(product, productService.findProductIntroImages(productid), productService.findProductSimpleImages(productid));
        return productDetail;
    }
}
