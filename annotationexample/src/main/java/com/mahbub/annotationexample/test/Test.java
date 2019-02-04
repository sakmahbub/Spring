package com.mahbub.annotationexample.test;

import com.mahbub.annotationexample.entity.Student;
import com.mahbub.annotationexample.entity.StudentCofig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(StudentCofig.class);
        Student student=(Student)context.getBean("stu");
        System.out.println(student);


        Student student1=(Student)context.getBean("stu1");
        System.out.println(student1);
    }


}
