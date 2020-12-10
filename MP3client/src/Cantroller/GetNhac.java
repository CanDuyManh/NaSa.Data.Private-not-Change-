/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cantroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


/**
 *
 * @author Admin
 */
public class GetNhac {
    public void TaoNhac(String TenBH){
        try {
                       toJson tJson = new toJson("getNhac",TenBH);
        ObjectMapper mapper = new JsonMapper();
        String json = mapper.writeValueAsString(tJson);
                        InetAddress host = InetAddress.getByName("localhost");
            Socket socket = null;
            ObjectOutputStream oos = null;
            ObjectInputStream ois = null;
            System.out.println(host.getHostName());
            //establish socket connection to server
            socket = new Socket("localhost", 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(json);
            
            byte[] by = new byte[500];
            DataInputStream input = new DataInputStream(socket.getInputStream());
            
            File file = new File("C:/Users/Admin/Desktop/test.mp3");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
           
            while (input.read(by) != -1) {
                out.write(by);
               
            }
           
                   } catch (Exception e) {
                       System.out.println("sai");
                   }
               
    }
    
}
