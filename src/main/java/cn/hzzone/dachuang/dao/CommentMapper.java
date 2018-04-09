package cn.hzzone.dachuang.dao;

import cn.hzzone.dachuang.model.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByPostID(String postid);
}