/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.DataOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
public class sendNhac {
    
    
    public void GuiNhac(Socket socket,String TenBH){
        try {
            Path path = Paths.get("C:/Users/Admin/Desktop/CSDL/CSDL/MP3/"+TenBH);
                byte[] data = Files.readAllBytes(path);
//                
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.write(data);
//                File file = new File("C:/Users/Admin/Desktop/StudyJavaCore/StudyJavaCore/13.mp3");
//                FileInputStream inputStream = new FileInputStream(file);
//                byte[] a = new byte[2048];
//                while (inputStream.read(a) != -1) {
//                    out.write(a);
//                }
                out.flush();
                out.close();
                System.out.println("Da gui");
        
        } catch (Exception e) {
            System.out.println("Exception in gui nhac");
        }
        
        
        
    }
    
}
