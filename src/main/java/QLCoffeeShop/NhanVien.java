/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLCoffeeShop;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author HIEU
 */
public class NhanVien {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private int maNV;
    private String hotenNV;
    private String gioiTinh;
    private String queQuan;
    private Date ngaySinh;
    private Date ngayVaoLam;
    private int boPhan;

    //Phương thức khởi tạo nhân viên từ CSDL
    public NhanVien() {
    }

    public NhanVien(int maNV, String hotenNV, String gioiTinh, String queQuan, Date ngaySinh, Date ngayVaoLam, int boPhan) {
        this.maNV = maNV;
        this.hotenNV = hotenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
        this.boPhan = boPhan;
    }

    public NhanVien(String hotenNV, String gioiTinh, String queQuan, String ngaySinh, String ngayVaoLam, int boPhan) throws ParseException {
        this.hotenNV = hotenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.ngaySinh = (Date) df.parse(ngaySinh);
        this.ngayVaoLam = (Date) df.parse(ngayVaoLam);
        this.boPhan = boPhan;
    }

    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }



    int setMaNV() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the hotenNV
     */
    public String getHotenNV() {
        return hotenNV;
    }

    /**
     * @param hotenNV the hotenNV to set
     */
    public void setHotenNV(String hotenNV) {
        this.hotenNV = hotenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @return the boPhan
     */
    public int getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(int boPhan) {
        this.boPhan = boPhan;
    }

}
