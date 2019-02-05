package com.mahbub.diconstructoranotation.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee empbeen(){
Employee employee=new Employee(10, "Ruhul", new Address("Mirpur", "Dhaka", "Bangladesh"));
        return employee;
    }


    @Bean
    public Address addbeen(){

        Address address= new Address("Naogaon","Rajshahi", "Bangladesh");
        return address;
    }
}
