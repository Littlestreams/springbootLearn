package com.no4.core.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger的配置类
 * 
 * @author MR.Q
 * @date 2019年10月15日 下午3:31:55
 */
@Configuration	// 该注解就是告诉Spring这个是一个配置文件类，这里配置的Bean要交给Spring去管理。这个就是用来取代Beans.xml这种文件的。
@EnableSwagger2	// 启用 Swagger
//@Profile({"dev","test"})//生产禁用swagger
//@ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
public class SwaggerConfig {
	@Bean
	  public Docket createRestApi() {
		  return new Docket(DocumentationType.SWAGGER_2)
			         .apiInfo(apiInfo())
			         .select()
			         .apis(RequestHandlerSelectors.basePackage("com.no4.core.controller"))
			         .paths(PathSelectors.any())
			         .build();
	  }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("标题：某公司_用户信息管理系统_接口文档")//项目标题
                .description("描述：用于管理集团旗下公司的人员信息")//功能描述
				 .contact(new Contact("Teamo", null, null))//作者
				.version("0.0.1")//版本		
				.build();
	}
}
