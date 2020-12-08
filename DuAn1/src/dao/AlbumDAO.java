/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import DAO.abstractDAO;
import java.util.List;
import mapper.AlbumMapper;
import model.Album;

/**
 *
 * @author Administrator
 */
public class AlbumDAO implements GennericDAO<Album> {

    @Override
    public List<Album> findAll(String sql, Object... object) {
        return abstractDAO.query(sql, new AlbumMapper(), object);
    }

    @Override
    public Album findOne(String sql, Object... object) {
        try {
            return abstractDAO.query(sql, new AlbumMapper(), object).get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void update(String sql, Object... object) {
        try {
            abstractDAO.update(sql, object);
        } catch (Exception e) {
            System.out.println("Exception in class ALbumDAO");
        }
    }

    @Override
    public void delete(String sql, Object... object) {
        try {
            abstractDAO.update(sql, object);
        } catch (Exception e) {
            System.out.println("Exception in class ALbumDAO");
        }
    }

    @Override
    public void insert(String sql, Object... object) {
        try {
            abstractDAO.update(sql, object);
        } catch (Exception e) {
            System.out.println("Exception in class ALbumDAO");
        }
    }

}
