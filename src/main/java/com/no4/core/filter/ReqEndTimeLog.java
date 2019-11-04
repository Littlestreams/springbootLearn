package com.no4.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 过滤器
 * @author MR.Q
 * @date 2019年10月14日 下午4:13:20
 */
public class ReqEndTimeLog implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("ReqEndTimeLogFilter初始化....strat");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("ReqEndTimeLogFilter过滤....strat");
		long startTime =System.currentTimeMillis();
		chain.doFilter(request, response);
		long endTime =System.currentTimeMillis();
		System.out.println("请求响应时间："+(endTime-startTime));
      
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("ReqEndTimeLogFilter销毁....strat");
	}
}
