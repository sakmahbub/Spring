package com.sofiqul54.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "group_leader")
public class Groupleader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "gleader_name", nullable = false)
    private String leaderName;

    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date birthDate;

    @Column(name = "leader_nid", nullable = false, unique = true)
    private String nid;

    @Column(name = "pass_name", nullable = false, unique = true)
    private String passportNo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date issuDate;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date expDate;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @NotEmpty
    @Email
    @NotEmpty(message = "Enter An Email")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "address")
    private String address;


    public Groupleader() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getIssuDate() {
        return issuDate;
    }

    public void setIssuDate(Date issuDate) {
        this.issuDate = issuDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groupleader that = (Groupleader) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(leaderName, that.leaderName) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(regiDate, that.regiDate) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(nid, that.nid) &&
                Objects.equals(passportNo, that.passportNo) &&
                Objects.equals(issuDate, that.issuDate) &&
                Objects.equals(expDate, that.expDate) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leaderName, gender, regiDate, birthDate, nid, passportNo, issuDate, expDate, mobile, email, address);
    }
}
