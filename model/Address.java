package com.model;

public class Address {
    private String hamlet;
    private String village;
    private String town;
    private String province;
    private String city;

    public Address(String hamlet, String village, String town, String province, String city) {
        this.hamlet = hamlet;
        this.village = village;
        this.town = town;
        this.province = province;
        this.city = city;
    }

    public Address() {
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "\nAddress{" +
                "hamlet='" + hamlet + '\'' +
                ", village='" + village + '\'' +
                ", town='" + town + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
