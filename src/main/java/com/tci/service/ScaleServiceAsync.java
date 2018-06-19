package com.tci.service;


import com.tci.model.ScaleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
//@EnableAsync
public class ScaleServiceAsync {


//    @Autowired
//    private SimpMessagingTemplate template;

    public void sendScaleValeu(){
        // TODO connect scale use socket
//        while (true){
//            template.convertAndSend("/topic/", new ScaleValue());
//        }
    }
}
