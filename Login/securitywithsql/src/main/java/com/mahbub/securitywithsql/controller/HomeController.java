package com.mahbub.securitywithsql.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping(value = "/sa")
    public String superAdmin(){
        return "sadmin/sad";

    }


    @GetMapping(value = "/adm")
    public String admin(){
        return "admin/admin";

    }

    @GetMapping(value = "/u")
    public String user(){
        return "user/u";

    }


    @GetMapping(value = "/se")
    public String secure(){
        return "secure/sec";

    }
}
