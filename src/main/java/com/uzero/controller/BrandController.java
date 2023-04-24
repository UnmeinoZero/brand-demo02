package com.uzero.controller;

import com.uzero.pojo.Brand;
import com.uzero.pojo.PageBean;
import com.uzero.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 千叶零
 * @version 1.0
 * create 2023-04-24  14:34:03
 */
@RestController
@RequestMapping("/Brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    /**
     * 条件分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    页码数据大小
     * @param brand       品牌对象
     * @return 分页对象
     */
    @PostMapping("/selectByPageAndCondition")
    public PageBean<Brand> selectByPageAndCondition(@RequestParam(defaultValue = "1") String currentPage,
                                                    @RequestParam(defaultValue = "10") String pageSize,
                                                    @RequestBody Brand brand) {

        System.out.println("当前页码和每页展示条数:" + currentPage + "," + pageSize);
        //将接收的数据转为int类型
        int _currentPage = Integer.parseInt(currentPage);
        int _pageSize = Integer.parseInt(pageSize);
        System.out.println("条件查询的对象为：" + brand);
        //调用方法
        return brandService.selectByPageAndCondition(_currentPage, _pageSize, brand);
    }


    /**
     * 添加品牌方法
     *
     * @param brand 匹配对象
     * @return 返回结果信息
     */
    @PostMapping("/add")
    public String add(@RequestBody Brand brand) {
        //调用service
        brandService.add(brand);
        //响应成功标识
        return "success";
    }


    /**
     * 修改品牌数据方法
     *
     * @param brand 品牌对象
     * @return 返回结果信息
     */
    @PostMapping("/update")
    public String update(@RequestBody Brand brand) {
        //调用service
        brandService.update(brand);
        //响应成功标识
        return "success";
    }


    /**
     * 根据id删除对应的数据
     *
     * @param id id
     * @return 返回结果信息
     */
    @GetMapping("/deleteById")
    public String deleteById(@RequestParam String id) {
        //调用删除方法
        brandService.deleteById(Integer.parseInt(id));
        //响应成功标识
        return "success";
    }


    /**
     * 批量删除
     * @param ids id数组
     * @return 返回结果信息
     */
    @PostMapping("/deleteByIds")
    public String deleteByIds(@RequestBody int[] ids) {
        //调用删除方法
        brandService.deleteByIds(ids);
        //响应成功标识
        return "success";
    }
}
