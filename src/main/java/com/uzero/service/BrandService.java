package com.uzero.service;

import com.uzero.pojo.Brand;
import com.uzero.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 千叶零
 * @version 1.0
 * creats 2023-02-20  15:05:47
 */
public interface BrandService {

    /**
     * 查询所有，返回一个Brand集合
     * @return
     */
    List<Brand> selectAll();


    /**
     * 添加数据，传入一个Brand对象
     */
    void add(Brand brand);


    /**
     * 修改数据，传入一个Brand对象
     * @param brand
     */
    void update(Brand brand);


    /**
     * 传入一个id，根据id删除对应数据
     * @param id
     */
    void deleteById(int id);


    /**
     * 根据数个id，实现删除多个对应的数据
     * @param ids
     */
    void deleteByIds(int[] ids);


    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页展示条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    /**
     * 分页条件查询
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
