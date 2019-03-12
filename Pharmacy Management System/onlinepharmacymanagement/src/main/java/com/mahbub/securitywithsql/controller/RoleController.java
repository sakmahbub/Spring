package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Role;
import com.mahbub.securitywithsql.repo.RoleRepo;
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
@RequestMapping(value = "/role/")
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;


    @GetMapping(value = "add")
    public String addShow(Role role) {
        return "role/add";

    }


    @PostMapping(value = "add")
    public String roleSave(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/add";
        }
        if (roleRepo.existsRoleByRolename(role.getRolename())) {

            model.addAttribute("exist", "Role allready exist");

        } else {
            role.setRolename(role.getRolename().toUpperCase());
            this.roleRepo.save(role);
            model.addAttribute("role", new Role());
            model.addAttribute("success", "Role Add Successfully");
        }


        return "role/add";
    }


    @GetMapping(value = "list")
    public String roleIndex(Model model) {
        model.addAttribute("rolelist", roleRepo.findAll());
        return "role/list";
    }


    @GetMapping(value = "edit/{id}")
    public String editShow(Model model, @PathVariable("id") Long id) {
        model.addAttribute("role", this.roleRepo.getOne(id));
        return "role/edit";

    }


    @PostMapping(value = "edit/{id}")
    public String roleEdit(@Valid Role role, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/edit";
        }
        if (roleRepo.existsRoleByRolename(role.getRolename())) {

            model.addAttribute("exist", "Role allready exist");

        } else {
            role.setRolename(role.getRolename().toUpperCase());
            role.setId(id);
            this.roleRepo.save(role);
            model.addAttribute("role", new Role());
            model.addAttribute("success", "Role Add Successfully");
        }


        return "role/edit";
    }


    @GetMapping(value = "del/{id}")
    public String roledel(@PathVariable("id") Long id) {
        if (id != null) {
            this.roleRepo.deleteById(id);

        }
        return "redirect:/role/list";

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
