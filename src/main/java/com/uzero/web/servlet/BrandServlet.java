package com.uzero.web.servlet;

import com.alibaba.fastjson.JSON;
import com.uzero.pojo.Brand;
import com.uzero.pojo.PageBean;
import com.uzero.service.BrandService;
import com.uzero.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author 千叶零
 * @version 1.0
 * creates 2023-02-21  09:29:05
 */

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{

    //创建一个 BrandService 实例
    private BrandService brandService = new BrandServiceImpl();


    /**
     * 查询所有数据方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service查询
        List<Brand> brands = brandService.selectAll();

        //转为JSON
        String jsonString = JSON.toJSONString(brands);

        //写入数据
        //设置响应内容为JSON格式，字符编码为UTF-8
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    /**
     * 添加数据方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //接收提交的数据
        BufferedReader reader = request.getReader();

        //读取数据
        String params = reader.readLine(); //JSON字符串

        System.out.println(params);

        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //调用service
        brandService.add(brand);

        //响应成功标识
        response.getWriter().write("success");
    }


    /**
     * 修改数据方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //接收提交的数据
        BufferedReader reader = request.getReader();

        //读取数据
        String params = reader.readLine(); //JSON字符串

        //转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //调用service
        brandService.update(brand);

        //响应成功标识
        response.getWriter().write("success");
    }


    /**
     * 根据id删除对应的数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要删除的id
        String id = request.getParameter("id");

        //调用删除方法
        brandService.deleteById(Integer.parseInt(id));

        //响应成功标识
        response.getWriter().write("success");
    }


    /**
     * 批量删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收数据
        BufferedReader reader = request.getReader();
        //得到JSON字符串
        String params = reader.readLine();

        System.out.println("选中数据的id数组为：" + params);

        //将接收的JSON字符串转为int数组
        int[] ids = JSON.parseObject(params, int[].class);

        //调用删除方法
        brandService.deleteByIds(ids);

        //响应成功标识
        response.getWriter().write("success");
    }


    /**
     * 分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数 （当前页码和每页展示条数）
        //url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        System.out.println("当前页码和每页展示条数:" + _currentPage + "," + _pageSize);

        //将接收的数据转为int类型
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //调用方法
        PageBean<Brand> brandPageBean = brandService.selectByPage(currentPage, pageSize);

        //转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //写入数据
        //设置响应内容为JSON格式，字符编码为UTF-8
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }


    /**
     * 条件分页查询
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //接收参数 （当前页码和每页展示条数）
        //url?currentPage=1&pageSize=5
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");

        System.out.println("当前页码和每页展示条数:" + _currentPage + "," + _pageSize);

        //将接收的数据转为int类型
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //获取对应的查询条件对象
        //接收数据
        BufferedReader reader = request.getReader();
        //得到JSON字符串
        String params = reader.readLine();

        System.out.println("条件查询的对象为：" + params);

        //将JSON数据转为Brand对象
        Brand brand = JSON.parseObject(params, Brand.class);

        //调用方法
        PageBean<Brand> brandPageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        //转为JSON
        String jsonString = JSON.toJSONString(brandPageBean);

        //写入数据
        //设置响应内容为JSON格式，字符编码为UTF-8
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
