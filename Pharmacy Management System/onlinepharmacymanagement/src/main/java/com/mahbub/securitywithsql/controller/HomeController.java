package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.repo.SalesRepo;
import com.mahbub.securitywithsql.repo.SummaryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class HomeController {

    @Autowired
    private SummaryRepo summaryRepo;
    @Autowired
    private SalesRepo salesRepo;

    @GetMapping(value = "/")
    public String dashboardView(Model model) {
        double taka[]=new double[salesRepo.findAll().size()];
        for(int i=0; i < salesRepo.findAll().size(); i++){
            taka[i]=salesRepo.findAll().get(i).getTotalPrice();
        }
        model.addAttribute("monthlyRevnue",taka);
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
