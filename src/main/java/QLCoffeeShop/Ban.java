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
public class Ban {

    private int maBan;
    private int sucChua;
    private String tinhTrang;

    //Phương thức khởi tạo Bàn từ CSDL
    public Ban() {
    }

    public Ban(int maBan, int sucChua, String tinhTrang) {
        this.maBan = maBan;
        this.sucChua = sucChua;
        this.tinhTrang = tinhTrang;
    }

    public Ban(int sucChua, String tinhTrang) {
        this.sucChua = sucChua;
        this.tinhTrang = tinhTrang;
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

    /**
     * @return the tinhTrang
     */
    public String getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
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





}
