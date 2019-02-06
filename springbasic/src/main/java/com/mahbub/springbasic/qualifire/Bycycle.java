package com.mahbub.springbasic.qualifire;

import org.springframework.stereotype.Component;

@Component(value = "bycyclebean")
public class Bycycle implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bycycle started");
    }

    @Override
    public void stop() {
        System.out.println("Bycycle stoped");
    }
}
