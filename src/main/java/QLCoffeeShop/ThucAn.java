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
public class ThucAn extends SanPham{
    private String loaiTA;

    public ThucAn() {
    }

    public ThucAn(int maSP, String tenSP, double giaBan, String tinhTrang, 
            String thoiDiemBan, String danhMuc, String loaiTA) {
        super(maSP, tenSP, giaBan, tinhTrang, thoiDiemBan, danhMuc);
        this.loaiTA = loaiTA;
    }
    
    
    
    


    /**
     * @return the loaiTA
     */
    public String getLoaiTA() {
        return loaiTA;
    }

    /**
     * @param loaiTA the loaiTA to set
     */
    public void setLoaiTA(String loaiTA) {
        this.loaiTA = loaiTA;
    }   
}
