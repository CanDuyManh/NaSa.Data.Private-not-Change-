/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package untility;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author Sieu Nhan Bay
 */
public class shareHelper {
 /**
 * Ảnh biểu tượng của ứng dụng, xuất hiện trên mọi cửa sổ
 */
 
 public static boolean saveLogo(File file){
     File dir = new File("data");  //khai báo thư mục logos ngang hàng với src
     // Tạo thư mục nếu chưa tồn tại
     if(!dir.exists()){
        dir.mkdirs();
     }
     File newFile = new File(dir, file.getName());
     try {
         // Copy vào thư mục logos (đè nếu đã tồn tại)
         Path source = Paths.get(file.getAbsolutePath());
         Path destination = Paths.get(newFile.getAbsolutePath());
         Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
         return true;
     }
     catch (Exception ex) {
        return false;
     }
 }
 /**
 * Đọc hình ảnh logo chuyên đề trong thư mục logos theo tenFile
 * @param fileName là tên file logo
 * @return ImageIcon ảnh đọc được
 */
 public static ImageIcon readLogo(String fileName){
    File path = new File("logos", fileName);
    return new ImageIcon(new ImageIcon(path.getAbsolutePath()).getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT));
 }

 
}

