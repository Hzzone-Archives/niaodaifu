package cn.hzzone.dachuang.controller;

import cn.hzzone.dachuang.model.Address;
import cn.hzzone.dachuang.model.CartDetail;
import cn.hzzone.dachuang.model.Product;
import cn.hzzone.dachuang.model.ProductDetail;
import cn.hzzone.dachuang.service.ProductService;
import cn.hzzone.dachuang.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

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
