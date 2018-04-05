package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Completed_order;

public interface Completed_orderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Completed_order record);

    int insertSelective(Completed_order record);
}