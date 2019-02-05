package com.mahbub.autowiring.entity;

import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    private Student student;

    public void checkMethodCall(){

        student.checkStudent();
    }
}
