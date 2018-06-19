package com.tci.controller;

import com.tci.model.Scale;
import com.tci.service.ScaleServiceAsync;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ScaleController {

//    @Autowired
//    private ScaleServiceAsync scaleServiceAsync;

    @MessageMapping("/scale")
    public String connect(Scale scale){

        // TODO connect scale use socket(Async)


        return "connect ok";
    }

    //Disconnect method if need
    @MessageMapping("/disconnect")
    public String disconnect(){
        // TODO
        return "disconnect";
    }
}
