package com.mahbub.securitywithsql.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    private String brandName;
    private String brandLocation;
    private String brandTelNo;

    public Brand() {
    }

    public Brand(String brandName, String brandLocation, String brandTelNo) {
        this.brandName = brandName;
        this.brandLocation = brandLocation;
        this.brandTelNo = brandTelNo;
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLocation() {
        return brandLocation;
    }

    public void setBrandLocation(String brandLocation) {
        this.brandLocation = brandLocation;
    }

    public String getBrandTelNo() {
        return brandTelNo;
    }

    public void setBrandTelNo(String brandTelNo) {
        this.brandTelNo = brandTelNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(brandId, brand.brandId) &&
                Objects.equals(brandName, brand.brandName) &&
                Objects.equals(brandLocation, brand.brandLocation) &&
                Objects.equals(brandTelNo, brand.brandTelNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, brandName, brandLocation, brandTelNo);
    }
}
