package com.example.demo.atools.log.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 拦截请求
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 在 WebConfigurer 中的 addInterceptors 中添加拦截,放行
         * addPathPatterns("/**") 表示拦截所有的请求，
         * excludePathPatterns("/login", "/register") 表示对登录注册放行 TODO
         */
        registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
    }

}

