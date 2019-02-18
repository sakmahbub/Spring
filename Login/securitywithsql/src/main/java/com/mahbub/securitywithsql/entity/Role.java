package com.mahbub.securitywithsql.entity;


import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rolename;

    public Role() {
    }

    public Role(Long id) {
        this.id=id;
    }

    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Long getRoleid() {
        return id;
    }

    public void setRoleid(Long roleid) {
        this.id = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
