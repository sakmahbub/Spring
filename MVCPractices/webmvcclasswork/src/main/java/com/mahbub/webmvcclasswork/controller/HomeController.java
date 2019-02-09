package com.mahbub.webmvcclasswork.controller;


import com.mahbub.webmvcclasswork.entity.Student;
import com.mahbub.webmvcclasswork.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private StudentRepo repo;


    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("stu", new Student());
        mv.setViewName("index");
        return mv;
    }


    @PostMapping(value = "/")
    public ModelAndView add(@Valid Student student) {
        ModelAndView mv = new ModelAndView();
        if (student.getName() != null) {
            this.repo.save(student);
            mv.addObject("text", "Save Successfully");
            mv.addObject("stu", new Student());
        }


        mv.setViewName("index");
        return mv;
    }

}
