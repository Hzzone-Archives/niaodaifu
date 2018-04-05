package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Post;

public interface PostMapper {
    int deleteByPrimaryKey(String postId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(String postId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}