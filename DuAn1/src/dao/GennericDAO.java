/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface GennericDAO <T>{
    
    List<T> findAll(String sql ,Object ... object);
    T findOne(String sql ,Object ... object);
    void update(String sql ,Object ... object);
    void delete(String sql ,Object ... object);
    void insert(String sql ,Object ... object);
    
    
    
}
