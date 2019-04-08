package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.entity.Sales;
import com.mahbub.securitywithsql.entity.Summary;

import com.mahbub.securitywithsql.repo.DrugRepo;
import com.mahbub.securitywithsql.repo.SalesRepo;
import com.mahbub.securitywithsql.repo.SummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(value = "/sales")
public class SalesController {

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private SalesRepo salesRepo;

    @Autowired
    private SummaryRepo summaryRepo;

    SalesDto dto = new SalesDto();


    @GetMapping(value = "/add")
    public String addShow(Sales sales, Model model) {
        model.addAttribute("sales", new Sales());

        model.addAttribute("druglist", this.drugRepo.findAll());
        return "saless/sal";

    }

    @PostMapping(value = "/add")
    public String salesSave(@Valid Sales sales, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("druglist", this.drugRepo.findAll());
            return "saless/sal";
        }
        try {
            Summary summary = this.summaryRepo.findByDrugName(sales.getDrug().getDrugName());
            if (sales.getQty() <= summary.getAvailableQty()) {
                this.salesRepo.save(sales);
                model.addAttribute("sales", new Sales());
                model.addAttribute("success", "Congratulations! Data save sucessfully");
                model.addAttribute("druglist", this.drugRepo.findAll());
                //Summar save


                int avialQty = summary.getAvailableQty() - sales.getQty();
                summary.setAvailableQty(avialQty);
                int totalSold = summary.getSoldQty() + sales.getQty();
                summary.setSoldQty(totalSold);
                summary.setLastUpdate(new Date());
                summaryRepo.save(summary);
            } else {
                model.addAttribute("rejectMsg", "You don't have sufficient Qty");
                model.addAttribute("druglist", this.drugRepo.findAll());

            }

        } catch (NullPointerException ne) {
            ne.printStackTrace();
        }


        return "saless/sal";
    }


    @GetMapping(value = "/list")
    public String salesIndex(Model model) {
        model.addAttribute("saleslist", this.salesRepo.findAll());
        return "saless/list";
    }


    @GetMapping(value = "/del/{id}")
    public String salesDel(@PathVariable("id") Long id) {
        if (id != null) {
            this.salesRepo.deleteById(id);

        }
        return "redirect:/sales/list";

    }





    @GetMapping("/delete/{index}")
    public String delFromList(@PathVariable("index") int index) {
        dto.removeSales(index);
        System.out.println("size at create: " + dto.getSalesLi().size());
        return "saless/sal";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {


//        for (int i = 1; i <= 3; i++) {
        //   booksForm.addBook(new Book());
        // }
        dto.addSales(new Sales());

        System.out.println("size at create: "+ dto.getSalesLi().size());
        model.addAttribute("form", dto);
        return "saless/saless";
    }


    @PostMapping("/save")
    public String saveBooks(@ModelAttribute SalesDto salesDto, Model model) {
        System.out.println(salesDto.getSalesLi().size());
        salesRepo.saveAll(salesDto.getSalesLi());
        model.addAttribute("form", new SalesDto());

        model.addAttribute("books", salesRepo.findAll());
        return "redirect:/sales/list";
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
