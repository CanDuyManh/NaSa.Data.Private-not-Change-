/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import mapper.BaiHatMapper;
import model.BaiHat;

/**
 *
 * @author Admin
 */
public class baihatDAO implements dao.GennericDAO<BaiHat>{
    public BaiHat findOne (String sql , Object ... object){
           try {
               return abstractDAO.query(sql,new BaiHatMapper(),object).get(0);   
           } catch (Exception e) {
               return null;
           }
            
        }
      
       public void update(String sql , Object ... object){
           try {
               abstractDAO.update(sql,object);
           } catch (Exception e) {
               System.out.println("Exception in class userDAO");           }
           
       }

    @Override
    public List<BaiHat> findAll(String sql, Object... object) {
       return abstractDAO.query(sql,new BaiHatMapper(),object);   
    }

    @Override
    public void delete(String sql, Object... object) {
        try {
               abstractDAO.update(sql,object);
           } catch (Exception e) {
               System.out.println("Exception in class userDAO");           }
    }

    @Override
    public void insert(String sql, Object... object) {
        try {
               abstractDAO.update(sql,object);
           } catch (Exception e) {
               System.out.println("Exception in class userDAO");           }
    }
}
