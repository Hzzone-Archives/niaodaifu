package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Product_simple_images;

import java.util.List;

public interface Product_simple_imagesMapper {
    int deleteByPrimaryKey(Product_simple_images key);

    int insert(Product_simple_images record);

    int insertSelective(Product_simple_images record);

    List<Product_simple_images> selectAllProductSimpleImages(String productId);
}