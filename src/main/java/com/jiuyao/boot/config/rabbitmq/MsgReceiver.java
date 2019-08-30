package com.jiuyao.boot.config.rabbitmq;

import com.jiuyao.boot.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiver {



    @RabbitHandler
    public void process(String content) {
        log.info("消费队列中的消息==============" + content);
    }

}
