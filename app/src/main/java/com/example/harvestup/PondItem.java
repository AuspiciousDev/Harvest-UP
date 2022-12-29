package com.example.harvestup;

public class PondItem {

    private String iPondLayout;
    private int iPondImage;

    public PondItem(String pondLayout, int pondImage) {
        iPondLayout = pondLayout;
        iPondImage = pondImage;
    }

    public String getiPondLayout() {
        return iPondLayout;
    }

    public void setiPondLayout(String iPondLayout) {
        this.iPondLayout = iPondLayout;
    }

    public int getiPondImage() {
        return iPondImage;
    }

    public void setiPondImage(int iPondImage) {
        this.iPondImage = iPondImage;
    }
}
