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
            List supports = supportMapper.selectByAll(support);
            Boolean isSupport = supports.isEmpty();
            postDetails.add(new PostDetail(post, user.getUserImg(), user.getUserName(), isSupport));
        }
        sqlSession.close();
        return postDetails;
    }

    @Override
    public PostDetail insertNewPost(Post post) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        postMapper.insert(post);
        User user = userMapper.selectByPrimaryKey(post.getOpenId());

        return new PostDetail(post, user.getUserImg(), user.getUserName(), false);
    }

    @Override
    public int deleteSupport(Support support) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        int d = supportMapper.deleteByPrimaryKey(support);

        return d;
    }

    @Override
    public int insertSupport(Support support) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        int d = supportMapper.insert(support);

        return d;
    }

    @Override
    public List<CommentDetail> findAllCommentsByPostID(String postid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SupportMapper supportMapper = sqlSession.getMapper(SupportMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
        List<Comment> comments = commentMapper.selectByPostID(postid);
        List<CommentDetail> commentDetails = new ArrayList<>();
        for(Comment comment: comments) {
            User user = userMapper.selectByPrimaryKey(comment.getFromOpenid());
            Support support = new Support();
            support.setSupportId(comment.getCommentId());
            support.setOpenId(user.getOpenId());
            List<Support> supports = supportMapper.selectByAll(support);
            Boolean isSupport = supports.isEmpty();
            commentDetails.add(new CommentDetail(comment, user.getUserImg(), user.getUserName(), isSupport));
        }
        return commentDetails;
    }

    @Override
    public CommentDetail insertNewComments(Comment comment) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(comment.getFromOpenid());
        commentMapper.insert(comment);
        return new CommentDetail(comment, user.getUserImg(), user.getUserName(), false);
    }
}
