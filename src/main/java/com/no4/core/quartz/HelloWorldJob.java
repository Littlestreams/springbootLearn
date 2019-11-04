package com.no4.core.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
/**
 * 每隔两秒打印一次hell world
 * @author MR.Q
 * @date 2019年10月17日 上午10:01:03
 */
//@Component
//@EnableScheduling
public class HelloWorldJob extends QuartzJobBean {
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	protected void executeInternal(JobExecutionContext context) 
			throws JobExecutionException {
		System.out.println("现在时间是："+sf.format(new Date()));
		System.out.println("hello world");     
	}
}
