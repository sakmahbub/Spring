package com.mahbub.beanlifecycle2.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {
    private long id;
    private String name;

    public void setId(long id) {
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

    @Override
    public void destroy() throws Exception {
        System.out.println("I am in Destry.........");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I am in afterPropertiesSet....");

    }
}
