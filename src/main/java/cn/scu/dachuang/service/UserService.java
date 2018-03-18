package cn.scu.dachuang.service;

import cn.scu.dachuang.model.User;

public interface UserService {

    public User findUserByID(String user_id);

    public int registerUser(User user);


}
