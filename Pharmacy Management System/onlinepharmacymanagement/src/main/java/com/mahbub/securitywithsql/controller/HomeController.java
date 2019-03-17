package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.repo.RoleRepo;
import com.mahbub.securitywithsql.repo.SalesRepo;
import com.mahbub.securitywithsql.repo.SummaryRepo;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private SummaryRepo summaryRepo;

    @Autowired
    private SalesRepo salesRepo;


    @GetMapping(value = "/")
    public String dashboardView(Model model) {
        return "dashboard";

    }


    @GetMapping(value = "/con")
    public String contactView() {
        return "secure/contact-us";

    }


    @GetMapping(value = "/order")
    public String orderView() {
        return "secure/order";

    }


    @GetMapping(value = "/location")
    public String locationView() {
        return "secure/location";

    }

    @GetMapping(value = "/summary")
    public String summaryView(Model model) {
        model.addAttribute("summarylist", this.summaryRepo.findAll());
        return "summary/summary";

    }


}
