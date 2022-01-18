package com.abim.perpustakaanapp;

public class Buku {
    private int harga, stok;
    private String kode_buku, kode_lokasi, kategori, judul, penerbit, deskripsi, penulis;

    public Buku(int harga, int stok, String kode_buku, String kode_lokasi, String kategori, String judul, String penerbit, String deskripsi, String penulis) {
        this.harga = harga;
        this.stok = stok;
        this.kode_buku = kode_buku;
        this.kode_lokasi = kode_lokasi;
        this.kategori = kategori;
        this.judul = judul;
        this.penerbit = penerbit;
        this.deskripsi = deskripsi;
        this.penulis = penulis;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public String getKode_buku() {
        return kode_buku;
    }

    public String getKode_lokasi() {
        return kode_lokasi;
    }

    public String getKategori() {
        return kategori;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getPenulis() {
        return penulis;
    }
}
