package com.mahbub.webmvcclasswork.controller;


import com.mahbub.webmvcclasswork.entity.Student;
import com.mahbub.webmvcclasswork.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private StudentRepo repo;

    @GetMapping("/add")
    public String showForm(Student student) {

        return "add-page";
    }


    @PostMapping("/add")
    public String save(@Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-page";

        }
        this.repo.save(student);
        model.addAttribute("student", new Student());
        model.addAttribute("text", "Congratulations! Data save sucessfully");
        return "add-page";
    }



    @PostMapping("/edit")
    public String edit(@Valid Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-page";

        }
        this.repo.save(student);
        model.addAttribute("student", new Student());
        return "redirect:/";
    }


    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("list",this.repo.findAll());
        return "index";

    }


    @GetMapping(value = "/del/{id}")
    public String del(@PathVariable("id") Long id, Model model){
       if(id !=null){
           this.repo.deleteById(id);
           model.addAttribute("delMsg","Delete A Student Succesfully");
       }
        return "redirect:/";

    }
}
