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
public class Album {
    private int MaAB;
    private String TenAB;
    private Timestamp NgayTao;
    private String NguoiTao;

    public int getMaAB() {
        return MaAB;
    }

    public void setMaAB(int MaAB) {
        this.MaAB = MaAB;
    }

    public String getTenAB() {
        return TenAB;
    }

    public void setTenAB(String TenAB) {
        this.TenAB = TenAB;
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
    
}