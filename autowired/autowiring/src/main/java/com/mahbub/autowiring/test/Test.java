package com.mahbub.autowiring.test;

import com.mahbub.autowiring.entity.Student;
import com.mahbub.autowiring.entity.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service=(StudentService)context.getBean("stu2");
        service.checkMethodCall();
    }
}
