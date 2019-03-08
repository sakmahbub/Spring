package com.mahbub.securitywithsql.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "summary")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String drugName;
    private String drugCode;
    private int totalQty;
    private int soldQty;
    private int availableQty;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;


    @OneToOne
    @JoinColumn(name = "drugPurchase_id", unique = true)
    private DrugPurchase purchase;

    public Summary() {
    }


    public Summary(String drugName, String drugCode, int totalQty, int soldQty, int availableQty, Date lastUpdate, DrugPurchase purchase) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.lastUpdate = lastUpdate;
        this.purchase = purchase;
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

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getSoldQty() {
        return soldQty;
    }

    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
    }

    public int getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(int availableQty) {
        this.availableQty = availableQty;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public DrugPurchase getPurchase() {
        return purchase;
    }

    public void setPurchase(DrugPurchase purchase) {
        this.purchase = purchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return totalQty == summary.totalQty &&
                soldQty == summary.soldQty &&
                availableQty == summary.availableQty &&
                Objects.equals(id, summary.id) &&
                Objects.equals(drugName, summary.drugName) &&
                Objects.equals(drugCode, summary.drugCode) &&
                Objects.equals(lastUpdate, summary.lastUpdate) &&
                Objects.equals(purchase, summary.purchase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drugName, drugCode, totalQty, soldQty, availableQty, lastUpdate, purchase);
    }
}
