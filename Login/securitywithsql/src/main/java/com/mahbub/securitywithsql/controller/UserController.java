package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.entity.Role;
import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/user-save")
    public String saveUser(){
        Set<Role> roles=new HashSet<>();
        roles.add(new Role(1L));
        roles.add(new Role(2L));
        roles.add(new Role(3L));
        User user=new User("Mahbub","sakmahbub@gmail.com","sakmahbub", passwordEncoder.encode("1234567"), roles);
        userRepo.save(user);



        Set<Role> roles1=new HashSet<>();
        roles1.add(new Role(1L));
        User user1=new User("Mortoza","mortoza@gmail.com","mortoza001", passwordEncoder.encode("1234567"), roles1);
        userRepo.save(user1);

        Set<Role> roles2=new HashSet<>();
        roles2.add(new Role(2L));
        User user2=new User("Mostafiz","mostafiz@gmail.com","mostafiz001", passwordEncoder.encode("1234567"), roles2);
        userRepo.save(user2);


        Set<Role> roles3=new HashSet<>();
        roles3.add(new Role(3L));
        User user3=new User("Safiq","safiq@gmail.com","safiq001", passwordEncoder.encode("1234567"), roles3);
        userRepo.save(user3);
        return "sucess";
    }
}
