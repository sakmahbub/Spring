package com.sofiqul54.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "income")
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String accountTitle;
    private double amount;
    private double totalAmount;
    private Date cDate;

    @ManyToOne
    @JoinColumn(name = "pilgm_id", nullable = false)
    private Pilgrim pilgrim;

    @ManyToMany
    @JoinTable(
            name = "acc_head",
            joinColumns = @JoinColumn(name = "inc_id"),
            inverseJoinColumns = @JoinColumn(name = "acc_id"))
            private Set<AccountHead> accountHeads;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getcDate() {
        return cDate;
    }

    public void setcDate(Date cDate) {
        this.cDate = cDate;
    }

    public Pilgrim getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(Pilgrim pilgrim) {
        this.pilgrim = pilgrim;
    }

    public Set<AccountHead> getAccountHeads() {
        return accountHeads;
    }

    public void setAccountHeads(Set<AccountHead> accountHeads) {
        this.accountHeads = accountHeads;
    }
}
