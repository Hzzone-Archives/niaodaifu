package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Order_item;

public interface Order_itemMapper {
    int insert(Order_item record);

    int insertSelective(Order_item record);
}