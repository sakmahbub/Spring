package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Role;
import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.RoleRepo;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping(value = "/sa")
    public String superAdminView(){
        return "sadmin/sad";

    }


    @GetMapping(value = "/adm")
    public String adminView(){
        return "admin/admin";

    }

    @GetMapping(value = "/u")
    public String userView(){
        return "user/u";

    }


    @GetMapping(value = "/se")
    public String secureView(Model model){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username",auth.getName());
        User user=repo.findByUserName(auth.getName());
        model.addAttribute("name", user.getName());
        return "secure/sec";

    }




}
