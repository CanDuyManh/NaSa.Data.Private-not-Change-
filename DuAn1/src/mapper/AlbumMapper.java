/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.Album;

/**
 *
 * @author Administrator
 */
public class AlbumMapper implements RowMapper<Album>{

    @Override
    public Album Maprow(ResultSet rs) {
        Album alb = new Album();
        try {
            alb.setMaAB(rs.getInt("MaAlbum"));
            alb.setTenAB(rs.getString("tenAlbum"));
            alb.setNguoiTao(rs.getString("nguoiTao"));
            alb.setNgayTao(rs.getTimestamp("ngayTao"));
        } catch (Exception e) {
            System.out.println("Exception in class NewMapper");
        }
        return alb;
    }
    
}
