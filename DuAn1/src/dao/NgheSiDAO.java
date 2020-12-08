/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import mapper.NgheSiMapper;
import model.NgheSi;
import DAO.abstractDAO;
/**
 *
 * @author Administrator
 */
public class NgheSiDAO implements GennericDAO<NgheSi>{

    @Override
    public List<NgheSi> findAll(String sql, Object... object) {
         try {
        return DAO.abstractDAO.query(sql,new NgheSiMapper(),object);   
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public NgheSi findOne(String sql, Object... object) {
        try {
            return DAO.abstractDAO.query(sql,new NgheSiMapper(),object).get(0); 
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
