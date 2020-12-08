/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.BaiHat;

/**
 *
 * @author Administrator
 */
public class BaiHatMapper implements RowMapper<BaiHat>{
    @Override
    public BaiHat Maprow(ResultSet rs) {
        BaiHat bh = new BaiHat();
        try {
            bh.setMaBH(rs.getInt("MaBH"));
            bh.setTenBH(rs.getString("tenBH"));
            bh.setMaAB(rs.getInt("MaAlbum"));
            bh.setThoiLuong(rs.getInt("thoiLuong"));
            bh.setLyric(rs.getString("lyric"));
            bh.setNgayTao(rs.getTimestamp("ngayTao"));
            bh.setNguoiTao(rs.getString("nguoiTao"));
        } catch (Exception e) {
             System.out.println("Exception in class NewMapper");
        }
        
        return bh;
    }
}
