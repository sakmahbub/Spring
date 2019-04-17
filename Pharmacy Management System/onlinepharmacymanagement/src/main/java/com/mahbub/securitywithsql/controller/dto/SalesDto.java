package com.mahbub.securitywithsql.controller.dto;



import com.mahbub.securitywithsql.entity.Sales;

import java.util.ArrayList;
import java.util.List;

public class SalesDto {

    private List<Sales> saless = new ArrayList<>();

    public SalesDto() {
        this.saless.add(new Sales());
    }

    public void addSales(Sales sales) {
        this.saless.add(sales);
    }


    public void removeSales(int index) {
        this.saless.remove(index);

    }


    public List<Sales> getSaless() {
        return saless;
    }

    public void setSaless(List<Sales> saless) {
        this.saless = saless;
    }
}
