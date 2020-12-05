/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untility;


import mapper.NgheSiMapper;
import mapper.TheLoaiMapper;
import dao.AlbumDAO;
import javax.swing.JOptionPane;
import mapper.AlbumMapper;

/**
 *
 * @author Administrator
 */
public class ValidateUnility {
    AlbumDAO aldao = new AlbumDAO();
    public static boolean CheckNgheSi(String name) {
        try {
            String[] arr = name.split(",");
            for (int i = 0; i < arr.length; i++) {
                String string = arr[i];
                DAO.abstractDAO.query("select * from NGHESI where ten = ?",new NgheSiMapper(),string).get(0);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean CheckTheLoai(String name) {
        try {
            String[] arr = name.split(",");
            for (int i = 0; i < arr.length; i++) {
                String string = arr[i];
                DAO.abstractDAO.query("select * from THELOAI where tenTL = ?",new TheLoaiMapper(),string).get(0);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean CheckMaAlbum(String id){
        try {
                DAO.abstractDAO.query("select * from ALBUM where MaAlbum = ?",new AlbumMapper(),id).get(0);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
