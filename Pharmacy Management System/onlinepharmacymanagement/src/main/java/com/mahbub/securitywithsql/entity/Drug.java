package com.mahbub.securitywithsql.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugId;

    private String drugName;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Category categories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drugtype_id", nullable = false)
    @JsonIgnore
    private Drugtype drugtypes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    @JsonIgnore
    private Brand brands;



    private Long qty;
    private Long unitPrice;
    private Long totalPrice;
    private String dimension;
    private String antidote;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date purchasedate;


    public Drug() {
    }

    public Drug(String drugName, Category categories, Drugtype drugtypes, Brand brands, Long qty, Long unitPrice, Long totalPrice, String dimension, String antidote, Date purchasedate) {
        this.drugName = drugName;
        this.categories = categories;
        this.drugtypes = drugtypes;
        this.brands = brands;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.dimension = dimension;
        this.antidote = antidote;
        this.purchasedate = purchasedate;
    }


    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Drugtype getDrugtypes() {
        return drugtypes;
    }

    public void setDrugtypes(Drugtype drugtypes) {
        this.drugtypes = drugtypes;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getAntidote() {
        return antidote;
    }

    public void setAntidote(String antidote) {
        this.antidote = antidote;
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
        Drug drug = (Drug) o;
        return Objects.equals(drugId, drug.drugId) &&
                Objects.equals(drugName, drug.drugName) &&
                Objects.equals(categories, drug.categories) &&
                Objects.equals(drugtypes, drug.drugtypes) &&
                Objects.equals(brands, drug.brands) &&
                Objects.equals(qty, drug.qty) &&
                Objects.equals(unitPrice, drug.unitPrice) &&
                Objects.equals(totalPrice, drug.totalPrice) &&
                Objects.equals(dimension, drug.dimension) &&
                Objects.equals(antidote, drug.antidote) &&
                Objects.equals(purchasedate, drug.purchasedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugId, drugName, categories, drugtypes, brands, qty, unitPrice, totalPrice, dimension, antidote, purchasedate);
    }
}
