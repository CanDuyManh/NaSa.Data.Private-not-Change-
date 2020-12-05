/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.PlayList;

/**
 *
 * @author Administrator
 */
public class PlayListMapper implements RowMapper<PlayList>{

    @Override
    public PlayList Maprow(ResultSet rs) {
        PlayList pls = new PlayList();
        try {
            pls.setMaPL(rs.getInt("MaPlayList"));
            pls.setMaBH(rs.getInt("MaND"));
            pls.setMaNS(rs.getInt("MaBH"));
        } catch (Exception e) {
            System.out.println("Exception in class NewMapper");
        }
      return pls;
    }
 
}
