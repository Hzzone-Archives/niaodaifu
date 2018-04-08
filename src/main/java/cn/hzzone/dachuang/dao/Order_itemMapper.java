package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Order_item;

import java.util.List;

public interface Order_itemMapper {
    int insert(Order_item record);

    int insertSelective(Order_item record);

    List<Order_item> selectByOrderid(String order_id);
}