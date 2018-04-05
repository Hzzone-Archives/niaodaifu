package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Hot_product;

import java.util.List;

public interface Hot_productMapper {
    int deleteByPrimaryKey(String productId);

    int insert(Hot_product record);

    int insertSelective(Hot_product record);

    List<Hot_product> selectAllHotProduct();
}