/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLCoffeeShop;

/**
 *
 * @author HIEU
 */
public class ChiTietHoaDon {

    private int maHD;
    private int maTA;
    private int maNU;
    private int maBan;
    private int giaTien;

    private String tenSP;
    private int soLuong;
    private int sucChua;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maHD, int maTA, int maNU, int maBan, int giaTien, String tenSP, int soLuong, int sucChua) {
        this.maHD = maHD;
        this.maTA = maTA;
        this.maNU = maNU;
        this.maBan = maBan;
        this.giaTien = giaTien;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
    }

    public ChiTietHoaDon(String tenSP, int soLuong, int giaTien) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public ChiTietHoaDon(String tenSP, int soLuong) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
    }

    public ChiTietHoaDon(int maBan, int sucChua) {
        this.maBan = maBan;
        this.sucChua = sucChua;
    }

    /**
     *
     * @param tenTA
     * @param soLuongTA
     */
    
    
    
    
    
    
    
   
    /**
     * @return the maHD
     */
    public int getMaHD() {
        return maHD;
    }

    /**
     * @param maHD the maHD to set
     */
    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    /**
     * @return the maTA
     */
    public int getMaTA() {
        return maTA;
    }

    /**
     * @param maTA the maTA to set
     */
    public void setMaTA(int maTA) {
        this.maTA = maTA;
    }

    /**
     * @return the maNU
     */
    public int getMaNU() {
        return maNU;
    }

    /**
     * @param maNU the maNU to set
     */
    public void setMaNU(int maNU) {
        this.maNU = maNU;
    }


    /**
     * @return the giaTien
     */
    public int getGiaTien() {
        return giaTien;
    }

    /**
     * @param giaTien the giaTien to set
     */
    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    /**
     * @return the maBan
     */
    public int getMaBan() {
        return maBan;
    }

    /**
     * @param maBan the maBan to set
     */
    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the tenSP
     */
    public String getTenSP() {
        return tenSP;
    }

    /**
     * @param tenSP the tenSP to set
     */
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    /**
     * @return the soLuong
     */
    public int getSoLuong() {
        return soLuong;
    }

    /**
     * @param soLuong the soLuong to set
     */
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

 

}
