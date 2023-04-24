package com.uzero.service.impl;

import com.uzero.mapper.UserMapper;
import com.uzero.pojo.User;
import com.uzero.service.UserService;
import com.uzero.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

/**
 * @author 千叶零
 * @version 1.0
 * creats 2023-02-10  16:11:17
 */
@Service
public class UserServiceImpl implements UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 登录方法
     * @param username
     * @param password
     * @return user
     */
    public User login(String username, String password){
        //调用BrandMapper.selectAll()

        //获得 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用UserMapper.selectAll()
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);

        //释放资源
        sqlSession.close();

        return user;
    }


    /**
     * 注册方法
     * @param user
     * @return
     */
    public boolean register(User user){
        //调用BrandMapper.selectAll()

        //获得 sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用UserMapper.selectAll()
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //判断用户是否已存在
        User u = mapper.selectByName(user.getUsername());

        if (u != null){
            //如果查询结果不为null，说明用户已存在，注册失败
            return false;
        }else {
            //注册成功
            //添加数据
            mapper.add(user);

            //提交事务
            sqlSession.commit();

            sqlSession.close();

            return true;
        }
    }
}
