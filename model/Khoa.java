package com.model;

public class Khoa {
    private int maKhoa;
    private String tenKhoa;
    private int soLuongPhongBan;

    public Khoa(String tenKhoa, int soLuongPhongBan) {
        this.tenKhoa = tenKhoa;
        this.soLuongPhongBan = soLuongPhongBan;
    }

    public Khoa(int maKhoa, String tenKhoa, int soLuongPhongBan) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.soLuongPhongBan = soLuongPhongBan;
    }

    public Khoa() {
    }

    public int getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(int maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public int getSoLuongPhongBan() {
        return soLuongPhongBan;
    }

    public void setSoLuongPhongBan(int soLuongPhongBan) {
        this.soLuongPhongBan = soLuongPhongBan;
    }

    @Override
    public String toString() {
        return "\nKhoa{" +
                "maKhoa=" + maKhoa +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", soLuongPhongBan=" + soLuongPhongBan +
                '}';
    }
}
