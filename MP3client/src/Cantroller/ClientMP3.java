
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cantroller;

/**
 *
 * @author Administrator
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
public class ClientMP3 {
    
    public static void main(String[] args) {
        try {
		InetAddress host = InetAddress.getByName("localhost");
	        Socket socket = null;
	        ObjectOutputStream oos = null;
	        ObjectInputStream ois = null;
	        for(int i=0; i<5;i++){
	            System.out.println(host.getHostName());
	            //establish socket connection to server
	            socket = new Socket("localhost", 9876);
	            //write to socket using ObjectOutputStream
	            oos = new ObjectOutputStream(socket.getOutputStream());
	            System.out.println("Sending request to Socket Server");
	            if(i==4)oos.writeObject("exit");
	            else oos.writeObject(""+i);
	            //read the server response message
	            ois = new ObjectInputStream(socket.getInputStream());
	            String message = (String) ois.readObject();
	            System.out.println("Message: " + message);
	            //close resources
	            ois.close();
	            oos.close();
	            Thread.sleep(100);
	        }
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
