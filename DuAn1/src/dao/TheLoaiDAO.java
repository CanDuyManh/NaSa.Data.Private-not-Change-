/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DAO.abstractDAO;
import java.util.List;
import mapper.TheLoaiMapper;
import model.TheLoai;

/**
 *
 * @author Administrator
 */
public class TheLoaiDAO implements  GennericDAO<TheLoai>{

    @Override
    public List<TheLoai> findAll(String sql, Object... object) {
        return DAO.abstractDAO.query(sql,new TheLoaiMapper(),object);   
    }

    @Override
    public TheLoai findOne(String sql, Object... object) {
       try {
               return abstractDAO.query(sql,new TheLoaiMapper(),object).get(0);   
           } catch (Exception e) {
               return null;
           }
    }

    @Override
    public void update(String sql, Object... object) {
        try {
               DAO.abstractDAO.update(sql,object);
           } catch (Exception e) {
               System.out.println("Exception in class userDAO");           
           }
    }

    @Override
    public void delete(String sql, Object... object) {
        try {
               DAO.abstractDAO.update(sql,object);
           } catch (Exception e) {
               System.out.println("Exception in class userDAO");           
           }
    }

    @Override
    public void insert(String sql, Object... object) {
        try {
               DAO.abstractDAO.update(sql,object);
           } catch (Exception e) {
               System.out.println("Exception in class userDAO");           
           }
    }
    
}
