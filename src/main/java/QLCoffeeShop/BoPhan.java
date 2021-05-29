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
public class BoPhan {
    private static int demMaBP;
    private int maBP;
    private String tenBP;

    public BoPhan(int maBP, String tenBP) {
        this.maBP = maBP;
        this.tenBP = tenBP;
    }

    /**
     * @return the demMaBP
     */
    public static int getDemMaBP() {
        return demMaBP;
    }

    /**
     * @param aDemMaBP the demMaBP to set
     */
    public static void setDemMaBP(int aDemMaBP) {
        demMaBP = aDemMaBP;
    }

    /**
     * @return the maBP
     */
    public int getMaBP() {
        return maBP;
    }

    /**
     * @param maBP the maBP to set
     */
    public void setMaBP(int maBP) {
        this.maBP = maBP;
    }

    /**
     * @return the tenBP
     */
    public String getTenBP() {
        return tenBP;
    }

    /**
     * @param tenBP the tenBP to set
     */
    public void setTenBP(String tenBP) {
        this.tenBP = tenBP;
    }
    
    
}
