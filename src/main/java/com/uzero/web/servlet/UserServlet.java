package com.uzero.web.servlet;

import com.alibaba.fastjson.JSON;
import com.uzero.pojo.User;
import com.uzero.service.UserService;
import com.uzero.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author 千叶零
 * @version 1.0
 * creates 2023-02-21  09:29:05
 */

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

    //创建一个UserService实例
    private UserService userService = new UserServiceImpl();

    /**
     * 登录方法
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //接收提交的数据
        BufferedReader reader = request.getReader();

        //读取数据
        String params = reader.readLine(); //JSON字符串

        System.out.println("输入的用户名密码为：" + params);

        //转为Brand对象
        User user = JSON.parseObject(params, User.class);

        //调用service
        User login = userService.login(user.getUsername(), user.getPassword());

        System.out.println("登陆结果：" + login);

        //判断是否登录成功
        if (login == null){ //如果失败，响应数据标识
            response.getWriter().write("logonFailure");
        }

    }


    /**
     * 注册方法
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("UTF8");


        //接收提交的数据
        BufferedReader reader = request.getReader();

        //读取数据
        String params = reader.readLine(); //JSON字符串

        System.out.println("注册的用户名密码为：" + params);

        //转为Brand对象
        User user = JSON.parseObject(params, User.class);


        //调用service 注册
        boolean flag = userService.register(user);

        System.out.println("注册是否成功：" + flag);


        //判断是否注册成功
        if (flag) {

            //注册成功，响应成功标识
            response.getWriter().write("success");
        } else {

            //注册失败,响应失败标识
            response.getWriter().write("registrationFailed");
        }
    }
}
