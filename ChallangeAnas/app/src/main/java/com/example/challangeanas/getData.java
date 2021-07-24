package com.example.challangeanas;

import java.io.Serializable;

public class getData implements Serializable {
    String penulis, judul, deskripsi, link, imglink, terbit, isi;
    boolean favorit;

    /*getData(String penulis, String judul, String deskripsi, String link, String imglink, String terbit, String isi) {
        this.penulis = penulis;
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.link = link;
        this.imglink = imglink;
        this.terbit = terbit;
        this.isi = isi;
    }*/

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public String getTerbit() {
        return terbit;
    }

    public void setTerbit(String terbit) {
        this.terbit = terbit;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public boolean getFavorit() {
        return favorit;
    }

    public void setFavorit(boolean favorit) {
        this.favorit = favorit;
    }

}
