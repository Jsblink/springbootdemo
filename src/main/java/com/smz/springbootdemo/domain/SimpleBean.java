package com.smz.springbootdemo.domain;


import java.io.Serializable;

public class SimpleBean implements Serializable {
    private static final long serialVersionUID = 1L;
    public void simpleBeanInitMethod(){
        System.out.println("SimpleBean init method starts");
    }

    public SimpleBean() {
    }

    public SimpleBean(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private Integer id;
    private String  name;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
