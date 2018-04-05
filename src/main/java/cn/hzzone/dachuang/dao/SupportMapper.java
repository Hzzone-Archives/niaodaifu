package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Support;

public interface SupportMapper {
    int deleteByPrimaryKey(String supportId);

    int insert(Support record);

    int insertSelective(Support record);

    Support selectByPrimaryKey(String supportId);

    int updateByPrimaryKeySelective(Support record);

    int updateByPrimaryKey(Support record);
}