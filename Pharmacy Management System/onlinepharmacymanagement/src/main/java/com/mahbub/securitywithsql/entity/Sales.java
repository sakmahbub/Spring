package com.mahbub.securitywithsql.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String drugName;
    private Long qty;
    private Long unitPrice;
    private Long totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date SalseDate;


    public Sales() {
    }

    public Sales(String drugName, Long qty, Long unitPrice, Long totalPrice, Date salseDate) {
        this.drugName = drugName;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        SalseDate = salseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSalseDate() {
        return SalseDate;
    }

    public void setSalseDate(Date salseDate) {
        SalseDate = salseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return Objects.equals(id, sales.id) &&
                Objects.equals(drugName, sales.drugName) &&
                Objects.equals(qty, sales.qty) &&
                Objects.equals(unitPrice, sales.unitPrice) &&
                Objects.equals(totalPrice, sales.totalPrice) &&
                Objects.equals(SalseDate, sales.SalseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drugName, qty, unitPrice, totalPrice, SalseDate);
    }
}
