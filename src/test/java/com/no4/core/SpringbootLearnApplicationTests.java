package com.no4.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearnApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Test
	public void testPort() {
		String serverUrl = "http://10.1.82.89:8110";
		String serverPort = serverUrl.substring(serverUrl.lastIndexOf(":"));
		System.out.println("serverPort:"+serverPort);
	}
}
