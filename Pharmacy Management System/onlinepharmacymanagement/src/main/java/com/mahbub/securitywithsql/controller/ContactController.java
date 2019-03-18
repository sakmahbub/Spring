package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Contact;
import com.mahbub.securitywithsql.repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "/con/")
public class ContactController {

    @Autowired
    private ContactRepo contactRepo;


    @GetMapping(value = "/add")
    public String contactView(Contact contact) {
        return "contact/contact-us";

    }


    @PostMapping(value = "add")
    public String contactSave(@Valid Contact contact, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "contact/contact-us";
        }
        this.contactRepo.save(contact);
        model.addAttribute("contact", new Contact());
        model.addAttribute("success", "Message Send Successfully");

        return "contact/contact-us";

        }


    @GetMapping(value = "list")
    public String brandIndex(Model model) {
        model.addAttribute("contactlist", contactRepo.findAll());
        return "contact/contact-list";
    }


    @GetMapping(value = "del/{id}")
    public String msgdel(@PathVariable("id") Long id) {
        if(id != null){
            this.contactRepo.deleteById(id);

        }
        return "redirect:/con/list";

    }


}
