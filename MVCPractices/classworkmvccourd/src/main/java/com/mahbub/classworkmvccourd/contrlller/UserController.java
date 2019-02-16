package com.mahbub.classworkmvccourd.contrlller;


import com.mahbub.classworkmvccourd.entity.User;
import com.mahbub.classworkmvccourd.repo.RoleRepo;
import com.mahbub.classworkmvccourd.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("userlist", this.userRepo.findAll());
        return "index";

    }


    @GetMapping("/add")
    public String showForm(User user, Model model) {
        model.addAttribute("roleListHome", this.roleRepo.findAll());
        return "uadd";
    }

    @PostMapping("/add")
    public String doSave(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
           return "uadd";

        }
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("successMsg", "Congratulations! You are old enough to sign up for this site.");
        return "redirect:/";
    }

}
