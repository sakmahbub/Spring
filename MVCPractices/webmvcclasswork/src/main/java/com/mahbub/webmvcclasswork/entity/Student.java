package com.mahbub.webmvcclasswork.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "student2")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Name at list 2 letter")
    private String name;

    @Min(value = 18, message = "Hey, Minimum Age is 18")
    private byte age;

    @NotBlank(message = "Enter your email")
    private String email;


    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30, message = "Name at list 2 letter") String name, @Min(value = 18, message = "Hey, Minimum Age is 18") byte age, @NotNull(message = "Enter Your valid Email") String email) {
        this.name = name;
        this.age = age;
        this.email = email;
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
