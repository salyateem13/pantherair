/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.FlightSelector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samir
 */
public class DatabaseConnection {
    
	
    
        public static Statement createConnection() throws SQLException 
                
        {
            try 
            {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/panther_air", "root", "Inshallah2020");
            
            //Create a statement
            Statement statement = con.createStatement();
                
            return statement;
            
                
            }
            catch (SQLException e)
            {
                 Logger.getLogger(FlightSelector.class.getName()).log(Level.SEVERE, null, e);
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
        
        public static PreparedStatement getPrepareStatement(String query) throws SQLException 
        {
            try 
            {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/panther_air", "root", "Inshallah2020");
            
            //Create a statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
                
            return preparedStmt;
            
                
            }
            catch (SQLException e)
            {
                  Logger.getLogger(FlightSelector.class.getName()).log(Level.SEVERE, null, e);
            }
       
           return null;
        }
  
    
}
