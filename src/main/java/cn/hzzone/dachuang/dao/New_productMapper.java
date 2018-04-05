package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.New_product;

import java.util.List;

public interface New_productMapper {
    int deleteByPrimaryKey(String productId);

    int insert(New_product record);

    int insertSelective(New_product record);

    List<New_product> selectAllNewProduct();
}