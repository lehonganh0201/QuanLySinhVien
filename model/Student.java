package com.model;

import java.sql.Date;

    public class Student extends Person{
        private String maSinhVien;
        private String className;
        private String khoaQuanLy;
        private String schoolName;
        private Float GPA;

    public Student() {
    }

    public Student(String name, Integer old, Date dob, String address, String gender) {
        super(name, old, dob, address, gender);
    }

    public Student(String maSinhVien, String className, String khoaQuanLy, String schoolName, Float GPA) {
        this.maSinhVien = maSinhVien;
        this.className = className;
        this.khoaQuanLy = khoaQuanLy;
        this.schoolName = schoolName;
        this.GPA = GPA;
    }

        public Student(String name, Integer old, Date dob, String address, String gender, String maSinhVien, String className, String khoaQuanLy, String schoolName, Float GPA) {
            super(name, old, dob, address, gender);
            this.maSinhVien = maSinhVien;
            this.className = className;
            this.khoaQuanLy = khoaQuanLy;
            this.schoolName = schoolName;
            this.GPA = GPA;
        }

        public Student(String name, Integer old, Date dob, String address, String gender, String className, String khoaQuanLy, String schoolName, Float GPA) {
        super(name, old, dob, address, gender);
        this.className = className;
        this.khoaQuanLy = khoaQuanLy;
        this.schoolName = schoolName;
        this.GPA = GPA;
    }

        public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getKhoaQuanLy() {
        return khoaQuanLy;
    }

    public void setKhoaQuanLy(String khoaQuanLy) {
        this.khoaQuanLy = khoaQuanLy;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Float getGPA() {
        return GPA;
    }

    public void setGPA(Float GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "maSinhVien='" + maSinhVien + '\'' +
                ", className='" + className + '\'' +
                ", khoaQuanLy='" + khoaQuanLy + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}
