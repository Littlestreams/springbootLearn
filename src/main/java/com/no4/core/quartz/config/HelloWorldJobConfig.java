package com.no4.core.quartz.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.no4.core.quartz.HelloWorldJob;

//@Configuration
public class HelloWorldJobConfig {
 @Bean
 public JobDetail helloWorldJobDetail() {
	 //创建一个JobDetail实例，并将该实例与HelloWorldJob绑定
	return JobBuilder.newJob(HelloWorldJob.class)
			.withIdentity("helloWorldJob", "helloWorldJobGroup")
			.storeDurably()// 即使没有Trigger关联时，也不删除该JobDetail
			.requestRecovery() // 执行中应用发生故障，需要重新执行
			.usingJobData("a", "123")
			.usingJobData("b", "456") // 以Key-Value形式关联数据
			.build();// 定义标识符
	    
   }
 @Bean
 public Trigger helloWorldJobTrigger() {
	 //创建一个 Trigger 实例，定义该 job 立即执行，并且每隔两秒重复执行一次，直到永远
	 return TriggerBuilder.newTrigger()
			 .forJob(helloWorldJobDetail())
			 .withIdentity("helloWorldJobTrigger")
			 //.startAt(DateBuilder.futureDate(20, IntervalUnit.SECOND)) // 延迟20秒开始
			 .startNow()//立即执行
			 //.withSchedule(SimpleScheduleBuilder.repeatMinutelyForever()) // 每分钟触发一次，无限循环
			 .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
			 .usingJobData("key3", "value3")
			 .usingJobData("key4", "value4") // 以Key-Value形式关联数据
			 .build();

 }
}
