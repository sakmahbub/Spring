package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.controller.dto.SalesDto;
import com.mahbub.securitywithsql.entity.Contact;
import com.mahbub.securitywithsql.entity.Sales;
import com.mahbub.securitywithsql.entity.Summary;
import com.mahbub.securitywithsql.repo.ContactRepo;
import com.mahbub.securitywithsql.repo.DrugRepo;
import com.mahbub.securitywithsql.repo.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;


@Controller
@RequestMapping(value = "/order/")
public class OrderController {

    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private DrugRepo drugRepo;

    @Autowired
    private SalesRepo salesRepo;

    SalesDto dto = new SalesDto();


    @GetMapping(value = "/add")
    public String addShow(Sales sales, Model model) {
        model.addAttribute("form", dto);
        return "contact/order";

    }



    @PostMapping(value = "/add")
    public String salesSave(@Valid Sales sales, @ModelAttribute SalesDto salesDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("druglist", this.drugRepo.findAll());
            return "contact/order";
        }else {

            model.addAttribute("success", " Drug Sales Successfully");
            model.addAttribute("druglist", this.drugRepo.findAll());

        }
        return "contact/order";
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
        System.out.println("size at create: " + dto.getSaless().size());
        return "contact/order";
    }


}
