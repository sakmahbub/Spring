package com.mahbub.beanlifecycle.entity;

public class SimpleBean {
    private final String DEFAULT_NAME="Sakil Mahbub";
  private String name=null;
    private int age=Integer.MAX_VALUE;
    private OtherBean otherBean;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOtherBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }


    @Override
    public String toString() {
        return "SimpleBean{" +
                "DEFAULT_NAME='" + DEFAULT_NAME + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", otherBean=" + otherBean +
                '}';
    }

    public void init(){
        System.out.println("Initalizing Bean");
        if(name == null){
            System.out.println("Using Defailt name");
            name=DEFAULT_NAME;

        }
        if (age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set the age property of" + SimpleBean.class);
        }
        if(otherBean.getObName() == null){
            System.out.println("Using Defailt name");
            otherBean.setObName("hdfgdhf");

        }
    }
}
