package com.mahbub.securitywithsql.controller;

import com.mahbub.securitywithsql.entity.Sales;

import java.util.ArrayList;
import java.util.List;

public class SalesDto {

    private List<Sales> salesLi=new ArrayList<>();

    public SalesDto() {
        this.salesLi.add(new Sales());
    }
    // default and parameterized constructor


    public void addSales(Sales sales){
        this.salesLi.add(sales);

    }

    public void removeSales(int index){
        this.salesLi.remove(index);
    }

    public List<Sales> getSalesLi() {
        return salesLi;
    }

    public void setSalesLi(List<Sales> salesLi) {
        this.salesLi = salesLi;
    }
}
