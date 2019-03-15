package com.sofiqul54.controller;

import com.sofiqul54.entity.Groupleader;
import com.sofiqul54.entity.User;
import com.sofiqul54.repo.GroupleaderRepo;
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
@RequestMapping(value = "/groupleader/")
public class GroupleaderController {
    @Autowired
    private ImageOptimizer imageOptimizer;

    @Autowired
    private GroupleaderRepo repo;



    @GetMapping(value = "add")
    public String viewAdd(Model model) {
        model.addAttribute("groupleader", new Groupleader());
        return "groupleaders/add";
    }

    @PostMapping(value = "add")
    public String userSave(@Valid Groupleader groupleader, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "groupleaders/add";
        } else {
            if (groupleader.getEmail() != null) {

                if (repo.existsByEmail(groupleader.getEmail())) {
                    model.addAttribute("rejectMsg", "UserName allready exist");
                } else {
                    groupleader.setRegiDate(new Date());
                    this.repo.save(groupleader);
                    model.addAttribute("groupleader", new Groupleader());
                    model.addAttribute("successMsg", "Congratulations! Data save sucessfully");
                }
            }
        }
        return "groupleaders/add";
    }


    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("groupleaders", repo.getOne(id));
        return "groupleaders/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Groupleader groupleader, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "groupleaders/edit";
        }
        Optional<Groupleader> rol = this.repo.findByLeaderName(groupleader.getEmail());
        if (rol.get().getId() != id) {
            model.addAttribute("rejectMsg", "Already Have This Entry");
            return "groupleaders/edit";
        } else {
            groupleader.setRegiDate(new Date());
            groupleader.setId(id);
            this.repo.save(groupleader);
        }
        return "redirect:/groupleader/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/groupleader/list";
    }

    @GetMapping(value = "list")
    public String list(Model model) {
        model.addAttribute("list", this.repo.findAll());
        return "groupleader/list";
    }
}