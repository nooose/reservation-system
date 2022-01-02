package com.example.reservation.config;

import com.example.reservation.interceptor.LogInterceptor;
import com.example.reservation.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/bootstrap/**", "/css/**", "/images/**", "/fonts/**", "/*.ico",
                        "/jquery/**", "/js/**",
                        "/error");

        registry.addInterceptor(new LoginInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/bootstrap/**", "/css/**", "/images/**", "/fonts/**", "/*.ico",
                        "/jquery/**", "/js/**",
                        "/error", "/login", "/logout");
    }




}