package com.tci.model;

import org.springframework.messaging.handler.annotation.SendTo;

public class ScaleValue {

    private double value;

    public ScaleValue() {
        value=90;
    }

    public ScaleValue(double value) {
        this.value = value;
    }
    @SendTo("/topic/scale")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
