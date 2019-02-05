package com.mahbub.springioc.test;

import com.mahbub.springioc.entity.Student;
import com.mahbub.springioc.entity.StudentConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
ApplicationContext context=new AnnotationConfigApplicationContext(StudentConfig.class);
        Student student=(Student)context.getBean(Student.class);
        student.displayInfo();


    }

}
