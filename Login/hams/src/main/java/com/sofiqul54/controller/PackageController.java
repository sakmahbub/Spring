package com.sofiqul54.controller;

import com.sofiqul54.entity.Ppackage;
import com.sofiqul54.repo.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "/package/")
public class PackageController {

    @Autowired
    private PackageRepo repo;

    @GetMapping(value = "add")
    public String viewAdd(Model model) {
        model.addAttribute("package", new Ppackage());
        return "packages/add";
    }

    @PostMapping(value = "add")
    public String add(@Valid Ppackage ppackage, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "packages/add";
        }
        if (repo.existsByName(ppackage.getName())) {
            model.addAttribute("rejectMsg", "Already Have This Entry");
        } else {
            ppackage.setName(ppackage.getName().toUpperCase());
            ppackage.setPrice(ppackage.getPrice());
            this.repo.save(ppackage);
            model.addAttribute("successMsg", "Successfully Saved!");
        }
        return "redirect:/package/add";
    }

    @GetMapping(value = "edit/{id}")
    public String viewEdit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("package", repo.getOne(id));
        return "packages/edit";
    }

    @PostMapping(value = "edit/{id}")
    public String edit(@Valid Ppackage ppackage, BindingResult bindingResult, Model model, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "packages/edit";
        }
        Optional<Ppackage> pac = this.repo.findByName(ppackage.getName());
        if (pac.get().getId() != id) {
            model.addAttribute("rejectMsg", "Already Have This Entry");
            return "packages/edit";
        } else {
            ppackage.setId(id);
            ppackage.setName(ppackage.getName().toUpperCase());
            this.repo.save(ppackage);
        }
        return "redirect:/package/list";
    }

    @GetMapping(value = "del/{id}")
    public String del(@PathVariable("id") Long id) {
        if (id != null) {
            this.repo.deleteById(id);
        }
        return "redirect:/package/list";
    }

    @GetMapping(value = "list")
    public String list(Model model){
        model.addAttribute("list", this.repo.findAll());
        return "packages/list";
    }
}
