package com.enlightendev.spring.core.domain;

/**
 * Created by Juan on 3/21/14.
 */
public class Company {

    private int id;
    private String name;

    public Company(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
