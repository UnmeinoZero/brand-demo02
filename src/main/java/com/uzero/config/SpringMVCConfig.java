package com.uzero.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author 千叶零
 * @version 1.0
 * create 2023-04-24  11:56:04
 */
@Configuration
@ComponentScan({"com.uzero.controller", "com.uzero.config"})
@EnableWebMvc
public class SpringMVCConfig {
}
