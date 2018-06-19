package com.tci;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduledUpdatesOnTopic {

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedDelay=300)
    public void publishUpdates(){
        template.convertAndSend("/topic/greetings", new Greeting());
    }
}
