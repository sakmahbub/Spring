package com.mahbub.securitywithsql.controller;


import com.mahbub.securitywithsql.controller.dto.SalesDto;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

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




    @GetMapping(value = "/searchdrug")
    public String searchDrugName(Model model, @RequestParam("drugName") String drugName) {
        System.out.println("==========Called=====on====Input====="+drugName);
        model.addAttribute("drugaftersearch", drugRepo.findByDrugNameIsLikeOrAndDrugNameIsContainingOrDrugNameIsEndingWithOrDrugCodeStartsWith(drugName,drugName,drugName,drugName));
        return "saless/saless";

    }



    @GetMapping(value = "/add")
    public String addShow(Sales sales, Model model) {
          model.addAttribute("form", dto);
        return "saless/saless";

    }

    @PostMapping(value = "/add")
    public String salesSave(@Valid Sales sales, @ModelAttribute SalesDto salesDto,  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("druglist", this.drugRepo.findAll());
            return "saless/saless";
        }
        try {



            for(int i=0; i < salesDto.getSaless().size(); i++) {
                Sales sales1=new Sales(drugRepo.findByDrugName(salesDto.getSaless().get(i).getDrugName()), salesDto.getSaless().get(i).getQty(), salesDto.getSaless().get(i).getUnitPrice(), salesDto.getSaless().get(i).getTotalPrice(), new Date());
                salesRepo.save(sales1);
                Summary summary = this.summaryRepo.findByDrugName(salesDto.getSaless().get(i).getDrugName());

                if (sales1.getQty() <= summary.getAvailableQty()) {
                    //Summar save
                    int avialQty = summary.getAvailableQty() - sales1.getQty();
                    summary.setAvailableQty(avialQty);
                    int totalSold = summary.getSoldQty() + sales1.getQty();
                    summary.setSoldQty(totalSold);
                    summary.setLastUpdate(new Date());
                    summaryRepo.save(summary);
                    model.addAttribute("success", " Drug Sales Successfully");
                } else {
                    model.addAttribute("rejectMsg", "You don't have sufficient Qty");
                    model.addAttribute("druglist", this.drugRepo.findAll());

                }
            }
        }catch(NullPointerException ne) {
            ne.printStackTrace();
        }


        return "saless/saless";
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
        System.out.println("size at create: " + dto.getSaless().size());
        return "saless/saless";
    }

    /*@GetMapping("/create")
    public String showCreateForm(Model model) {
        System.out.println("size at create: " + dto.getSaless().size());
        model.addAttribute("form", dto);
        return "saless/saless";
    }


    @PostMapping("/save")
    public String saveBooks(@ModelAttribute SalesDto salesDto, Model model) {
        System.out.println(salesDto.getSaless().size());
        salesRepo.saveAll(salesDto.getSaless());
        model.addAttribute("form", new SalesDto());

        model.addAttribute("druglist", salesRepo.findAll());
        return "redirect:/sales/list";
    }
*/
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
