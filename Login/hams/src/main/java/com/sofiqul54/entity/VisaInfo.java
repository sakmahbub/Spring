package com.sofiqul54.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visa_info")
public class VisaInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date applyDate;
    @Column(unique = true, nullable = false)
    private String visaNo;
    @Temporal(TemporalType.DATE)
    private Date vIssueDate;
    @Temporal(TemporalType.DATE)
    private Date vValidityDate;
    private String status;

    @OneToOne
    @JoinColumn(name = "pil_id")
    private Pilgrim pilgrim;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getVisaNo() {
        return visaNo;
    }

    public void setVisaNo(String visaNo) {
        this.visaNo = visaNo;
    }

    public Date getvIssueDate() {
        return vIssueDate;
    }

    public void setvIssueDate(Date vIssueDate) {
        this.vIssueDate = vIssueDate;
    }

    public Date getvValidityDate() {
        return vValidityDate;
    }

    public void setvValidityDate(Date vValidityDate) {
        this.vValidityDate = vValidityDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pilgrim getPilgrim() {
        return pilgrim;
    }

    public void setPilgrim(Pilgrim pilgrim) {
        this.pilgrim = pilgrim;
    }
}
