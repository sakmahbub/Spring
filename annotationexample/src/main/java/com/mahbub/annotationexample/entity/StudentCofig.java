package com.mahbub.annotationexample.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentCofig {

    @Bean(name = "stu")
    public Student getStudent(){
       Student student=new Student(100, "mahbub") ;
        return student;

    }


@Bean(name = "stu1")
    public Student getStudentBySetter(){

        Student student=new Student();
        student.setId(100);
        student.setName("Sakil");
        return student;

    }
}
