package com.mahbub.securitywithsql.controller;



import com.mahbub.securitywithsql.entity.DrugPurchase;
import com.mahbub.securitywithsql.entity.Summary;
import com.mahbub.securitywithsql.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "/pur")
public class DrugPurchaseController {

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private DrugPurchaseRepo purchaseRepo;

    @Autowired
    private SummaryRepo summaryRepo;


    @GetMapping(value = "/add")
    public String addShow(DrugPurchase purchase, Model model) {
        model.addAttribute("purchase", new DrugPurchase());

        model.addAttribute("druglist", this.drugRepo.findAll());
        return "purchases/purchase";

    }

    @PostMapping(value = "/add")
    public String purchaseSave(@Valid DrugPurchase purchase, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("druglist", this.drugRepo.findAll());
            return "pruchases/purchase";
        }
        purchase.setPurchasedate(new Date());
        this.purchaseRepo.save(purchase);
        model.addAttribute("purchase", new DrugPurchase());
        model.addAttribute("success", "Congratulations! Data save sucessfully");
        model.addAttribute("druglist", this.drugRepo.findAll());
        //Summar save
        try {

            Summary summary = this.summaryRepo.findByDrugName(purchase.getDrug().getDrugName());
            int avialQty = summary.getAvailableQty() + purchase.getQty();
            summary.setAvailableQty(avialQty);
            summary.setLastUpdate(new Date());
            summary.setTotalQty(summary.getTotalQty() + purchase.getQty());
            summaryRepo.save(summary);

        } catch (NullPointerException ne) {
            Summary summary1 = new Summary();
            summary1.setDrugName(purchase.getDrug().getDrugName());
            summary1.setDrugCode(purchase.getDrug().getDrugCode());
            summary1.setTotalQty(purchase.getQty());
            summary1.setSoldQty(0);
            summary1.setAvailableQty(purchase.getQty());
            summary1.setLastUpdate(new Date());
            summary1.setDrug(purchase.getDrug());
            summaryRepo.save(summary1);

        }


        return "redirect:/pur/list";
    }


    @GetMapping(value = "/list")
    public String purchaseIndex(Model model) {
        model.addAttribute("purchaselist", this.purchaseRepo.findAll());
        return "purchases/list";
    }



    @GetMapping(value = "/del/{id}")
    public String purchasedel(@PathVariable("id") Long id) {
        if (id != null) {
            this.purchaseRepo.deleteById(id);

        }
        return "redirect:/pur/list";

    }

//
//    @GetMapping(value = "/editdrug/{id}")
//    public String editShow(Model model, @PathVariable("id") Long id) {
//        model.addAttribute("drug", this.drugRepo.getOne(id));
//        model.addAttribute("brandlist", this.brandRepo.findAll());
//        model.addAttribute("categorylist", this.categoryRepo.findAll());
//        model.addAttribute("typelist", this.drugtypeRepo.findAll());
//        return "drugs/edit-drug";
//
//    }
//
//
//    @PostMapping(value = "/editdrug/{id}")
//    public String drugEdit(@Valid Drug drug, BindingResult bindingResult, @PathVariable("id") Long id, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("brandlist", this.brandRepo.findAll());
//            model.addAttribute("categorylist", this.categoryRepo.findAll());
//            model.addAttribute("typelist", this.drugtypeRepo.findAll());
//            return "drugs/edit-drug";
//        }
//        drug.setDrugId(id);
//        this.drugRepo.save(drug);
//        model.addAttribute("drug", new Drug());
//        model.addAttribute("success", "Congratulations! Data save sucessfully");
//        model.addAttribute("brandlist", this.brandRepo.findAll());
//        model.addAttribute("categorylist", this.categoryRepo.findAll());
//        model.addAttribute("typelist", this.drugtypeRepo.findAll());
//
//        return "drugs/edit-drug";
//    }




}
