/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapper;

import java.sql.ResultSet;
import model.NgheSi;

/**
 *
 * @author Administrator
 */
public class NgheSiMapper implements RowMapper<NgheSi>{

    @Override
    public NgheSi Maprow(ResultSet rs) {
        NgheSi ns = new NgheSi();
        try {
            ns.setMaNS(rs.getInt("MaNS"));
            ns.setTenNS(rs.getString("ten"));
            ns.setNgayTao(rs.getTimestamp("ngayTao"));
            ns.setNguoiTao(rs.getString("nguoiTao"));
            ns.setMota(rs.getString("moTa"));
        } catch (Exception e) {
            System.out.println("Exception in class NewMapper");
        }
        return ns;
    }
    
}
