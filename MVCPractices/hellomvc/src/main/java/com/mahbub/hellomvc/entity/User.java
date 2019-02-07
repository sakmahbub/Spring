package com.mahbub.hellomvc.entity;

public class User {

    private long id;
    private  String userName;
    private String mobile;

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(long id, String userName, String mobile) {
        this.id = id;
        this.userName = userName;
        this.mobile = mobile;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobile() {
        return mobile;
    }
}
