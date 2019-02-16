package com.mahbub.classworkmvccourd.contrlller;


import com.mahbub.classworkmvccourd.entity.Role;
import com.mahbub.classworkmvccourd.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;



    @GetMapping(value = "/rolelist")
    public String roleIndex(Model model) {
        model.addAttribute("roleList", this.roleRepo.findAll());
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
                Role role1 = this.roleRepo.findByRoleName(role.getRoleName());
                if (role1 != null) {
                    model.addAttribute("exist", "Role All ready exist");

                } else {
                    this.roleRepo.save(role);
                    model.addAttribute("role", new Role());
                    model.addAttribute("success", "Role Add Successfully");
                }

            }

        }

        return "role-add";
    }
}
