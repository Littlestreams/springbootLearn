package com.no4.core.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
/**
 * 基于注解使用Quartz
 * @author MR.Q
 * @date 2019年10月17日 下午3:41:55
 */
//@Component
//@EnableScheduling
public class HelloBoyJob {
	 private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  //3.添加定时任务
    @Scheduled(cron = "0/2 * * * * ?")
    private void configureTasks() {
    	System.out.println("现在时间是："+sf.format(new Date()));
		System.out.println("hello Boy");    
    }
}
