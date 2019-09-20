//package com.jiuyao.boot.config;
//
//import com.jiuyao.boot.config.rabbitmq.MsgProducer;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MyJob implements Job {
//
//    @Autowired
//    private MsgProducer msgProducer;
//
//    @Override
//    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        /**
//         * 要实现定时任务的执行方法
//         */
////        System.out.println("userService.testQiuartz");
////        System.out.println("消费rabbitmq中的消息");
////        for (int i = 0; i < 1000; i++) {
////            msgProducer.sendMsg("消息"+i);
////        }
//    }
//}
