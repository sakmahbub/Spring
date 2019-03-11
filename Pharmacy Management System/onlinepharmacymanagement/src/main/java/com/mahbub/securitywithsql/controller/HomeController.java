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

    @GetMapping(value = "/con")
    public String contactView(){
        return "secure/contact-us";

    }

    @GetMapping(value = "/succes")
    public String successView(){
        return "sucess";

    }

    @GetMapping(value = "/das")
    public String dashboardView(Model model){
        return "dashboard";

    }




}
