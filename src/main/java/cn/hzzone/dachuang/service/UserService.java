package cn.hzzone.dachuang.service;

import cn.hzzone.dachuang.model.User;

public interface UserService {
    public User findUserByID(String openid);
    public int registerUser(User user);
}
