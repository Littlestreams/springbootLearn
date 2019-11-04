package com.no4.core.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
/**
 * 动态执行定时任务(实现接口SchedulingConfigurer)
 * @author MR.Q
 * @date 2019年10月17日 下午4:39:45
 */
//@Component
//@EnableScheduling
public class HelloGirlsJob implements SchedulingConfigurer{
	 private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 @Mapper
	    public interface CronMapper {
	        @Select("select cron from cron limit 1")
	        String getCron();
	    }

	 @Autowired
	 @SuppressWarnings("all")
	 CronMapper cronMapper;
	
	 /**
	  * 执行定时任务
	  */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable() {		
			@Override
			public void run() {
				//每隔两秒打印
				this.printHelloGirls();		
			}
			
		public void printHelloGirls() {
		 	System.out.println("现在时间是："+sf.format(new Date()));
			System.out.println("hello Girls");  
		}
		
		}, new Trigger() {
			
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				// 任务触发，可修改任务的执行周期
				String cron = cronMapper.getCron();
				//实际开发写法
				//cron = tEtripQuarzJobService.selectEtripJobByName("tEtripNotifyResult").getCronExpression();
				CronTrigger trigger = new CronTrigger(cron);
				return trigger.nextExecutionTime(triggerContext);
			}
		});	
	}
}


