package cn.hzzone.dachuang.service.impl;

import cn.hzzone.dachuang.dao.CommentMapper;
import cn.hzzone.dachuang.dao.PostMapper;
import cn.hzzone.dachuang.dao.SupportMapper;
import cn.hzzone.dachuang.dao.UserMapper;
import cn.hzzone.dachuang.model.*;
import cn.hzzone.dachuang.service.DiscussionService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscussionServiceImpl implements DiscussionService {


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<PostDetail> findAllPost() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        List<PostDetail> postDetails = new ArrayList<>();
        List<Post> posts = postMapper.selectAllPost();
        for(Post post: posts) {
            User user = userMapper.selectByPrimaryKey(post.getOpenId());
            Support support = new Support();
            support.setOpenId(user.getOpenId());
            support.setSupportId(post.getPostId());
            Support supports = supportMapper.selectByAll(support);
            Boolean isSupport = !(supports==null);
            CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
            List<Comment> comments = commentMapper.selectByPostID(post.getPostId());
            Integer integer = comments.size();
            postDetails.add(new PostDetail(post, user.getUserImg(), user.getUserName(), isSupport, integer));
        }
        sqlSession.close();
        return postDetails;
    }

    @Override
    public PostDetail insertNewPost(Post post) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
        List<Comment> comments = commentMapper.selectByPostID(post.getPostId());
        postMapper.insert(post);
        User user = userMapper.selectByPrimaryKey(post.getOpenId());
        Integer integer = comments.size();

        sqlSession.close();
        return new PostDetail(post, user.getUserImg(), user.getUserName(), false, integer);
    }

    @Override
    public int deleteSupport(Support support) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        int d = supportMapper.deleteByPrimaryKey(support);

        sqlSession.close();
        return d;
    }

    @Override
    public int insertSupport(Support support) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        int d = supportMapper.insert(support);

        sqlSession.close();
        return d;
    }

    @Override
    public List<CommentDetail> findAllCommentsByPostID(String postid, String openid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
        List<Comment> comments = commentMapper.selectByPostID(postid);
        List<CommentDetail> commentDetails = new ArrayList<>();
        for(Comment comment: comments) {
            User from_user = userMapper.selectByPrimaryKey(comment.getFromOpenid());
            User to_user = userMapper.selectByPrimaryKey(comment.getToOpenid());
            Support support = new Support();
            support.setSupportId(comment.getCommentId());
            support.setOpenId(openid);
            Support supports = supportMapper.selectByAll(support);
            Boolean isSupport = !(supports==null);
            commentDetails.add(new CommentDetail(comment, from_user, to_user, isSupport));
        }

        sqlSession.close();
        return commentDetails;
    }

    @Override
    public CommentDetail insertNewComments(Comment comment) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User from_user = userMapper.selectByPrimaryKey(comment.getFromOpenid());
        User to_user = userMapper.selectByPrimaryKey(comment.getToOpenid());
        commentMapper.insert(comment);

        sqlSession.close();
        return new CommentDetail(comment, from_user, to_user, false);
    }
}
