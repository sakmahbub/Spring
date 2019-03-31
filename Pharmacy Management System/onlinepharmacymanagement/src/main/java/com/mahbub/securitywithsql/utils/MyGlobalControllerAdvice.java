package com.mahbub.securitywithsql.utils;


import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class MyGlobalControllerAdvice {

    @Autowired
    private UserRepo userRepo;


    @ModelAttribute("dynamicuser")
    public User getUserDetalis(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        User dynamicuser=this.userRepo.findByUserName(auth.getName());
        return dynamicuser;
    }


}
