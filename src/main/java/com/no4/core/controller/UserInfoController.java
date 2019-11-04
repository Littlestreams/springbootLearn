package com.no4.core.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.no4.core.model.User;

@RestController
@RequestMapping(value="v2")
public class UserInfoController {
 @PostMapping(value="/userInfo")
 public String getUserInfo(@RequestBody User user,boolean flag) {
	String users=null;
	 if(flag) {
		 users=user.toString();
	}
	 System.out.println("users:"+users);
	return users;	   
 }
}
