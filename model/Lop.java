package com.model;

public class Lop {
    private int maLop;
    private String tenLop;
    private int soLuongHocSinh;
    private int maGiaoVien;

    public Lop(String tenLop, int soLuongHocSinh, int maGiaoVien) {
        this.tenLop = tenLop;
        this.soLuongHocSinh = soLuongHocSinh;
        this.maGiaoVien = maGiaoVien;
    }

    public Lop(int maLop, String tenLop, int soLuongHocSinh, int maGiaoVien) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.soLuongHocSinh = soLuongHocSinh;
        this.maGiaoVien = maGiaoVien;
    }

    public Lop() {
    }

    public int getMaLop() {
        return maLop;
    }

    public void setMaLop(int maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public int getSoLuongHocSinh() {
        return soLuongHocSinh;
    }

    public void setSoLuongHocSinh(int soLuongHocSinh) {
        this.soLuongHocSinh = soLuongHocSinh;
    }

    public int getMaGiaoVien() {
        return maGiaoVien;
    }

    public void setMaGiaoVien(int maGiaoVien) {
        this.maGiaoVien = maGiaoVien;
    }

    @Override
    public String toString() {
        return "\nLop{" +
                "maLop=" + maLop +
                ", tenLop='" + tenLop + '\'' +
                ", soLuongHocSinh=" + soLuongHocSinh +
                ", maGiaoVien=" + maGiaoVien +
                '}';
    }
}
