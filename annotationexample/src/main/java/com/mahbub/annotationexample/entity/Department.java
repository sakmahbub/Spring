package com.mahbub.annotationexample.entity;

public class Department {
    private int depid;
    private String depname;

    public Department(int depid, String depname) {
        this.depid = depid;
        this.depname = depname;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depid=" + depid +
                ", depname='" + depname + '\'' +
                '}';
    }
}
