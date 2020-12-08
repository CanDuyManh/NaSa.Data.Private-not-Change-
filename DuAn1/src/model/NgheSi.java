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
public class NgheSi {
    private int MaNS;
    private String TenNS;
    private String Mota;
    private Timestamp NgayTao;
    private String NguoiTao;

    public int getMaNS() {
        return MaNS;
    }

    public void setMaNS(int MaNS) {
        this.MaNS = MaNS;
    }

    public String getTenNS() {
        return TenNS;
    }

    public void setTenNS(String TenNS) {
        this.TenNS = TenNS;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
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
        return this.TenNS;
    }
    
    
}
