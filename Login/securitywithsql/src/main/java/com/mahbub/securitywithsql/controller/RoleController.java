package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Role;
import com.mahbub.securitywithsql.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;


    @GetMapping(value = "/role-save")
    public void saveRole(){
        Role role=new Role();
        role.setRolename("SUPERADMIN");
        roleRepo.save(role);

        Role role1=new Role();
        role1.setRolename("ADMIN");
        roleRepo.save(role1);

        Role role2=new Role();
        role2.setRolename("USER");
        roleRepo.save(role2);
        System.out.println("Role Successfully Saved");
    }

}
