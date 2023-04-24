package com.uzero.controller;

import com.uzero.pojo.User;
import com.uzero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 千叶零
 * @version 1.0
 * create 2023-04-24  14:33:51
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录方法
     *
     * @param user 用户
     * @return 返回登陆结果
     */
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        //调用service
        User login = userService.login(user.getUsername(), user.getPassword());
        System.out.println("登陆结果：" + login);
        return login != null ? "success" : "logonFailure";
    }


    /**
     * 注册方法
     *
     * @param user 用户
     * @return 返回注册信息
     */
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println("注册的用户名密码为：" + user);
        //调用service 注册，并返回结果
        return userService.register(user) ? "success" : "registrationFailed";
    }
}
