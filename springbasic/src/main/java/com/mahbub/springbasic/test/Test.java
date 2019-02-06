package com.mahbub.springbasic.test;



import com.mahbub.springbasic.autowired.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Test {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(Test.class, args);
        Student student=context.getBean(Student.class);
//kaj kore na, SpringbasicApplication a run dite hobe


    }

}
