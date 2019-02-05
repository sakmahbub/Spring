package com.mahbub.springioc.entity;

public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void displayInfo(){

setName("Mahbub");
        System.out.println("Hello: "+ name);
    }
}
