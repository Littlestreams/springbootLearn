package com.no4.core.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.no4.core.interceptor.MyInterceptor;
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
	}
}
