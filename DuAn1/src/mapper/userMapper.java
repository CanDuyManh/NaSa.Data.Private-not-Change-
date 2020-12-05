/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.TaiKhoan;

/**
 *
 * @author Administrator
 */
public class userMapper implements RowMapper<TaiKhoan>{

    @Override
    public TaiKhoan Maprow(ResultSet rs) {
        TaiKhoan tk = new TaiKhoan();
        try {
            tk.setMaND(rs.getInt("MaND"));
            tk.setTaiKhoan(rs.getString("taiKhoan"));
            tk.setMatKhau(rs.getString("matKhau"));
            tk.setTenND(rs.getString("ten"));
            tk.setEmail(rs.getString("Email"));
            tk.setGioiTinh(rs.getBoolean("gioiTinh"));
            tk.setVaiTro(rs.getBoolean("VaiTro"
                    + ""));
        } catch (Exception e) {
            System.out.println("Exception in class NewMapper");
        }
        return tk;
    }
    
}
