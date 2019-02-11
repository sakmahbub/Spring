package com.mahbub.webmvccroud.controller;


import com.mahbub.webmvccroud.entity.Student;
import com.mahbub.webmvccroud.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;


@Controller
public class HomeController {

        @Autowired
        private StudentRepo repo;

    @GetMapping(value = "/")
    public String index(Model model){
         model.addAttribute("list",this.repo.findAll());
            return "index";

    }

    @GetMapping("/add")
    public String showForm(Student student){
        return "add";
    }

    @PostMapping("/add")
    public String doSave(@Valid Student student,  BindingResult bindingResult, Model model){
            if(bindingResult.hasErrors()){
                return "add";

            }
            student.setRegiDate(new Date());
            this.repo.save(student);
            model.addAttribute("student", new Student());
//            model.addAttribute("msgg", "Congratulations! Data save sucessfully");
            return "redirect:/";
    }


            @GetMapping(value = "/edit/{id}")
            public String editView(Model model, @PathVariable("id") Long id){
                model.addAttribute("student", this.repo.getOne(id));
                return "edit";

    }


             @PostMapping(value = "/edit/{id}")
             public String edit(@Valid Student student,BindingResult bindingResult, @PathVariable("id") Long id, Model model){
                     Student student1=this.repo.getOne(id);

                        if(bindingResult.hasErrors()){
                            return "edit";

                        }
                        student.setRegiDate(student1.getRegiDate());
                        this.repo.save(student);
//                        model.addAttribute("student", new Student());
                        return "redirect:/";
                 }


                 @GetMapping(value = "/del/{id}")
                 public String del(@PathVariable("id") Long id, Model model){
                    if(id !=null){

                    this.repo.deleteById(id);
//                        model.addAttribute("delMsg","Delete A Student Succesfully");
                    }
                    return "redirect:/";
            }

}
