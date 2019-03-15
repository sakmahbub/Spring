package com.sofiqul54.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "expense")
public class Exprnses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountTitle;
    private double amount;
    private double totalAmount;
    private Date pDate;

   @ManyToMany
   @JoinTable(
           name = "accn_head",
           joinColumns = @JoinColumn(name = "ex_id"),
           inverseJoinColumns = @JoinColumn(name = "accn_id"))
   private Set<AccountHead> accountHeads;

    @ManyToOne
    @JoinColumn(name = "incm_id", nullable = false)
    private Income income;

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

    public Date getpDate() {
        return pDate;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public Set<AccountHead> getAccountHeads() {
        return accountHeads;
    }

    public void setAccountHeads(Set<AccountHead> accountHeads) {
        this.accountHeads = accountHeads;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }
}
