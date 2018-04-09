package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Support;

import java.util.List;

public interface SupportMapper {
    int deleteByPrimaryKey(Support support);

    int insert(Support record);

    int insertSelective(Support record);

    Support selectByPrimaryKey(String supportId);

    int updateByPrimaryKeySelective(Support record);

    int updateByPrimaryKey(Support record);

    List<Support> selectByAll(Support support);
}