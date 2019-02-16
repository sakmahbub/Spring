package com.mahbub.loginlogout.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests().antMatchers("/", "/login", "/public/**").permitAll()
                .antMatchers( "/admin/**").hasRole("ADMIN")
                .antMatchers( "/user/**").hasRole("USER")
                .antMatchers( "/service/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                .loginPage("/login")
//                .defaultSuccessUrl("/public/r")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

@Bean
@Override
    public UserDetailsService userDetailsService(){

        UserDetails user= User.withDefaultPasswordEncoder()
                .username("Admin")
                .password("123")
                .roles("ADMIN", "USER").build();


        return new InMemoryUserDetailsManager(user);
    }
}
