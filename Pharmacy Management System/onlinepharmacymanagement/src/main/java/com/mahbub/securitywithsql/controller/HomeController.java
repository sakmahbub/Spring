package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.repo.SummaryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private SummaryRepo summaryRepo;


    @GetMapping(value = "/")
    public String dashboardView(Model model) {
        return "dashboard";

    }



    @GetMapping(value = "/order")
    public String orderView() {
        return "contact/order";

    }


    @GetMapping(value = "/location")
    public String locationView() {
        return "contact/location";

    }

    @GetMapping(value = "/summary")
    public String summaryView(Model model) {
        model.addAttribute("summarylist", this.summaryRepo.findAll());
        return "summary/summary";

    }


}
