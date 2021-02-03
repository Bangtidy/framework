package com.java.IOC.spring.mod;


public class Person {
    //建议使用Integer（封装类型，默认为null）,不使用int（基本数据类型，默认为0）
    private Integer id;

    private String name;

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
