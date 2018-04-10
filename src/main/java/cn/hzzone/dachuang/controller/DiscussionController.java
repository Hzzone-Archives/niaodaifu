package cn.hzzone.dachuang.controller;

import cn.hzzone.dachuang.model.*;
import cn.hzzone.dachuang.service.DiscussionService;
import cn.hzzone.dachuang.service.UserService;
import cn.hzzone.dachuang.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class DiscussionController {

    @Autowired
    DiscussionService discussionService;

    @Autowired
    UserService userService;

    @GetMapping("/all_posts")
    public List<PostDetail> getAllPosts() {
        List<PostDetail> postDetails = discussionService.findAllPost();
        return postDetails;
    }

    @PostMapping("/add_post")
    public PostDetail addNewPost(@RequestParam("content") String content,
                                 @RequestParam("title") String title,
                                 @RequestParam("openid") String openid) {
        String postid = UUID.randomUUID().toString();
        Date post_time = new Date();
        Post post = new Post(postid, post_time, content, title, openid);

        PostDetail postDetail = discussionService.insertNewPost(post);
//        User user = userService.findUserByID(openid);
//        PostDetail postDetail = new PostDetail(post, user.getUserImg(), user.getUserName(), false);
        return postDetail;
    }

    @PostMapping("/delete_support")
    public Message<Integer> deleteSupport(@RequestParam("supportid") String supportid,
                                          @RequestParam("openid") String openid) {
        Support support = new Support();
        support.setOpenId(openid);
        support.setSupportId(supportid);
        int d = discussionService.deleteSupport(support);
        return new Message<>(d, 1, "删除点赞成功");
    }


    @PostMapping("/add_support")
    public Message<Integer> addSupport(@RequestParam("supportid") String supportid,
                                          @RequestParam("openid") String openid) {
        Support support = new Support();
        support.setOpenId(openid);
        support.setSupportId(supportid);
        int d = discussionService.insertSupport(support);
        return new Message<>(d, 1, "插入点赞成功");
    }

    @PostMapping("/all_comments")
    public List<CommentDetail> findAllComments(@RequestParam("postid") String postid, @RequestParam("openid") String openid) {
        List<CommentDetail> commentDetails = discussionService.findAllCommentsByPostID(postid, openid);
        return commentDetails;
    }

    @PostMapping("/add_comment")
    public CommentDetail addNewComment(@RequestParam("content") String content,
                                             @RequestParam("from_openid") String from_openid,
                                             @RequestParam("to_openid") String to_openid,
                                             @RequestParam("postid") String postid) {
        String commentid = UUID.randomUUID().toString();
        Date comment_time = new Date();
        Comment comment = new Comment(commentid, postid, from_openid, to_openid, content, comment_time);
        CommentDetail commentDetail = discussionService.insertNewComments(comment);
        return commentDetail;
    }
}
