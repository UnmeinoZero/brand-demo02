package com.uzero.mapper;

import com.uzero.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 千叶零
 * @version 1.0
 * creats 2023-02-09  09:59:31
 */
public interface UserMapper {

    /**
     * 根据用户名和密码查询用户对象
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);


    /**
     * 根据用户名查询，是否存在
     * @param username
     * @return
     */
    @Select("select username from tb_user where username = #{username}")
    User selectByName(String username);


    /**
     * 添加数据
     * @param user
     */
    @Insert("insert into tb_user (username, password) values (#{username}, #{password})")
    void add(User user);
}
