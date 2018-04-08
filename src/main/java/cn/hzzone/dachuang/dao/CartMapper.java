package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Cart;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Cart key);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Cart key);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    List<Cart> selectByOpenID(String openid);
}