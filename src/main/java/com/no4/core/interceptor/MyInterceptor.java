package com.no4.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器,登录检查
 * 
 * @author MR.Q
 * @date 2019年10月14日 下午4:47:13
 */
public class MyInterceptor implements HandlerInterceptor {
	private long start = System.currentTimeMillis();
	//目标方法执行前
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		// 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
        String  userName = (String) httpServletRequest.getParameter("username");
        System.out.println("userName:"+userName);
		if (userName == null) {
            // 未登录，给出错误信息，
            // 获取request返回页面到登录页
        	System.out.println("无权限请先登录");
            return false;
        } else {
            // 已登录，放行
        	System.out.println("登录成功");
            return true;
        }
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
		System.out.println("Interceptor cost=" + (System.currentTimeMillis() - start));
	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}
