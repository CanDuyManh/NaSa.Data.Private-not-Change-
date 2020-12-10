/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untility;

import model.TaiKhoan;

/**
 *
 * @author Admin
 */
public class accout {
    public static TaiKhoan acc = null;
    
    
    
    public static void OnTk(TaiKhoan a){
        acc = a;
    
    }
     public static void OffTk(){
       acc = null;
    }
}
