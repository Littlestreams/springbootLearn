package com.no4.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.no4.core.config.StudentCore;
import com.no4.core.exception.MyException;

@RestController
@RequestMapping(value = "v1")
public class HelloController {
	@Autowired
	private StudentCore studentCore;
	@Value("${name}")
	private String name;
	@Value("${age}")
	private String age;
	@Value("${context}")
	private String context;
	@RequestMapping(value = "/hello")
	public String hello() {
		return "hello world!!!";
	}
	@RequestMapping(value = "/say")
	public String say() {
		System.out.println("热部署...");
		System.out.println("热部署22...");
		return "hello,"+name+",今年"+age+"岁了";
	}
	@RequestMapping(value = "/query")
	public String query() {
		return context;
	}
	@RequestMapping(value = "/stu")
	public String queryStudent() {
		return studentCore.getUname()+",今年"+studentCore.getUage()+
				"岁了,喜欢"+studentCore.getLike();
	}
	@RequestMapping(value = "/exc")
	public String exceptionHandler() {
       throw new MyException("404", "访问的页面不见了！！");
	}
	
	@RequestMapping(value = "/cusexc")
	public int customExceptionHandler(HttpServletRequest request) {
     int a=4/0;
     return a;
	}
}
