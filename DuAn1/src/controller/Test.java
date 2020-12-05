/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.ArrayList;
import java.util.List;
import model.BaiHat;

/**
 *
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        ObjectMapper mapper = new JsonMapper();
       
        BaiHat bh = new BaiHat();
        bh.setTenBH("xx");
        BaiHat bh2 = new BaiHat();
        bh2.setTenBH("xx22");
        BaiHat bh3 = new BaiHat();
        bh3.setTenBH("xx3");
        List<BaiHat> list = new ArrayList<>();
        list.add(bh);
        list.add(bh2);
        list.add(bh3);
        
        try {
            
            String json = mapper.writeValueAsString(list);
            toJson toJson1 = new toJson("post",json);
            
            String json2 = mapper.writeValueAsString(toJson1);
            
            System.out.println(json2);
            
            JsonNode jsonNode = mapper.readTree(json2);
            String data = jsonNode.get("data").asText();
            String TenBH = jsonNode.get("type").asText();
            
               System.out.println(TenBH);
              
               List<BaiHat> participantJsonList = mapper.readValue(data, new TypeReference<List<BaiHat>>(){});
               
               for (BaiHat baiHat : participantJsonList) {
                   System.out.println(baiHat.getTenBH());
            }
               System.out.println(bh2.getTenBH());
         
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
 
}
