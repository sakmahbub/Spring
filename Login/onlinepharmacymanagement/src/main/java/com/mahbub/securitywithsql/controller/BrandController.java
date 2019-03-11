package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Brand;

import com.mahbub.securitywithsql.repo.BrandRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/brand/")
public class BrandController {

    @Autowired
    private BrandRepo brandRepo;


    @GetMapping(value = "add")
    public String addShow(Brand brand) {
        return "brand/add";

    }


    @PostMapping(value = "add")
    public String brandSave(@Valid Brand brand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "brand/add";
        } else {
            if (brand != null) {
                Brand brand1 = this.brandRepo.findByBrandName(brand.getBrandName());
                if (brand1 != null) {
                    model.addAttribute("exist", "Brand allready exist");

                } else {

                    this.brandRepo.save(brand);
                    model.addAttribute("brand", new Brand());
                    model.addAttribute("success", "Brand Add Successfully");
                }

            }
        }


        return "brand/add";
    }


    @GetMapping(value = "list")
    public String brandIndex(Model model) {
        model.addAttribute("brandlist", brandRepo.findAll());
        return "brand/list";
    }



    @GetMapping(value = "edit/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("brand", this.brandRepo.getOne(id));
        return "brand/edit";

    }


    @PostMapping(value = "edit/{id}")
    public String brandEdit(@Valid Brand brand, BindingResult bindingResult,@PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "brand/edit";
                 }
                    brand.setBrandId(id);
                    this.brandRepo.save(brand);
                    model.addAttribute("brand", new Brand());
                    model.addAttribute("success", "Brand Edit Successfully");


        return "redirect:/brand/list";
    }



    @GetMapping(value = "del/{id}")
    public String barnddel(@PathVariable("id") Long id) {
        if(id != null){
            this.brandRepo.deleteById(id);

        }
        return "redirect:/brand/list";

    }



}
