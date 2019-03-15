package com.sofiqul54.entity;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "pilgrim")
public class Pilgrim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private long accountNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String motherName;

    @Column(nullable = false)
    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date birthDate;

    @Column(nullable = false)
    private String nid;

    @Column(nullable = false)
    private String maritalStatus;//check or radio status

    @Column(nullable = false)
    private String spouseName;

    @Column(nullable = false)
    private String occupation;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String district; // dropdown hobe

    private double bookingAmount;
    private double balanceAmount;


    @ManyToOne
    @JoinColumn(name = "pk_id", nullable = false)
    private Ppackage ppackage;//dropdown hobe

    @ManyToOne
    @JoinColumn(name = "gl_id", nullable = false)
    private Groupleader groupleader; //dropdown hobe


    public Pilgrim() {
    }

    public Pilgrim(long accountNumber, String name, String fatherName, String motherName, String gender, Date regiDate, Date lastModifiedDate, Date birthDate, String nid, String maritalStatus, String spouseName, String occupation, String address, String district, double bookingAmount, double balanceAmount, Ppackage ppackage, Groupleader groupleader) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.gender = gender;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
        this.nid = nid;
        this.maritalStatus = maritalStatus;
        this.spouseName = spouseName;
        this.occupation = occupation;
        this.address = address;
        this.district = district;
        this.bookingAmount = bookingAmount;
        this.balanceAmount = balanceAmount;
        this.ppackage = ppackage;
        this.groupleader = groupleader;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
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

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public Ppackage getPpackage() {
        return ppackage;
    }

    public void setPpackage(Ppackage ppackage) {
        this.ppackage = ppackage;
    }

    public Groupleader getGroupleader() {
        return groupleader;
    }

    public void setGroupleader(Groupleader groupleader) {
        this.groupleader = groupleader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pilgrim pilgrim = (Pilgrim) o;
        return accountNumber == pilgrim.accountNumber &&
                Double.compare(pilgrim.bookingAmount, bookingAmount) == 0 &&
                Double.compare(pilgrim.balanceAmount, balanceAmount) == 0 &&
                Objects.equals(id, pilgrim.id) &&
                Objects.equals(name, pilgrim.name) &&
                Objects.equals(fatherName, pilgrim.fatherName) &&
                Objects.equals(motherName, pilgrim.motherName) &&
                Objects.equals(gender, pilgrim.gender) &&
                Objects.equals(regiDate, pilgrim.regiDate) &&
                Objects.equals(lastModifiedDate, pilgrim.lastModifiedDate) &&
                Objects.equals(birthDate, pilgrim.birthDate) &&
                Objects.equals(nid, pilgrim.nid) &&
                Objects.equals(maritalStatus, pilgrim.maritalStatus) &&
                Objects.equals(spouseName, pilgrim.spouseName) &&
                Objects.equals(occupation, pilgrim.occupation) &&
                Objects.equals(address, pilgrim.address) &&
                Objects.equals(district, pilgrim.district) &&
                Objects.equals(ppackage, pilgrim.ppackage) &&
                Objects.equals(groupleader, pilgrim.groupleader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, name, fatherName, motherName, gender, regiDate, lastModifiedDate, birthDate, nid, maritalStatus, spouseName, occupation, address, district, bookingAmount, balanceAmount, ppackage, groupleader);
    }
}
