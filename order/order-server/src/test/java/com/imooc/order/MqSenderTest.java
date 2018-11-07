package com.imooc.order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MqSenderTest extends OrderApplicationTests{

        @Autowired
        private AmqpTemplate amqpTemplate;

        @Test
        public void send(){
            amqpTemplate.convertAndSend("myQueue","NOW:"+ new Date());
            log.info("Test;send" +
                    "success");
        }

    @Test
    public void sendOrder(){
        amqpTemplate.convertAndSend("myOrder","computer","NOW:"+ new Date());
        log.info("Test;send computer" +
                "success");
    }
}
