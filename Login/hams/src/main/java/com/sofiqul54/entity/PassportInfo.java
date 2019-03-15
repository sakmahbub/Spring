package com.sofiqul54.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "passport_info")
public class PassportInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passportNo;
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Temporal(TemporalType.DATE)
    private Date expDate;
    private String dip;

    @OneToOne
    @JoinColumn(name = "pl_id", nullable = false)
    private Pilgrim pilgrim;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getDip() {
        return dip;
    }

    public void setDip(String dip) {
        this.dip = dip;
    }

    public Pilgrim getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(Pilgrim pilgrim) {
        this.pilgrim = pilgrim;
    }
}
