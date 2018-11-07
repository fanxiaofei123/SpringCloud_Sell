//package com.imooc.order.message;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableBinding(StreamCliente.class)
//@Slf4j
//public class StreamReceiver {
//
//    @StreamListener(StreamCliente.INPUT)
//    @SendTo(StreamCliente.INPUT2)
//    public String process(Object message){
//        log.info("StreamReceiver: {}",message);
//        return "receiver.";
//    }
//
//    @StreamListener(value = StreamCliente.INPUT2)
//    public String process2(Object message){
//        log.info("StreamReceiver2: {}",message);
//        return "receiver.";
//    }
//}
