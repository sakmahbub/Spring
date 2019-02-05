package com.mahbub.diconstructoranotation.test;


import com.mahbub.diconstructoranotation.entity.Address;
import com.mahbub.diconstructoranotation.entity.Employee;
import com.mahbub.diconstructoranotation.entity.EmployeeConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfig.class);
        Employee employee=(Employee) context.getBean(Employee.class);
        employee.show();


//        Address address=(Address)context.getBean(Address.class);
//        System.out.println(address.toString());
    }
}
