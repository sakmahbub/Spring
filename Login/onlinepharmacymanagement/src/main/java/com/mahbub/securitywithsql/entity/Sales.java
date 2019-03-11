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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drug_id", nullable = false)
    private Drug drug;

    private int qty;
    private double unitPrice;
    private double totalPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date salseDate=new Date();


    public Sales() {
    }

    public Sales(Drug drug, int qty, double unitPrice, double totalPrice, Date salseDate) {
        this.drug = drug;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.salseDate = salseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSalseDate() {
        return salseDate;
    }

    public void setSalseDate(Date salseDate) {
        this.salseDate = salseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sales sales = (Sales) o;
        return qty == sales.qty &&
                Double.compare(sales.unitPrice, unitPrice) == 0 &&
                Double.compare(sales.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, sales.id) &&
                Objects.equals(drug, sales.drug) &&
                Objects.equals(salseDate, sales.salseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drug, qty, unitPrice, totalPrice, salseDate);
    }
}
