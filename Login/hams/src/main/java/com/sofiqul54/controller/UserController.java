package com.sofiqul54.controller;

import com.sofiqul54.entity.Role;
import com.sofiqul54.entity.User;
import com.sofiqul54.repo.RoleRepo;
import com.sofiqul54.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private UserRepo repo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "add")
    public String viewAdd(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/add";
    }

    @PostMapping(value = "add")
    public String userSave(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "users/add";
        } else {
            if (user.getEmail() != null) {

                if (repo.existsByEmail(user.getEmail())) {
                    model.addAttribute("rejectMsg", "UserName allready exist");
                } else {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    user.setRegiDate(new Date());
                    user.setEnabled(true);
                    user.setConfirmationToken(UUID.randomUUID().toString());
                    this.repo.save(user);
                    model.addAttribute("user", new User());
                    model.addAttribute("successMsg", "Congratulations! Data save sucessfully");
                }
            }
        }
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", repo.getOne(id));
        model.addAttribute("rolelist", this.roleRepo.findAll());
        return "users/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid User user, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "users/edit";
        }
        Optional<User> rol = this.repo.findByEmail(user.getEmail());
        if (rol.get().getId() != id) {
            model.addAttribute("rejectMsg", "Already Have This Entry");
            return "users/edit";
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRegiDate(new Date());
            user.setEnabled(true);
            user.setConfirmationToken(UUID.randomUUID().toString());
            user.setId(id);
            this.repo.save(user);
            model.addAttribute("rolelist", this.roleRepo.findAll());
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/user/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "users/list";
    }
}