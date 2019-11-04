package com.no4.core.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.no4.core.filter.ReqEndTimeLog;

//@Configuration
public class FilterConfig {
  //@Bean
  public FilterRegistrationBean registFilter() {
	  //Springboot中会使用FilterRegistrationBean来注册Filter
	  FilterRegistrationBean registration = new FilterRegistrationBean();
	  //注册一个filter实例
	  registration.setFilter(new ReqEndTimeLog());
	  //设置过滤路径，/*所有路径
	  registration.addUrlPatterns("/*");
	  //设置过滤器名称
	  registration.setName("ReqEndTimeLogFilter");
	  //设置过滤器优先级
	  registration.setOrder(1);
	return registration;
	  
  }
}
