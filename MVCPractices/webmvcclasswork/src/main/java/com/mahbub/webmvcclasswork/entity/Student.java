package com.mahbub.webmvcclasswork.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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


    public Student() {
    }

    public Student(@NotNull @Size(min = 2, max = 30) String name, @Min(value = 18, message = "Hey, Minimum Age is 18") byte age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
