package com.uzero.service;

import com.uzero.pojo.User;

/**
 * @author 千叶零
 * @version 1.0
 * creates 2023-02-23  09:29:13
 */
public interface UserService {

    /**
     * 登录方法
     * @param username
     * @param password
     * @return user
     */
    User login(String username, String password);


    /**
     * 注册方法
     * @param user
     * @return
     */
    boolean register(User user);
}
