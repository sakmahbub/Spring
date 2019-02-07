package com.mahbub.hellomvc.controller;


import com.mahbub.hellomvc.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentCont {

    static List<Student> list;

    @GetMapping(value = "shome")
    public String home(){
        return "Hello Student";


    }

    static {
list=new ArrayList<>();
        list.add(new Student(1,"mahbub","Male", "Round-37","sakmahbub@gmail.com"));
        list.add(new Student(2,"Sakil","Male", "Round-39","sakilb@gmail.com"));
        list.add(new Student(3,"Ruhul","Male", "Round-36","ruhul@gmail.com"));
        list.add(new Student(4,"Nazmul","Male", "Round-40","nazmul@gmail.com"));
    }


    @GetMapping(value = "/slist")
    public List<Student> sgetList(){


        return this.list;
    }

    @GetMapping(name = "/tt")
    public String test(@RequestParam(value = "ms", required = true, defaultValue = "Hello Student") String msg){
        return msg;

    }

}
