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


    private int totalQty;
    private int soldQty;
    private int availableQty;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdate;


    @OneToOne
    @JoinColumn(name = "drug_id", unique = true)
    private Drug drug;

    public Summary() {
    }

    public Summary(int totalQty, int soldQty, int availableQty, Date lastUpdate) {

        this.totalQty = totalQty;
        this.soldQty = soldQty;
        this.availableQty = availableQty;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Summary summary = (Summary) o;
        return totalQty == summary.totalQty &&
                soldQty == summary.soldQty &&
                availableQty == summary.availableQty &&
                Objects.equals(id, summary.id) &&
                Objects.equals(lastUpdate, summary.lastUpdate) &&
                Objects.equals(drug, summary.drug);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalQty, soldQty, availableQty, lastUpdate, drug);
    }
}
