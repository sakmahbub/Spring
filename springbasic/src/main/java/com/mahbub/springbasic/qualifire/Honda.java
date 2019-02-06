package com.mahbub.springbasic.qualifire;

import org.springframework.stereotype.Component;

@Component(value = "hondabean")
public class Honda implements Vehicle {


    @Override
    public void start() {
        System.out.println("Honda started");
    }

    @Override
    public void stop() {
        System.out.println("Honda stoped");
    }
}
