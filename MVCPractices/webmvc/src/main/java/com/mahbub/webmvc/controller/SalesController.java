package com.mahbub.webmvc.controller;


import com.mahbub.webmvc.entity.Sales;
import com.mahbub.webmvc.repository.SalesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalesController {

    @Autowired
    private SalesRepo repo;

    SalesDto dto=new SalesDto();

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("druglist", repo.findAll());
        return "list";
    }
    @GetMapping("/del/{index}")
    public String delFromList(@PathVariable("index") int index) {

        dto.removeSales(index);

        System.out.println("size at create: "+dto.getSaless().size());

        return "sales";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model) {
            System.out.println("size at create: "+dto.getSaless().size());
        model.addAttribute("form", dto);
        return "sales";
    }

    @PostMapping("/save")
    public String saveSales(@ModelAttribute SalesDto salesDto, Model model) {
        System.out.println(salesDto.getSaless().size());
        repo.saveAll(salesDto.getSaless());
        model.addAttribute("form", new SalesDto());

        model.addAttribute("druglist", repo.findAll());
        return "sales";
    }
}
