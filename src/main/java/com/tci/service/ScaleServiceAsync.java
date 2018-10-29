package com.tci.service;


import com.tci.controller.ScaleController;
import com.tci.model.ScaleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
@Configuration
public class ScaleServiceAsync {

    @Autowired
    private SimpMessagingTemplate template;
    @Async
    public double sendScaleValue(String scale_id){
        // TODO connect scale use socket
        System.out.println("ScaleServiceAsync");
        while (true) {
                template.convertAndSend("/topic/scale", new ScaleValue());
            }

    }

}
