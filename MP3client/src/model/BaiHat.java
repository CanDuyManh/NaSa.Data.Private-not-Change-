/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author Admin
 */
public class BaiHat {
    private int MaBH;
    private String TenBH;
    private int MaAB;
    private int ThoiLuong;
    private String Lyric;
    private Timestamp NgayTao;
    private String NguoiTao;
    private String CaSi;
    private String TheLoai;

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }
    
    public String getCaSi() {
        return CaSi;
    }

    public void setCaSi(String CaSi) {
        this.CaSi = CaSi;
    }

    public int getMaBH() {
        return MaBH;
    }

    public void setMaBH(int MaBH) {
        this.MaBH = MaBH;
    }

    public String getTenBH() {
        return TenBH;
    }

    public void setTenBH(String TenBH) {
        this.TenBH = TenBH;
    }

    public int getMaAB() {
        return MaAB;
    }

    public void setMaAB(int MaAB) {
        this.MaAB = MaAB;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public String getLyric() {
        return Lyric;
    }

    public void setLyric(String Lyric) {
        this.Lyric = Lyric;
    }

    public Timestamp getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Timestamp NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNguoiTao() {
        return NguoiTao;
    }

    public void setNguoiTao(String NguoiTao) {
        this.NguoiTao = NguoiTao;
    }

    @Override
    public String toString() {
        return "BaiHat{" + "MaBH=" + MaBH + ", TenBH=" + TenBH + ", MaAB=" + MaAB + ", ThoiLuong=" + ThoiLuong + ", Lyric=" + Lyric + ", NgayTao=" + NgayTao + ", NguoiTao=" + NguoiTao + '}';
    }
    
}
