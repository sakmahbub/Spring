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


    @GetMapping(value = "addbrand")
    public String addShow(Brand brand) {
        return "brand/add-brand";

    }


    @PostMapping(value = "addbrand")
    public String brandSave(@Valid Brand brand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "brand/add-brand";
        } else {
            if (brand != null) {
                Brand brand1 = this.brandRepo.findByBrandName(brand.getBrandName());
                if (brand1 != null) {
                    model.addAttribute("exist", "Brand allready exist");

                } else {
                    brand.setBrandName(brand.getBrandName().toUpperCase());
                    this.brandRepo.save(brand);
                    model.addAttribute("brand", new Brand());
                    model.addAttribute("success", "Brand Add Successfully");
                }

            }
        }


        return "brand/add-brand";
    }


    @GetMapping(value = "listbrand")
    public String brandIndex(Model model) {
        model.addAttribute("brandlist", brandRepo.findAll());
        return "brand/list-brand";
    }



    @GetMapping(value = "editbrand/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("brand", this.brandRepo.getOne(id));
        return "brand/edit-brand";

    }


    @PostMapping(value = "editbrand/{id}")
    public String brandEdit(@Valid Brand brand, BindingResult bindingResult,@PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "brand/edit-brand";
        } else {
            if (brand != null) {
                Brand role1 = this.brandRepo.findByBrandName(brand.getBrandName());
                if (role1 != null) {
                    model.addAttribute("exist", "Brand allready exist");

                } else {
                    brand.setBrandName(brand.getBrandName().toUpperCase());
                    this.brandRepo.save(brand);
                    model.addAttribute("brand", new Brand());
                    model.addAttribute("success", "Brand Add Successfully");
                }

            }
        }


        return "brand/edit-brand";
    }



    @GetMapping(value = "delbrand/{id}")
    public String barnddel(@PathVariable("id") Long id) {
        if(id != null){
            this.brandRepo.deleteById(id);

        }
        return "redirect:/brand/listbrand";

    }


//    @GetMapping(value = "/role-save")
//    public void saveRole(){
//        Role role=new Role();
//        role.setRolename("SUPERADMIN");
//        roleRepo.save(role);
//
//        Role role1=new Role();
//        role1.setRolename("ADMIN");
//        roleRepo.save(role1);
//
//        Role role2=new Role();
//        role2.setRolename("USER");
//        roleRepo.save(role2);
//        System.out.println("Role Successfully Saved");
//    }

}
