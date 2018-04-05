package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Product;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    List<Product> selectAllProduct();
}