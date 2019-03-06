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


    @GetMapping(value = "addrole")
    public String addShow(Role role) {
        return "role/add-role";

    }


    @PostMapping(value = "addrole")
    public String roleSave(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/add-role";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRolename(role.getRolename());
                if (role1 != null) {
                    model.addAttribute("exist", "Role allready exist");

                } else {
                    role.setRolename(role.getRolename().toUpperCase());
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("success", "Role Add Successfully");
                }

            }
        }


        return "role/add-rolee";
    }


    @GetMapping(value = "listrole")
    public String roleIndex(Model model) {
        model.addAttribute("rolelist", roleRepo.findAll());
        return "role/list-role";
    }



    @GetMapping(value = "editrole/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("role", this.roleRepo.getOne(id));
        return "role/edit-role";

    }


    @PostMapping(value = "editrole/{id}")
    public String roleEdit(@Valid Role role, BindingResult bindingResult,@PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "role/edit-role";
        } else {
            if (role != null) {
                Role role1 = this.roleRepo.findByRolename(role.getRolename());
                if (role1 != null) {
                    model.addAttribute("exist", "Role allready exist");

                } else {
                    role.setRolename(role.getRolename().toUpperCase());

                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("success", "Role Add Successfully");
                }

            }
        }


        return "role/edit-role";
    }



    @GetMapping(value = "delrole/{id}")
    public String roledel(@PathVariable("id") Long id) {
        if(id != null){
            this.roleRepo.deleteById(id);

        }
        return "redirect:/role/listrole";

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
