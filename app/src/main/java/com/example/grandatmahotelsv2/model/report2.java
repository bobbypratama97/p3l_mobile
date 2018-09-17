package com.example.grandatmahotelsv2.model;

public class report2 {
    String NAMA;
    Integer JUMLAH_RESERVASI;
    Integer TOTAL_PEMBAYARAN;

    public report2(String NAMA, Integer JUMLAH_RESERVASI, Integer TOTAL_PEMBAYARAN) {
        this.NAMA = NAMA;
        this.JUMLAH_RESERVASI = JUMLAH_RESERVASI;
        this.TOTAL_PEMBAYARAN = TOTAL_PEMBAYARAN;
    }

    public String getNAMA() {
        return NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public Integer getJUMLAH_RESERVASI() {
        return JUMLAH_RESERVASI;
    }

    public void setJUMLAH_RESERVASI(Integer JUMLAH_RESERVASI) {
        this.JUMLAH_RESERVASI = JUMLAH_RESERVASI;
    }

    public Integer getTOTAL_PEMBAYARAN() {
        return TOTAL_PEMBAYARAN;
    }

    public void setTOTAL_PEMBAYARAN(Integer TOTAL_PEMBAYARAN) {
        this.TOTAL_PEMBAYARAN = TOTAL_PEMBAYARAN;
    }
}
