package cn.scu.dachuang.service.impl;
import cn.scu.dachuang.dao.UserMapper;
import cn.scu.dachuang.exception.LoginException;
import cn.scu.dachuang.exception.RegisterException;
import cn.scu.dachuang.model.User;
import cn.scu.dachuang.service.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService{

    private String default_head_img = "http://tuchuang-1252747889.cosgz.myqcloud.com/2018-03-16-default_head_img.jpg";

    private Date default_birthday = new Date();

    private String default_role = "普通用户";


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public User findUserByID(String user_id) {
        if(null == user_id)
            throw new LoginException("invalid user_id");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User result = userMapper.selectByPrimaryKey(user_id);
        if(null == result)
            throw new LoginException("user not exists!");
        sqlSession.close();
        return result;
    }

    @Override
    public int registerUser(User user) {
        if(null == user.getUserId())
            throw new RegisterException("invalid user_id");
        User result = null;
        try{
            result = findUserByID(user.getUserId());
        }catch (LoginException e){}
        if (null != result)
            throw new RegisterException("user exists!");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        user.setBirthday(default_birthday);
        user.setHeadImg(default_head_img);
        user.setRole(default_role);
        userMapper.insert(user);
        sqlSession.close();
        return 0;
    }
}
