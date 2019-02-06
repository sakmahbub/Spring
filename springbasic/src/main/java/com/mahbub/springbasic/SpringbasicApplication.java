package com.mahbub.springbasic;

import com.mahbub.springbasic.autowired.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
     ApplicationContext context= SpringApplication.run(SpringbasicApplication.class, args);
        Student student=context.getBean(Student.class);
student.showDetails();
    }

}

