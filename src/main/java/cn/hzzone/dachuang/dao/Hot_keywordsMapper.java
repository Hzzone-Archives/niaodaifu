package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Hot_keywords;

public interface Hot_keywordsMapper {
    int deleteByPrimaryKey(String keywordsId);

    int insert(Hot_keywords record);

    int insertSelective(Hot_keywords record);

    Hot_keywords selectByPrimaryKey(String keywordsId);

    int updateByPrimaryKeySelective(Hot_keywords record);

    int updateByPrimaryKey(Hot_keywords record);
}