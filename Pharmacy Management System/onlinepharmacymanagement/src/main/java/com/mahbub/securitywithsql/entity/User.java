package com.mahbub.securitywithsql.entity;


import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 30, message = "Name at lest 2 character")
    private String name;


    @NotBlank(message = "Enter your email")
    private String email;

    @NotNull
    @Size(min = 5, max = 30, message = "UserName at lest 5 character")
    private String userName;

    @NotNull
    @Size(min = 4, max = 300, message = "Password at lest 4 character")
    private String password;


    private String gender;


    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate=new Date();


    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    private boolean enabled;

    @Column(nullable = false)
    private String confirmationToken;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(String name,  String email, String userName, String password,  Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public User(User user) {
        this.name = user.name;
        this.email = user.email;
        this.userName = user.userName;
        this.password = user.password;
        this.roles = user.roles;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

