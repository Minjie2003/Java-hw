package com.example.mybatisplus.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")      //允许跨域访问的路径
                .allowedOrigins("http://localhost:5173") // 允许访问的源
                .allowedMethods("GET", "POST") // 允许的请求方法
                .allowedHeaders("*"); // 允许的请求头
    }
}
