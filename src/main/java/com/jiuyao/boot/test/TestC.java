package com.jiuyao.boot.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class TestC {
    public static void main(String[] args) {

            System.out.println(new Date());
            /**
             * 日志的级别 由低到高 trace(跟踪) < debug(调试) < info(信息) < warn(警告) < error(错误)
             * 可以在配置文件中调整输出的日志级别,日志就只会在这个级别及以后的高级别生效
             * Spring Boot 默认使用info级别
             */
            log.trace("这是 trace 日志...");
            log.debug("这是 debug 日志...");
            log.info("这是 info 日志...");
            log.warn("这是 warn 日志...");
            log.error("这是 error 日志...");
        }

}
