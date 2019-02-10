package com.mahbub.webmvccroud.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "student3")
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

//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date regidate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date lastModifireDate=new Date();

    @NotNull
    @Size(min = 6, max = 2000, message = "Write massage limit 6-2000 letter")
    private String msg;


//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date birthDate;

    public Student() {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(gender, student.gender) &&
                Arrays.equals(subject, student.subject) &&
                Objects.equals(round, student.round) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(email, student.email) &&
                Objects.equals(msg, student.msg);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, gender, round, age, phone, email, msg);
        result = 31 * result + Arrays.hashCode(subject);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", subject=" + Arrays.toString(subject) +
                ", round='" + round + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
