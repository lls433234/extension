//package com.jiuyao.boot.config;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @ Author     ：Zgq
// * @ Date       ：Created in 11:49 2019/6/6
// * @ Description：2.---->Quartz定时器
// * @ Modified By：
// * @Version: $
// */
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail teatQuartzDetail1(){
//        return JobBuilder.newJob(MyJob.class).withIdentity("testQuartz1").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger testQuartzTrigger1(){
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(5)  //设置时间周期单位秒
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail1())
//                .withIdentity("testQuartz1")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//
//}
//
