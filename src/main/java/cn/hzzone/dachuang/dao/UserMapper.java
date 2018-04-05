package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String openId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String openId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}