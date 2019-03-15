package com.sofiqul54.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "package")
public class Ppackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "package_name", nullable = false, unique = true)
    private String name;
    @Column(name = "package_value", nullable = false)
    private double price;

    public Ppackage() {
    }

    public Ppackage(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ppackage ppackage = (Ppackage) o;
        return Double.compare(ppackage.price, price) == 0 &&
                Objects.equals(id, ppackage.id) &&
                Objects.equals(name, ppackage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
