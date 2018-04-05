package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Product_intro_images;

import java.util.List;

public interface Product_intro_imagesMapper {
    int deleteByPrimaryKey(Product_intro_images key);

    int insert(Product_intro_images record);

    int insertSelective(Product_intro_images record);

    List<Product_intro_images> selectAllProductIntroImages(String productId);
}