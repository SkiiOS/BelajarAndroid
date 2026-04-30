package com.example.belajarandroid;

public class F1Model {
    private String nomor, nama, tahun, detail;
    private int img, pColor;
    private int[] extraColors;

    public F1Model(String nomor, String nama, String tahun, int img, String detail,
                   int pColor, int... extraColors) {
        this.nomor = nomor;
        this.nama = nama;
        this.tahun = tahun;
        this.img = img;
        this.detail = detail;
        this.pColor = pColor;
        this.extraColors = extraColors;
    }

    public String getNomor() { return nomor; }
    public String getNama() { return nama; }
    public String getTahun() { return tahun; }
    public String getDetail() { return detail; }
    public int getImg() { return img; }
    public int getPColor() { return pColor; }
    public int[] getExtraColors() { return extraColors; }
}