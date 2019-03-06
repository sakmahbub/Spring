package com.mahbub.securitywithsql.controller;




import com.mahbub.securitywithsql.entity.Drug;
import com.mahbub.securitywithsql.entity.User;
import com.mahbub.securitywithsql.repo.BrandRepo;
import com.mahbub.securitywithsql.repo.CategoryRepo;
import com.mahbub.securitywithsql.repo.DrugRepo;

import com.mahbub.securitywithsql.repo.DrugtypeRepo;
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
@RequestMapping(value = "/drug")
public class DrugController {

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private DrugtypeRepo drugtypeRepo;




    @GetMapping(value = "/adddrug")
    public String addShow(Drug drug, Model model) {
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());
        return "drugs/add-drug";

    }

    @PostMapping(value = "/adddrug")
    public String drugSave(@Valid Drug drug, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brandlist", this.brandRepo.findAll());
            model.addAttribute("categorylist", this.categoryRepo.findAll());
            model.addAttribute("typelist", this.drugtypeRepo.findAll());
            return "drugs/add-drug";
        }
             this.drugRepo.save(drug);
                    model.addAttribute("drug", new Drug());
                    model.addAttribute("success", "Congratulations! Data save sucessfully");
                    model.addAttribute("brandlist", this.brandRepo.findAll());
                    model.addAttribute("categorylist", this.categoryRepo.findAll());
                     model.addAttribute("typelist", this.drugtypeRepo.findAll());

        return "drugs/add-drug";
    }



    @GetMapping(value = "/listdrug")
    public String drugIndex(Model model) {
        model.addAttribute("druglist", this.drugRepo.findAll());
        return "drugs/list-drug";
    }



    @GetMapping(value = "/editdrug/{id}")
    public String editShow(Model model, @PathVariable("id") Long id){
        model.addAttribute("drug", this.drugRepo.getOne(id));
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());
        return "drugs/edit-drug";

    }


    @PostMapping(value = "/editdrug/{id}")
    public String drugEdit(@Valid Drug drug, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("brandlist", this.brandRepo.findAll());
            model.addAttribute("categorylist", this.categoryRepo.findAll());
            model.addAttribute("typelist", this.drugtypeRepo.findAll());
            return "drugs/edit-drug";
        }
        drug.setDrugId(id);
        this.drugRepo.save(drug);
        model.addAttribute("drug", new Drug());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("brandlist", this.brandRepo.findAll());
        model.addAttribute("categorylist", this.categoryRepo.findAll());
        model.addAttribute("typelist", this.drugtypeRepo.findAll());

        return "drugs/edit-drug";
    }




    @GetMapping(value = "/deldrug/{id}")
    public String drugdel(@PathVariable("id") Long id) {
        if(id != null){
            this.drugRepo.deleteById(id);

        }
        return "redirect:/drug/listdrug";

    }









//    @GetMapping(value = "/user-save")
//    public String saveUser(){
//        Set<Role> roles=new HashSet<>();
//
//        roles.add(new Role(1L));
//        roles.add(new Role(2L));
//        roles.add(new Role(3L));
//        User user=new User("Mahbub","sakmahbub@gmail.com","sakmahbub", passwordEncoder.encode("1234567"), roles);
//        userRepo.save(user);
//
//
//
//        Set<Role> roles1=new HashSet<>();
//        roles1.add(new Role(1L));
//        User user1=new User("Mortoza","mortoza@gmail.com","mortoza001", passwordEncoder.encode("1234567"), roles1);
//        userRepo.save(user1);
//
//        Set<Role> roles2=new HashSet<>();
//        roles2.add(new Role(2L));
//        User user2=new User("Mostafiz","mostafiz@gmail.com","mostafiz001", passwordEncoder.encode("1234567"), roles2);
//        userRepo.save(user2);
//
//
//        Set<Role> roles3=new HashSet<>();
//        roles3.add(new Role(3L));
//        User user3=new User("Safiq","safiq@gmail.com","safiq001", passwordEncoder.encode("1234567"), roles3);
//        userRepo.save(user3);
//        return "sucess";
//    }
}
