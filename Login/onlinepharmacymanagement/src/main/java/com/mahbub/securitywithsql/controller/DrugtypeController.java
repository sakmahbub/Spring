package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.entity.Drugtype;

import com.mahbub.securitywithsql.repo.DrugtypeRepo;
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
@RequestMapping(value = "/type/")
public class DrugtypeController {

    @Autowired
    private DrugtypeRepo drugtypeRepo;


    @GetMapping(value = "add")
    public String addShow(Model model) {
        model.addAttribute("type",new Drugtype());

        return "drugtype/add";

    }


    @PostMapping(value = "add")
    public String DrugtypeSave(@Valid Drugtype drugtype, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "drugtype/add";
        } else {
            if (drugtype != null) {
                Drugtype drugtype1 = this.drugtypeRepo.findByTypeName(drugtype.getTypeName());
                if (drugtype1 != null) {
                    model.addAttribute("exist", "Drugtype allready exist");

                } else {

                    this.drugtypeRepo.save(drugtype);
                    model.addAttribute("type", new Drugtype());
                    model.addAttribute("success", "Drugtype Add Successfully");
                }

            }
        }


        return "drugtype/add";
    }


    @GetMapping(value = "list")
    public String DrugtypeIndex(Model model) {
        model.addAttribute("typelist", drugtypeRepo.findAll());
        return "drugtype/list";
    }



    @GetMapping(value = "edit/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("type", this.drugtypeRepo.getOne(id));

        return "drugtype/edit";

    }


    @PostMapping(value = "edit/{id}")
    public String DrugtypeEdit(@Valid Drugtype drugtype, BindingResult bindingResult,@PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "drugtype/edit";
        } else {
            if (drugtype != null) {
                Drugtype drugtype1 = this.drugtypeRepo.findByTypeName(drugtype.getTypeName());
                if (drugtype1 != null) {
                    model.addAttribute("exist", "Drugtype allready exist");
                    model.addAttribute("type",new Drugtype());
                } else {
                    drugtype.setTypeId(id);
                    this.drugtypeRepo.save(drugtype);
                    model.addAttribute("type", new Drugtype());
                    model.addAttribute("success", "Drugtype Add Successfully");
                }

            }
        }


        return "drugtype/edit";
    }



    @GetMapping(value = "del/{id}")
    public String barnddel(@PathVariable("id") Long id) {
        if(id != null){
            this.drugtypeRepo.deleteById(id);

        }
        return "redirect:/type/listtype";

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
