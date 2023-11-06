package com.model;

import java.sql.Date;

public class Teacher extends Person{
    private String maGiaoVien;
    private String lopQuanLy;

    public Teacher(String maGiaoVien, String lopQuanLy) {
        this.maGiaoVien = maGiaoVien;
        this.lopQuanLy = lopQuanLy;
    }

    public Teacher(String name, Integer old, Date dob, String address, String gender, String lopQuanLy) {
        super(name, old, dob, address, gender);
        this.maGiaoVien = maGiaoVien;
        this.lopQuanLy = lopQuanLy;
    }

    public Teacher(String name, Integer old, Date dob, String address, String gender, String maGiaoVien, String lopQuanLy) {
        super(name, old, dob, address, gender);
        this.maGiaoVien = maGiaoVien;
        this.lopQuanLy = lopQuanLy;
    }

    public Teacher() {
    }

    public Teacher(String name, Integer old, Date dob, String address, String gender) {
        super(name, old, dob, address, gender);
    }

    public String getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(String maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    public String getLopQuanLy() {
        return lopQuanLy;
    }

    public void setLopQuanLy(String lopQuanLy) {
        this.lopQuanLy = lopQuanLy;
    }

    @Override
    public String toString() {
        return "\nTeacher{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", maGiaoVien='" + maGiaoVien + '\'' +
                ", lopQuanLy='" + lopQuanLy + '\'' +
                '}';
    }
}

