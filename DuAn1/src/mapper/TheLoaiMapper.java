/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.TheLoai;

/**
 *
 * @author Administrator
 */
public class TheLoaiMapper implements RowMapper<TheLoai>{

    @Override
    public TheLoai Maprow(ResultSet rs) {
      TheLoai tl = new TheLoai();
        try {
            tl.setMaTL(rs.getInt("MaTL"));
            tl.setTenTL(rs.getString("tenTL"));
            tl.setNgayTao(rs.getTimestamp("ngayTao"));
            tl.setNguoiTao(rs.getString("nguoiTao"));
        } catch (Exception e) {
            System.out.println("Exception in class NewMapper");
        }
        
        return tl;
        
    }
    
}
