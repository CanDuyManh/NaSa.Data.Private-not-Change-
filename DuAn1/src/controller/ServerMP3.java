/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.abstractDAO;
import DAO.baihatDAO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import mapper.BaiHatMapper;
import model.BaiHat;

/**
 *
 * @author Administrator
 */
public class ServerMP3 {
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println(message);
              ObjectMapper mapper = new JsonMapper();
 
            JsonNode jsonNode = mapper.readTree(message);
             String type = jsonNode.get("type").asText();
              String data = "";
             try {
                data  = jsonNode.get("data").asText();
            } catch (Exception e) {
            }
             
             System.out.println(type);
             if (type.equalsIgnoreCase("getBaiHat")) {
                 new SendBaiHat().sendbh(socket);    
            }else  if (type.equalsIgnoreCase("getNhac")) {
                 new sendNhac().GuiNhac(socket,data);    
            }else  if (type.equalsIgnoreCase("getNgheSi")) {
                 new SendNgheSi().sendNS(socket);    
            }else  if (type.equalsIgnoreCase("getBaiHatNS")) {
                 new SendBaiHat().sendbh(socket,data);   
            }
            
            //create ObjectOutputStream object
          
            //close resources
            ois.close();
          
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
    
}
