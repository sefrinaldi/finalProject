package com.sefrinaldi.finaljavabe.database.model;

public class Prabayar {

    private int id;
    private int orderId;
    private String name;
    private String alamat;
    private int daya;
    private int token;
    private String status;

    public Prabayar(int id, int orderId, String name, String alamat, int daya, int token, String status) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.alamat = alamat;
        this.daya = daya;
        this.token = token;
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public void setToken(int token) {
        this.token = token;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
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

    public int getToken() {
        return token;
    }

    public String getStatus() {
        return status;
    }
}
