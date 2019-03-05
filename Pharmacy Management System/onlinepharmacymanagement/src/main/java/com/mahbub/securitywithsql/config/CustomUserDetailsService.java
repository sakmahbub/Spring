package com.mahbub.securitywithsql.config;


import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
   UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<User> optionalUsers=userRepo.findByUserNameOrEmail(usernameOrEmail, usernameOrEmail);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
        return optionalUsers.map(CoustomUserDetails::new).get();
    }
}
