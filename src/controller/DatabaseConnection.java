/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author samir
 */
public class DatabaseConnection {
    
	
    
        public static Statement createConnection() throws SQLException 
                
        {
            try 
            {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PantherAir", "root", "Inshallah2020");
            
            //Create a statement
            Statement statement = con.createStatement();
                
            return statement;
            
                
            }
            catch (SQLException e)
            {
                 System.out.println("failed at creating a connection");
            }
       
           return null;
        }
        
        public static ResultSet getResults (Statement statement, String query) throws SQLException {
           
            try 
             {
            ResultSet  myResult = statement.executeQuery(query);
            return myResult;
             }
        	 catch (SQLException e)
        	 {
        		 System.out.println("failed at getting results");
        	 }
			return null;
        
        }

  
    
}
