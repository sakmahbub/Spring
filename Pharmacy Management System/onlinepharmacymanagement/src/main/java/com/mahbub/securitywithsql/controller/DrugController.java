package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Drug;
import com.mahbub.securitywithsql.entity.Summary;
import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping(value = "/drug")
public class DrugController {

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private DrugtypeRepo drugtypeRepo;

    @Autowired
    private SummaryRepo summaryRepo;


    @GetMapping(value = "/add")
    public String addShow(Drug drug, Model model) {
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());
        return "drugs/add";

    }

    @PostMapping(value = "/add")
    public String drugSave(@Valid Drug drug, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brandlist", this.brandRepo.findAll());
            model.addAttribute("categorylist", this.categoryRepo.findAll());
            model.addAttribute("typelist", this.drugtypeRepo.findAll());
            return "drugs/add";
        }
        String drugCode = drug.getCategories().getCategoryName().substring(0, 3) + "-" + drug.getDrugName().substring(0, 3) + "-" + UUID.randomUUID().toString();
        drug.setDrugCode(drugCode);
        this.drugRepo.save(drug);
        model.addAttribute("drug", new Drug());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());


        return "drugs/add";
    }


    @GetMapping(value = "/list")
    public String drugIndex(Model model) {
        model.addAttribute("druglist", this.drugRepo.findAll());
        return "drugs/list";
    }


    @GetMapping(value = "/edit/{id}")
    public String editShow(Model model, @PathVariable("id") Long id) {
        model.addAttribute("drug", this.drugRepo.getOne(id));
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());
        return "drugs/edit";

    }


    @PostMapping(value = "/edit/{id}")
    public String drugEdit(@Valid Drug drug, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brandlist", this.brandRepo.findAll());
            model.addAttribute("categorylist", this.categoryRepo.findAll());
            model.addAttribute("typelist", this.drugtypeRepo.findAll());
            return "drugs/edit";
        }
        drug.setId(id);
        this.drugRepo.save(drug);
        model.addAttribute("drug", new Drug());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());

        return "drugs/edit";
    }


    @GetMapping(value = "/del/{id}")
    public String drugdel(@PathVariable("id") Long id) {
        if (id != null) {
            this.drugRepo.deleteById(id);

        }
        return "redirect:/drug/list";

    }


}
