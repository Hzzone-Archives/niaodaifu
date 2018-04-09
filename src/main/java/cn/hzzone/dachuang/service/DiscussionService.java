package cn.hzzone.dachuang.service;

import cn.hzzone.dachuang.model.*;
import cn.hzzone.dachuang.util.Message;

import java.util.List;

public interface DiscussionService {

    public List<PostDetail> findAllPost();

    public PostDetail insertNewPost(Post post);

    public int deleteSupport(Support support);

    public int insertSupport(Support support);

    public List<CommentDetail> findAllCommentsByPostID(String postid);

    public CommentDetail insertNewComments(Comment comment);
}
