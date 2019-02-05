package com.mahbub.diconstructor.test;

import com.mahbub.diconstructor.entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee=(Employee)context.getBean("emp");
        employee.show();
    }
}
