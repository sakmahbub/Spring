package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Role;
import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.RoleRepo;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Controller
public class CustomAddRoleAndUserCon {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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



    @GetMapping(value = "/user-save")
    public String saveUser(){
        Set<Role> roles=new HashSet<>();

        roles.add(new Role(1L));
        roles.add(new Role(2L));
        roles.add(new Role(3L));
        User user=new User("Mahbub","sakmahbub@gmail.com","sakmahbub", passwordEncoder.encode("1234"), new Date(), true, UUID.randomUUID().toString(), roles);
//        user.setConfirmationToken(UUID.randomUUID().toString());
//        user.setEnabled(true);
        userRepo.save(user);



        Set<Role> roles1=new HashSet<>();
        roles1.add(new Role(1L));
        User user1=new User("Mortoza","mortoza@gmail.com","mortoza001", passwordEncoder.encode("1234"), new Date(), true, UUID.randomUUID().toString(), roles1);
//        user1.setConfirmationToken(UUID.randomUUID().toString());
//        user1.setEnabled(true);
        userRepo.save(user1);

        Set<Role> roles2=new HashSet<>();
        roles2.add(new Role(2L));
        User user2=new User("Mostafiz","mostafiz@gmail.com","mostafiz001", passwordEncoder.encode("1234"), new Date(), true, UUID.randomUUID().toString(), roles2);
//        user2.setConfirmationToken(UUID.randomUUID().toString());
//        user2.setEnabled(true);
        userRepo.save(user2);


        Set<Role> roles3=new HashSet<>();
        roles3.add(new Role(3L));
        User user3=new User("Safiq","safiq@gmail.com","safiq001", passwordEncoder.encode("1234"), new Date(), true, UUID.randomUUID().toString(), roles3);
//        user3.setConfirmationToken(UUID.randomUUID().toString());
//        user3.setEnabled(true);
        userRepo.save(user3);
        return "sucess";
    }


}
