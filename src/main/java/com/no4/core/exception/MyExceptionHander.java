package com.no4.core.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 * @author MR.Q
 * @date 2019年10月12日 下午2:31:34
 */
//@RestControllerAdvice
@ControllerAdvice
public class MyExceptionHander {
	/**
	 * 捕获自定义异常myException
	 * @param e
	 * @return json格式类型
	 */
	//@ExceptionHandler(MyException.class)//指定拦截异常的类型
	 //返回的状态码
    //@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR) //服务内部错误
	public Map<String, Object> myExceptionHandler(HttpServletRequest request,
			MyException e) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("code", e.getStatuCode());
		retMap.put("msg", e.getResultMsg());
		retMap.put("time", new Date());
		retMap.put("url", request.getRequestURI());
		return retMap;
	}
	 /**
     * 捕获CustomException
     * @param e
     * @return 视图
     */
    @ExceptionHandler({MyException.class})
    public ModelAndView customModelAndViewExceptionHandler(MyException e) {
		Map<String, Object> retMap = new HashMap<String, Object>();
    	retMap.put("code", e.getStatuCode());
		retMap.put("msg", e.getResultMsg());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error/error");
        modelAndView.addObject(retMap);
        return modelAndView;
    }
}
