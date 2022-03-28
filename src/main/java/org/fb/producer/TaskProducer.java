package org.fb.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TaskProducer {

    private static final Logger LOG = LoggerFactory.getLogger(TaskProducer.class);

    private RabbitTemplate rabbitTemplate;

    public TaskProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 1000L)
    public void produceTask(){
        try {
            String task = UUID.randomUUID().toString();
            LOG.info("Producing task: {}", task);
            rabbitTemplate.convertAndSend("work-inbound", "", task);
            LOG.info("Task {} sent to work-inbound exchange");
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw e;
        }
    }

}
