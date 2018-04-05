package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Records;

public interface RecordsMapper {
    int deleteByPrimaryKey(String recordsId);

    int insert(Records record);

    int insertSelective(Records record);

    Records selectByPrimaryKey(String recordsId);

    int updateByPrimaryKeySelective(Records record);

    int updateByPrimaryKey(Records record);
}