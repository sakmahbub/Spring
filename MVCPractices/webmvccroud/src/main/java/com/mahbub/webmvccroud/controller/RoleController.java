package com.mahbub.webmvccroud.controller;


import com.mahbub.webmvccroud.entity.Role;
import com.mahbub.webmvccroud.repository.RoleRipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRipo roleRipo;

    @GetMapping(value = "/rolelist")
    public String roleIndex(Model model) {
        model.addAttribute("roleList", this.roleRipo.findAll());
        return "role-list";

    }

    @GetMapping(value = "/addrole")
    public String add(Role role) {
        return "role-add";


    }

    @PostMapping(value = "/addrole")
    public String roleSave(@Valid Role role, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role-add";

        } else {
            if (role != null) {
                Role role1 = this.roleRipo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("exist", "Role All ready exist");

                } else {
                    this.roleRipo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("success", "Role Add Successfully");
                }

            }

        }

        return "role-add";
    }


    @GetMapping(value = "/editrole/{id}")
public String showRoleEdit(Model model, @PathVariable("id") Long id){
        model.addAttribute("role", this.roleRipo.getOne(id));
        return "role-edit";

}



    @PostMapping(value ="/editrole/{id}")
    public String roleEdit(@Valid Role role, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            return "role-edit";

        } else {
            if (role != null) {
                Role role1 = this.roleRipo.findByRoleName(role.getRoleName());
                if (role1 != null) {

                    model.addAttribute("exist", "Role All ready exist");

                } else {
                    this.roleRipo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("success", "Role Update Successfully");
                }

            }

        }

        return "role-edit";
    }


    @GetMapping(value = "/roledel/{id}")
    public String roledel(@PathVariable("id") Long id) {
       if(id != null){
           this.roleRipo.deleteById(id);

       }
        return "redirect:/rolelist";

    }
}
