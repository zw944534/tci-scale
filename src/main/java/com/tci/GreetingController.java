package com.tci;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    public String getMessage(HelloMessage message) throws Exception {
        return "connect OK";
    }

}
