package com.example.wika.historyindoid.models;

public class Aturan {
    private String no;
    private String teks;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getTeks() {
        return teks;
    }

    public void setTeks(String teks) {
        this.teks = teks;
    }

    public Aturan(String no, String text) {
        this.no = no;
        this.teks = teks;
    }
}

