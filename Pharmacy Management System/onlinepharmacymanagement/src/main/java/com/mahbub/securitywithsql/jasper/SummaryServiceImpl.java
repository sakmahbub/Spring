package com.mahbub.securitywithsql.jasper;

import com.mahbub.securitywithsql.entity.Summary;
import com.mahbub.securitywithsql.repo.SummaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("summaryService")
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    private SummaryRepo summaryRepo;

    @Override
    public List<Map<String, Object>> report() {
        List<Map<String, Object>> result= new ArrayList<Map<String, Object>>();
        for (Summary summary : summaryRepo.findAll()) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", summary.getId());
            item.put("drugName", summary.getDrugName());
            item.put("totalQty", summary.getTotalQty());
            item.put("soldQty", summary.getSoldQty());
            item.put("availableQty", summary.getAvailableQty());
            result.add(item);
        }

        return result;
    }
}
