package com.mahbub.securitywithsql.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "drug",uniqueConstraints={@UniqueConstraint(columnNames = {"drug_name" , "category_id","drugtype_id","brand_id"})})
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drug_name")
    private String drugName;

    @Column(unique = true)
    private String drugCode;

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


    private String dimension;
    private String antidote;

    private String unitPrice;


    public Drug() {
    }

    public Drug(String drugName, String drugCode, Category categories, Drugtype drugtypes, Brand brands, String dimension, String antidote, String unitPrice) {
        this.drugName = drugName;
        this.drugCode = drugCode;
        this.categories = categories;
        this.drugtypes = drugtypes;
        this.brands = brands;
        this.dimension = dimension;
        this.antidote = antidote;
        this.unitPrice = unitPrice;
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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(id, drug.id) &&
                Objects.equals(drugName, drug.drugName) &&
                Objects.equals(drugCode, drug.drugCode) &&
                Objects.equals(categories, drug.categories) &&
                Objects.equals(drugtypes, drug.drugtypes) &&
                Objects.equals(brands, drug.brands) &&
                Objects.equals(dimension, drug.dimension) &&
                Objects.equals(antidote, drug.antidote) &&
                Objects.equals(unitPrice, drug.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, drugName, drugCode, categories, drugtypes, brands, dimension, antidote, unitPrice);
    }
}
