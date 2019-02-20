package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.entity.Role;
import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.RoleRepo;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @GetMapping(value = "/adduser")
    public String addShow(User user, Model model) {
        model.addAttribute("rolelistAdd", this.roleRepo.findAll());
        return "user/add-user";

    }

    @PostMapping(value = "/adduser")
    public String userSave(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("rolelistAdd", this.roleRepo.findAll());
            return "user/add-user";
        } else {
            if (user != null) {

                User user1=this.userRepo.findByUserName(user.getUserName());
                if (user1 != null) {
                    model.addAttribute("exist", "UserName allready exist");

                } else {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    this.userRepo.save(user);
                    model.addAttribute("user", new User());
                    model.addAttribute("success", "Congratulations! Data save sucessfully");
                }

            }
        }
        model.addAttribute("rolelistAdd", this.roleRepo.findAll());

        return "user/add-user";
    }



    @GetMapping(value = "/listuser")
    public String userIndex(Model model) {
        model.addAttribute("userlist", userRepo.findAll());
        return "user/list-user";
    }



    @GetMapping(value = "/edituser/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", this.userRepo.getOne(id));
        model.addAttribute("rolelistAdd", this.roleRepo.findAll());
        return "user/edit-user";

    }


    @PostMapping(value = "/edituser/{id}")
    public String userEdit(@Valid User user, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("rolelistAdd", this.roleRepo.findAll());
            return "user/edit-user";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepo.save(user);
        model.addAttribute("user", new User());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("rolelistAdd", this.roleRepo.findAll());

        return "user/edit-user";
    }




    @GetMapping(value = "/deluser/{id}")
    public String roledel(@PathVariable("id") Long id) {
        if(id != null){
            this.userRepo.deleteById(id);

        }
        return "redirect:/user/listuser";

    }



//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//        Set<Role> roles=new HashSet<>();
//
//        roles.add(new Role(1L));
//        roles.add(new Role(2L));
//        roles.add(new Role(3L));
//        User user=new User("Mahbub","sakmahbub@gmail.com","sakmahbub", passwordEncoder.encode("1234567"), roles);
//        userRepo.save(user);
//
//
//
//        Set<Role> roles1=new HashSet<>();
//        roles1.add(new Role(1L));
//        User user1=new User("Mortoza","mortoza@gmail.com","mortoza001", passwordEncoder.encode("1234567"), roles1);
//        userRepo.save(user1);
//
//        Set<Role> roles2=new HashSet<>();
//        roles2.add(new Role(2L));
//        User user2=new User("Mostafiz","mostafiz@gmail.com","mostafiz001", passwordEncoder.encode("1234567"), roles2);
//        userRepo.save(user2);
//
//
//        Set<Role> roles3=new HashSet<>();
//        roles3.add(new Role(3L));
//        User user3=new User("Safiq","safiq@gmail.com","safiq001", passwordEncoder.encode("1234567"), roles3);
//        userRepo.save(user3);
//        return "sucess";
//    }
}
