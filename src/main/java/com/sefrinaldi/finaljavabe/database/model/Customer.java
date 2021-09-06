package com.sefrinaldi.finaljavabe.database.model;

public class Customer {

    private int id;
    private String name;
    private String alamat;
    private int daya;
    private String layanan;
    private String noTelp;
    private String email;
    private String bulan;
    private int tahun;
    private int tagihan;
    private String status;

    public Customer() {
    }

    public Customer(int id, String name,
                    String alamat,
                    int daya,
                    String layanan,
                    String noTelp,
                    String email,
                    String bulan,
                    int tahun,
                    int tagihan,
                    String status) {
        this.id = id;
        this.name = name;
        this.alamat = alamat;
        this.daya = daya;
        this.layanan = layanan;
        this.noTelp = noTelp;
        this.email = email;
        this.bulan = bulan;
        this.tahun = tahun;
        this.tagihan = tagihan;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setDaya(int daya) {
        this.daya = daya;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setTagihan(int tagihan) {
        this.tagihan = tagihan;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getDaya() {
        return daya;
    }

    public String getLayanan() {
        return layanan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getEmail() {
        return email;
    }

    public String getBulan() {
        return bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public int getTagihan() {
        return tagihan;
    }

    public String getStatus() {
        return status;
    }
}
