package com.mahbub.beanlifecycle3.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

@PostConstruct
    public void init() throws Exception{
        System.out.println("Im from init...........");


    }
@PreDestroy
    public void cleanUp(){
        System.out.println("Im now clean..........");


    }
}
