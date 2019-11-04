package com.no4.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.no4.core.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * Restful接口定义与展示
 * @author MR.Q
 * @date 2019年10月15日 下午3:57:34
 */
@RestController
@RequestMapping(value="api/v1")
@Api(value = "api/v1", description = "用户信息管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class SwaggerController {
	 private static final Logger logger = LoggerFactory.getLogger(SwaggerController.class);
     /**
      * 添加用户
      */
	 @ApiOperation(value="创建用户", notes="新增之后返回对象")
	 @RequestMapping(value="/insert/{userName}/{age}/{likes}", method = {RequestMethod.GET})
	 @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "path")
	 @ApiResponse(code =500,message = "参数没有填好",response = String.class)
	 public User insert(@PathVariable("userName") String userName,@PathVariable("age") String age,@PathVariable("likes") String likes) {
		 User user = new User();
		 user.setAge(age);
		 user.setUserName(userName);
		 user.setLikes(likes);
		 return user;
		 
	 }
}
