package com.mahbub.securitywithsql.controller;

import com.mahbub.securitywithsql.controller.dto.LabelValueDTO;
import com.mahbub.securitywithsql.entity.Drug;
import com.mahbub.securitywithsql.repo.DrugRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AutoComplextController {
    @Autowired
    private DrugRepo drugRepo;
    List<Drug> allDrusg=new ArrayList<>();

    @RequestMapping(value = "/drugAutocomplete")
    @ResponseBody
    public List<LabelValueDTO> plantNamesAutocomplete(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
        List<LabelValueDTO> suggestions = new ArrayList<LabelValueDTO>();
        try {
            // only update when term is three characters.
            if (term.length() == 3) {
                allDrusg = drugRepo.findAll();
            }

            for (Drug drug : allDrusg) {

                if (drug.toString().contains(term) || drug.toString().contains(term.toUpperCase()) || drug.toString().contains(term.toLowerCase()) || drug.toString().contains(term.substring(0, 1).toUpperCase() + term.substring(1)) ) {
                    LabelValueDTO lv = new LabelValueDTO();
                    lv.setLabel(drug.getDrugName());
                    lv.setValue(drug.getDrugName());
                    suggestions.add(lv);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return suggestions;

    }
    @RequestMapping(value = "/autocompletes", method = RequestMethod.GET)
    public String showAutocomplete() {
        return "saless/auto";
    }
}
