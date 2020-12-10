/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.abstractDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import mapper.BaiHatMapper;
import model.BaiHat;

/**
 *
 * @author Administrator
 */
public class SendBaiHat {
    
    
    void sendbh (Socket socket){
        try {
             ObjectMapper mapper = new JsonMapper();
        List<BaiHat> list = abstractDAO.query("select * from BAIHAT",new BaiHatMapper());
            for (BaiHat baiHat : list) {
                baiHat.setTLTG();
            } 
                   toJson tJson = new toJson("",mapper.writeValueAsString(list));   
                    String json = mapper.writeValueAsString(tJson);
                  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject(json);
              oos.close();  
        } catch (Exception e) {
            System.out.println("Exception in sendbh");
        }   
    }
    void sendbh (Socket socket , String tenNs){
        try {
             ObjectMapper mapper = new JsonMapper();
        List<BaiHat> list = abstractDAO.query("select BAIHAT.* from BAIHAT join BAIHAT_NGHESI on BAIHAT.MaBH = BAIHAT_NGHESI.MaBH join NGHESI on BAIHAT_NGHESI.MaNS = NGHESI.MaNS where NGHESI.ten like ?",new BaiHatMapper(),tenNs);
            for (BaiHat baiHat : list) {
                baiHat.setTLTG();
            } 
                   toJson tJson = new toJson("",mapper.writeValueAsString(list));   
                    String json = mapper.writeValueAsString(tJson);
                  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject(json);
              oos.close();  
        } catch (Exception e) {
            System.out.println("Exception in sendbh");
        }   
    }
    
    
}
