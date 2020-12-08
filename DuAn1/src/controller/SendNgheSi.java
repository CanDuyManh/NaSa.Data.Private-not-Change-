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
import mapper.NgheSiMapper;
import model.BaiHat;
import model.NgheSi;

/**
 *
 * @author Admin
 */
public class SendNgheSi {
    void sendNS (Socket socket){
        try {
             ObjectMapper mapper = new JsonMapper();
        List<NgheSi> list = abstractDAO.query("select * from NGHESI",new NgheSiMapper());
              
                   toJson tJson = new toJson("",mapper.writeValueAsString(list));
                  
                    String json = mapper.writeValueAsString(tJson);
                  ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject(json);
              oos.close();
        
        } catch (Exception e) {
            System.out.println("Exception in sendNS");
        }
        
        
        
    }
}
