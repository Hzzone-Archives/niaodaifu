package cn.hzzone.dachuang.service.impl;

import cn.hzzone.dachuang.dao.UserMapper;
import cn.hzzone.dachuang.model.User;
import cn.hzzone.dachuang.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Override
    public User findUserByID(String openid) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(openid);
        sqlSession.close();
        return user;
    }

    @Override
    public int registerUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insert(user);
        sqlSession.close();
        return 0;
    }
}
