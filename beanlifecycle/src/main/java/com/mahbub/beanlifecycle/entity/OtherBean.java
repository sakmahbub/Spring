package com.mahbub.beanlifecycle.entity;

public class OtherBean {
    private int obid;
    private String obName;

    public void setObid(int obid) {
        this.obid = obid;
    }

    public void setObName(String obName) {
        this.obName = obName;
    }

    public int getObid() {
        return obid;
    }

    public String getObName() {
        return obName;
    }

    @Override
    public String toString() {
        return "OtherBean{" +
                "obid=" + obid +
                ", obName='" + obName + '\'' +
                '}';
    }
}
