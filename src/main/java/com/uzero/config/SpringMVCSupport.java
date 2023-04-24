package com.uzero.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 千叶零
 * @version 1.0
 * create 2023-04-24  14:39:19
 */
@Configuration
public class SpringMVCSupport extends WebMvcConfigurationSupport {

    //静态资源映射
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/Brand.html").addResourceLocations("/Brand.html");
        registry.addResourceHandler("/Login.html").addResourceLocations("/Login.html");
        registry.addResourceHandler("/Register.html").addResourceLocations("/Register.html");
        registry.addResourceHandler("/63406580_p31.jpg").addResourceLocations("/63406580_p31.jpg");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/element-ui/**").addResourceLocations("/element-ui/");
        registry.addResourceHandler("/element-#4E06B3/**").addResourceLocations("/element-#4E06B3/");
    }
}
