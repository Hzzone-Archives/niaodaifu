package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Tocomplete_order;

public interface Tocomplete_orderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Tocomplete_order record);

    int insertSelective(Tocomplete_order record);
}