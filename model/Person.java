package com.model;

import java.sql.Date;

public class Person {
    protected String name;
    protected Integer old;
    protected Date dob;
    protected String address;
    protected String gender;

    public Person() {
    }

    public Person(String name, Integer old, Date dob, String address, String gender) {
        this.name = name;
        this.old = old;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nPerson{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", dob=" + dob +
                ", address=" + address +
                ", gender=" + gender +
                '}';
    }
}
