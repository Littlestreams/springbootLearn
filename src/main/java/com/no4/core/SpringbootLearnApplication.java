package com.no4.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.no4.core.filter")
public class SpringbootLearnApplication {
	private static Logger logger = LoggerFactory
			.getLogger(SpringbootLearnApplication.class);

	public static void main(String[] args) {
		logger.info("SpringbootLearnApplication.....start");
		SpringApplication.run(SpringbootLearnApplication.class, args);
		logger.info("SpringbootLearnApplication.....success");
	}

}
