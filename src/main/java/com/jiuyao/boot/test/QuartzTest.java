//package com.jiuyao.boot.test;
//
//import com.jiuyao.boot.config.MyJob;
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import java.util.Date;
//
///**
// * Quartz 触发器
// */
//public class QuartzTest {
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        // 创建工作
//        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withDescription("工作的描述").withIdentity("工作的名称", "工作的组")
//                .build();
//        // 创建触发器
//        Trigger trigger = TriggerBuilder.newTrigger().withDescription("触发器的描述").withIdentity("触发器的名称", "触发器的组")
//                .withSchedule(CronScheduleBuilder.cronSchedule("0 52 11 ? * *")) // "0/5 11 * ? * *"表达式
//                .startAt(new Date())// 不设置，默认为当前时间
//                .build();
//        // 创建调度器，粘合工作和触发器
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = null;
//        try {
//            scheduler = schedulerFactory.getScheduler();
//            scheduler.scheduleJob(jobDetail, trigger);
//            // 启动调度器
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//}
