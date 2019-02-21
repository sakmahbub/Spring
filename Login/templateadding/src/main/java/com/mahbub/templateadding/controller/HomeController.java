package com.mahbub.templateadding.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

@GetMapping(value = "/")
    public String displayHome(){
        return "index";
    }

    @GetMapping(value = "/test")
    public String displaytest(){
        return "test";
    }
}
