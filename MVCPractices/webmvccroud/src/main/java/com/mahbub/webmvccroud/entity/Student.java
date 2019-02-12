package com.mahbub.webmvccroud.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Name at lest 2 character")
    private String name;

    @NotBlank(message = "Select Your Gender")
    private String gender;

    @NotEmpty(message = "Select Your Subject")
    private String[] subject;


    @NotBlank(message = "Select Your Round")
    private String round;


    @Min(value = 18, message = "Hey, minimun Age is 18")
    private byte age;

    @NotBlank(message = "Enter phone Number")
    private String phone;

    @NotBlank(message = "Enter your email")
    private String email;

    @NotNull
    @Size(min = 6, max = 2000, message = "Write massage limit 6-2000 letter")
    private String msg;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate=new Date();


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="student_role", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotEmpty(message = "Select at list One Role")
    private Set<Role> roles;

    //////File Upload==============
    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;

    @NotNull
    @Size(min = 4, max = 30, message = "UserName at lest 4 character")
    private String UserName;

    @NotNull
    @Size(min = 6, max = 30, message = "Password at lest 6 character")
    private String password;

    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30, message = "Name at lest 2 character") String name, @NotBlank(message = "Select Your Gender") String gender, @NotBlank(message = "Select Your Subject") String[] subject, @NotBlank(message = "Select Your Round") String round, @Min(value = 18, message = "Hey, minimun Age is 18") byte age, @NotBlank(message = "Enter phone Number") String phone, @NotBlank(message = "Enter your email") String email, @NotNull @Size(min = 6, max = 2000, message = "Write massage limit 6-2000 letter") String msg, Date regiDate, Date lastModifiedDate, Date birthDate) {
        this.name = name;
        this.gender = gender;
        this.subject = subject;
        this.round = round;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.msg = msg;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(subject, student.subject) &&
                Objects.equals(round, student.round) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(email, student.email) &&
                Objects.equals(msg, student.msg) &&
                Objects.equals(regiDate, student.regiDate) &&
                Objects.equals(lastModifiedDate, student.lastModifiedDate) &&
                Objects.equals(birthDate, student.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, subject, round, age, phone, email, msg, regiDate, lastModifiedDate, birthDate);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", subject='" + subject + '\'' +
                ", round='" + round + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", msg='" + msg + '\'' +
                ", regiDate=" + regiDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", birthDate=" + birthDate +
                '}';
    }
}
