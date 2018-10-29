package com.tci.controller;


import com.tci.model.Scale;

import com.tci.service.ScaleServiceAsync;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;


@Controller
@EnableAsync
public class ScaleController extends AbstractWebSocketHandler {
    @Autowired
    private ScaleServiceAsync scaleServiceAsync;
    private MessageSendThread thread ;   //send msg thread
    private Scale scale;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //get scale id
        String id = message.getPayload().trim();
        if(thread == null){
            thread = new MessageSendThread(session,id);
            thread.start();
        }
        scale.setId(id);
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        if(thread != null)
            thread.kill();
    }
    private class MessageSendThread extends Thread{
        private volatile boolean isRunning = true;
        private WebSocketSession session ;
        private volatile String id;
        public MessageSendThread(WebSocketSession session, String id) {
            this.session = session;
            this.id = id;
        }

        @Override
        public void run() {
            while(isRunning){
                try {
                    String sendMsg = String.valueOf(scaleServiceAsync.sendScaleValue(id));    //get value from service
                    session.sendMessage(new TextMessage(sendMsg));
                    Thread.sleep(1000);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                }
            }
        }
        public void kill(){
            isRunning = false;
        }

    }
}
