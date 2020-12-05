/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class TaiKhoan {
    private int MaND;
    private String TaiKhoan;
    private String MatKhau;
    private String TenND;
    private boolean GioiTinh;
    private String Email;
    private String Anh;
    private boolean VaiTro;

    public int getMaND() {
        return MaND;
    }

    public void setMaND(int MaND) {
        this.MaND = MaND;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getTenND() {
        return TenND;
    }

    public void setTenND(String TenND) {
        this.TenND = TenND;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAnh() {
        return Anh;
    }
    public String getGioiTinh() {
        return this.GioiTinh?"Nữ":"Nam";
    }
    public String getVaiTro() {
        return this.VaiTro?"admin":"user";
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public boolean isVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(boolean VaiTro) {
        this.VaiTro = VaiTro;
    }
    
}
