package com.mahbub.beanlifecycle2.test;

import com.mahbub.beanlifecycle2.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
       // ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee=(Employee)context.getBean("emp");
        System.out.println(employee);

context.close();

    }
}
