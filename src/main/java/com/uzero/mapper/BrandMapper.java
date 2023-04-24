package com.uzero.mapper;


import com.uzero.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * @author 千叶零
 * @version 1.0
 * creats 2023-02-06  11:04:22
 */
public interface BrandMapper {

    /**
     * 查询所有
     */
    @Select("select * from tb_brand")
    //@ResultMap("brandResultMap")
    List<Brand> selectAll();



    /**
     * 添加数据
     */
    @Insert("insert into tb_brand values (null, #{brandName}, " +
            "#{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);



    /**
     * 修改数据
     */
    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName},ordered = #{ordered},description = #{description}, status = #{status} where id = #{id}")
    void update(Brand brand);



    /**
     * 根据id删除对应数据
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);


    /**
     * 根据数个id，实现删除多个对应的数据
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);


    /**
     * 分页查询
     * @param begin
     * @param size
     * @return
     */
    @Select("select * from tb_brand limit #{begin}, #{size}")
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);


    /**
     * 查询总数据数
     * @return
     */
    @Select("select count(*) from tb_brand")
    int selectTotalCount();


    /**
     * 分页动态条件查询
     * @param begin
     * @param size
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);


    /**
     * 动态条件查询总数据数
     * @return
     */
    int selectTotalCountByCondition(Brand brand);
}
