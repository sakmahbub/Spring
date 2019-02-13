package com.mahbub.aopone.test;

import com.mahbub.aopone.entity.Employee;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("aop-context.xml");
        Employee employee=(Employee) context.getBean("simpleServiceProxy");
        employee.printNameId();
        System.out.println("----------------------------------");
        try {
            employee.checkName();
        }catch (Exception e){
            System.out.println("Employee: Method checkName() exception thrown..");

        }
        System.out.println("----------------------------------");
        employee.sayHello("WoW!");
        context.close();
    }
}
