package com.uzero.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author 千叶零
 * @version 1.0
 * creates 2023-02-21  09:25:40
 * 替换HttpServlet，根据请求的最后一段路径来进行方法分发
 */
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求路径
        String uri = req.getRequestURI();  // /brand_demo01_war/brand/selectAllServlet

        //2.获取最后一段路径（方法名）
        //获得最后一个 "/" 的索引
        int index = uri.lastIndexOf("/");
        //截取 最后一个 "/" 的索引 后的所有字符串为方法名
        String methodName = uri.substring(index + 1);

        //执行方法
        //获取BrandServlet 与 UserServlet 字节码对象 Class
        //谁调用此方法，这（this）就代表谁
        Class<? extends BaseServlet> aClass = this.getClass();

        //获取 Method对象
        try {
            //使用 this的Class对象调用 getMethod(方法名，方法参数.class，方法参数.class) 获得方法对象
            Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //执行方法 (对象，参数，参数)
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
