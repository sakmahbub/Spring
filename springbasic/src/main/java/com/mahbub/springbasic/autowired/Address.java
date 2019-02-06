package com.mahbub.springbasic.autowired;


import org.springframework.stereotype.Component;

@Component
public class Address {
    private String city;

    private String country;


    public Address() {

        System.out.println("Object Created............cons");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void show() {
        System.out.println("Show...............");

    }
}
