package cn.hzzone.dachuang.controller;

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

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/cart_detail")
    public List<CartDetail> getCartDetail(@RequestParam("openid") String openid){
        return productService.findCart(openid);
    }

    /**
     * case 0 删除 cart item
     * case 1 修改 cart item 数量
     * @param openid
     * @param productid
     * @param action
     * @param counts
     * @return
     */
    @PostMapping("/edit_cart")
    public Message<Integer> editCartDetail(@RequestParam("openid") String openid, @RequestParam("productid") String productid, @RequestParam("action") Integer action, @RequestParam("counts") Integer counts){
        int d = 0;
        switch (action){
            case 0:
//                productService.fin
                d = productService.deleteCartItem(openid, productid);
                System.out.println(d);
                break;
            case 1:
                d = productService.updateCartItemCounts(openid, productid, counts);
                System.out.println(d);
                break;
        }
        Message<Integer> message = new Message<Integer>(d, action, "删除或修改成功");
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
