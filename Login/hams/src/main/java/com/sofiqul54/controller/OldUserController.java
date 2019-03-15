package com.sofiqul54.controller;

import com.sofiqul54.entity.Role;
import com.sofiqul54.entity.User;
import com.sofiqul54.repo.RoleRepo;
import com.sofiqul54.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
public class OldUserController {
    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

@Autowired
private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user-save")
    public String saveUser() {

        Set<Role> roles=new HashSet<>();
        roles.add(new Role("SUPERADMIN"));
        roles.add(new Role("ADMIN"));
      roles.forEach((role -> {
          roleRepo.save(role);
      }));

        roles.add(new Role(1L));
        roles.add(new Role(2L));
        User user = new User("Sofiqul", "Islam", "saadmin", "sadmin@hams.com", new Date(), true, UUID.randomUUID().toString(),roles);
        user.setPassword(passwordEncoder.encode("123456789"));
        repo.save(user);
      return "success";
    }

    @GetMapping(value = "/register")
    public ModelAndView displayRegister(User user){
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("signup");
        return mv;
    }
}
