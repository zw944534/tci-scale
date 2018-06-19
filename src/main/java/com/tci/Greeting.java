package com.tci;

import java.util.Random;

public class Greeting {
    private float content;
    private float minX = 50.0f;
    private float maxX = 100.0f;

    public Greeting() {
        Random rand = new Random();
        content = rand.nextFloat() * (maxX - minX) + minX;
    }


    public float getContent() {
        return content;
    }
}
