package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Tocomplete_order;

import java.util.List;

public interface Tocomplete_orderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Tocomplete_order record);

    int insertSelective(Tocomplete_order record);

    List<Tocomplete_order> selectByOpenid(String openid);
}