package com.no4.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
//@WebFilter(urlPatterns="/*",filterName="loginFilter")
public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter初始化....strat");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoginFilter过滤....strat");
		long startTime = System.currentTimeMillis();
		HttpServletRequest hrequest =(HttpServletRequest) request;
		String userName =(String) hrequest.getAttribute("name");
		//模拟登录操作
		if("jason".equals(userName)) {
		chain.doFilter(request, response);
		}else {
			System.out.println("用户名不正确，请重新登录");
		}
		long endTime = System.currentTimeMillis();
		System.out.println("请求响应时间：" + (endTime - startTime));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoginFilter销毁....strat");
	}
}
