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
public class NuocUong extends SanPham {

    private String loaiNU;

    public NuocUong() {
    }

    public NuocUong(int maSP, String tenSP, double giaBan, String tinhTrang,
            String thoiDiemBan, String danhMuc, String loaiNU) {
        super(maSP, tenSP, giaBan, tinhTrang, thoiDiemBan, danhMuc);
        this.loaiNU = loaiNU;
    }

    /**
     * @return the loaiNU
     */
    public String getLoaiNU() {
        return loaiNU;
    }

    /**
     * @param loaiNU the loaiNU to set
     */
    public void setLoaiNU(String loaiNU) {
        this.loaiNU = loaiNU;
    }
    
}
