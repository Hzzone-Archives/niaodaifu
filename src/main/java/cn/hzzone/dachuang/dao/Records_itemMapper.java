package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Records_item;

public interface Records_itemMapper {
    int deleteByPrimaryKey(Records_item key);

    int insert(Records_item record);

    int insertSelective(Records_item record);
}