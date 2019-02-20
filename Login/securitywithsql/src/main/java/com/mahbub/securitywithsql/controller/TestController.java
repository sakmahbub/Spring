package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private UserRepo userRepo;


    @ResponseBody
    @GetMapping("/test")
    public User display(){
        return userRepo.findByUserName("sakmahbub");

    }

}
