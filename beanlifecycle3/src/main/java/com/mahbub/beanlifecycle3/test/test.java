package com.mahbub.beanlifecycle3.test;

import com.mahbub.beanlifecycle3.entity.Employee;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee=(Employee)context.getBean("em");
        System.out.println(employee);
        context.close();
    }
}
