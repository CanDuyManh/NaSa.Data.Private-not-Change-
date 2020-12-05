/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.RowMapper;

/**
 *
 * @author Admin
 */
public class abstractDAO {
    
     public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    public static String dburl="jdbc:sqlserver://localhost:1433;databaseName=mp3Poly";
    public static String username="sa";
    public static String password="123";
    
    //nạp driver
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            
        }
    }
    
    
   public static Connection getConnection (){
        try {
             Connection con=DriverManager.getConnection(dburl, username, password); 
             return con;
        } catch (Exception e) {
            System.out.println("sai");
            return null;
        }   
    }
    public static <T> List<T> query(String sql,RowMapper<T> mapper,Object...args){
        List<T> results = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement statement = null;
	ResultSet resultSet = null;
        
        if(con != null) {
			try {
				statement = con.prepareStatement(sql);	
				setParameter(statement,args);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					results.add(mapper.Maprow(resultSet));	
				}
				return results;
				
			} catch (Exception e) {
				System.out.println("Sai statement or resultSet  (MS:02)");
				return null;
			}finally {
				try {
					if(con != null) {
						con.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
			} catch (Exception e2) {
				return null;
			}			
			}
		}
		return null;
    }
    public static void update(String sql,Object...args){
        Connection connection = getConnection();
	PreparedStatement statement = null;
        try {
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement,args);
			statement.executeUpdate();
			connection.commit();
			
		} catch (Exception e) {
			System.out.println(" Exception in funtion void update");
			try {
				connection.rollback();
			} catch (Exception e2) {
				System.out.println(" Exception in funtion void update in rollback");
			}
			
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				
		} catch (Exception e2) {
		
		}			
		}
        
        
  
    }
    public static void setParameter(PreparedStatement statement , Object... object){
        try {
            for (int i = 0 ; i < object.length;i++ ) {
                   statement.setObject(i+1, object[i]);
                }
        } catch (Exception e) {
            System.out.println(" Exception in setParameter");
        } 
    }  
}
