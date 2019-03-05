package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Brand;
import com.mahbub.securitywithsql.entity.Category;
import com.mahbub.securitywithsql.repo.BrandRepo;
import com.mahbub.securitywithsql.repo.CategoryRepo;
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
@RequestMapping(value = "/cat/")
public class CategoryController {

    @Autowired
    private CategoryRepo categoryRepo;


    @GetMapping(value = "addcat")
    public String addShow(Category category) {
        return "category/add-cat";

    }


    @PostMapping(value = "addcat")
    public String categorySave(@Valid Category category, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "category/add-cat";
        } else {
            if (category != null) {
                Category category1 = this.categoryRepo.findByCategoryName(category.getCategoryName());
                if (category1 != null) {
                    model.addAttribute("exist", "Category allready exist");

                } else {
//                    category.setCategoryName(category.getCategoryName().toUpperCase());
                    this.categoryRepo.save(category);
                    model.addAttribute("category", new Category());
                    model.addAttribute("success", "Category Add Successfully");
                }

            }
        }


        return "category/add-cat";
    }


    @GetMapping(value = "listcat")
    public String categoryIndex(Model model) {
        model.addAttribute("catlist", categoryRepo.findAll());
        return "category/list-cat";
    }



    @GetMapping(value = "editcat/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("category", this.categoryRepo.getOne(id));
        return "category/edit-cat";

    }


    @PostMapping(value = "editcat/{id}")
    public String categoryEdit(@Valid Category category, BindingResult bindingResult,@PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "category/edit-cat";
        } else {
            if (category != null) {
                Category category1 = this.categoryRepo.findByCategoryName(category.getCategoryName());
                if (category1 != null) {
                    model.addAttribute("exist", "Category allready exist");

                } else {
//                    category.setCategoryName(category.getCategoryName().toUpperCase());
                    this.categoryRepo.save(category);
                    model.addAttribute("category", new Category());
                    model.addAttribute("success", "Category Add Successfully");
                }

            }
        }


        return "category/edit-cat";
    }



    @GetMapping(value = "delcat/{id}")
    public String barnddel(@PathVariable("id") Long id) {
        if(id != null){
            this.categoryRepo.deleteById(id);

        }
        return "redirect:/cat/listcat";

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
