package org.fb.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PreprocessedTasksReceiver {

    private static final Logger LOG = LoggerFactory.getLogger(PreprocessedTasksReceiver.class);

    @RabbitListener(queues = "preprocessed-tasks")
    public void receive(String message){

    }

}
