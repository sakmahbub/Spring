package com.mahbub.springioc.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    public Student studentbeen(){

        return new Student();
    }
}
