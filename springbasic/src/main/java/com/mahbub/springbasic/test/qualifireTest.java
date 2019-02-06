package com.mahbub.springbasic.test;

import com.mahbub.springbasic.qualifire.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class qualifireTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Scan Beans
        context.scan("com.mahbub.springbasic.qualifire");
        context.refresh();

        VehicleService vehicleService = context.getBean(VehicleService.class);
        vehicleService.service();
        context.close();
    }
}
