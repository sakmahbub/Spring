package com.mahbub.securitywithsql.entity;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "drugpurchase")
public class DrugPurchase {

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
    private Date purchasedate;


    public DrugPurchase() {
    }

    public DrugPurchase(Drug drug, int qty, double unitPrice, double totalPrice, Date purchasedate) {
        this.drug = drug;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.purchasedate = purchasedate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
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

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugPurchase that = (DrugPurchase) o;
        return qty == that.qty &&
                Double.compare(that.unitPrice, unitPrice) == 0 &&
                Double.compare(that.totalPrice, totalPrice) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(drug, that.drug) &&
                Objects.equals(purchasedate, that.purchasedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drug, qty, unitPrice, totalPrice, purchasedate);
    }
}
