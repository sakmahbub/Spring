package com.mahbub.springbasic.test;

import com.mahbub.springbasic.context.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Vehicle vehicle = (Vehicle) context.getBean("vehicle");
        vehicle.drive();
    }

}
