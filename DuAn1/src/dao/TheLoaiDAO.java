/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String sql, Object... object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String sql, Object... object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(String sql, Object... object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
