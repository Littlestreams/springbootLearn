package com.no4.core.exception;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 * @author MR.Q
 * @date 2019年10月12日 下午4:04:38
 */
@RestControllerAdvice
public class CustomExceptionHandler {
   //@ExceptionHandler(Exception.class)
	public Map<String, Object> customExceptionHandler(HttpServletRequest request,
			HttpServletResponse response,Exception e){
		Map<String, Object> retMap = new HashMap<String, Object>();

		retMap.put("code", response.getStatus());
		retMap.put("msg", e.getMessage());
		retMap.put("time", new Date());
		retMap.put("url", request.getRequestURI());
		return retMap;
   }
}