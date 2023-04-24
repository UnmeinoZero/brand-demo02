package com.uzero.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author 千叶零
 * @version 1.0
 * create 2023-04-24  11:55:31
 */
public class MybatisConfig {

    @Bean //定义SqlSession Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.uzero.pojo");
        return factoryBean;
    }

    @Bean //定义扫描映射接口 Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.uzero.mapper");
        return mapperScannerConfigurer;
    }
}
