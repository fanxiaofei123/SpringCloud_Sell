package com.imooc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamCliente {

    String INPUT = "myMessage";

    String INPUT2 = "myMessage";

    @Input(StreamCliente.INPUT)
    SubscribableChannel input();

    @Output(StreamCliente.INPUT)
    MessageChannel output();

    @Input(StreamCliente.INPUT2)
    SubscribableChannel input2();

    @Output(StreamCliente.INPUT2)
    MessageChannel output2();

}
