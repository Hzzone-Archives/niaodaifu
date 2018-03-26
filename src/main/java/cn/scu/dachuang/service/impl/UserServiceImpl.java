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

@Service
public class UserServiceImpl implements UserService{


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
        if(null == user.getOpenId())
            throw new RegisterException("invalid user_id");
        User result = null;
        try{
            result = findUserByID(user.getOpenId());
        }catch (LoginException e){}
        if (null != result)
            throw new RegisterException("user exists!");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insert(user);
        sqlSession.close();
        return 0;
    }
}
