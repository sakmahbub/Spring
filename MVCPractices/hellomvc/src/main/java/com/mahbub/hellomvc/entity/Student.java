package com.mahbub.hellomvc.entity;

public class Student {

    private int id;
    private String name;
    private String gender;
    private String round;
    private String email;

    public Student(int id, String name, String gender, String round, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.round = round;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getRound() {
        return round;
    }

    public String getEmail() {
        return email;
    }
}
