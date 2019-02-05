package com.mahbub.beanlifecycle4.test;

import com.mahbub.beanlifecycle4.entity.MyAwareService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean("myAwareService", MyAwareService.class);
        context.close();
    }
}
