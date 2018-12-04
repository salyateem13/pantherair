/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DatabaseConnection.createConnection;
import static controller.DatabaseConnection.getPrepareStatement;
import static controller.DatabaseConnection.getResults;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Admin;
import models.User;

/**
 *
 * @author samir
 */
public class SetUserData {
    
    public void addAdmin (Admin a) throws SQLException
    {
        String query = "INSERT INTO USER_TABLE( Password, UserName, FirstName, LastName,AdddressLine1, City,State, ZipCode, Email, SecurityQuestionID,SecurityQuestionAnswer, SSN, isAdmin)\n" +
                                                    "VALUES (?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?)";
      
        
        PreparedStatement  preparedStmt = getPrepareStatement(query);
        preparedStmt.setString(1, a.getPassword());
        preparedStmt.setString(2, a.getUserName());
        preparedStmt.setString(3, a.getFirstName());
        preparedStmt.setString(4, a.getLastName());
        preparedStmt.setString(5, a.getAddress());
        preparedStmt.setString(6, a.getCity());
        preparedStmt.setString(7, a.getState());
        preparedStmt.setInt(8, Integer.parseInt(a.getZipField()));
        preparedStmt.setString(9, a.getEmail());
        preparedStmt.setString(10, a.getSecurityQuestionID());
        preparedStmt.setString(11, a.getSecurityQuestionAnswer());
        preparedStmt.setInt(12, Integer.parseInt(a.getSsn()));
        preparedStmt.setBoolean(13, a.isIsAdmin());
        
        preparedStmt.execute();
        
        preparedStmt.close();
        
    }
    
    public void addUser (User a) throws SQLException
    {
        String query = "INSERT INTO USER_TABLE( Password, UserName, FirstName, LastName,AdddressLine1, City,State, ZipCode, Email, SecurityQuestionID,SecurityQuestionAnswer, SSN, isAdmin)\n" +
                                                    "VALUES (?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?)";
      
        
        PreparedStatement  preparedStmt = getPrepareStatement(query);
        preparedStmt.setString(1, a.getPassword());
        preparedStmt.setString(2, a.getUserName());
        preparedStmt.setString(3, a.getFirstName());
        preparedStmt.setString(4, a.getLastName());
        preparedStmt.setString(5, a.getAddressField());
        preparedStmt.setString(6, a.getCityField());
        preparedStmt.setString(7, a.getState());
        preparedStmt.setInt(8, Integer.parseInt(a.getZipField()));
        preparedStmt.setString(9, a.getEmail());
        preparedStmt.setString(10, a.getSecurityQuestionID());
        preparedStmt.setString(11, a.getSecurityQuestionAnswer());
        preparedStmt.setInt(12, Integer.parseInt(a.getSsn()));
        preparedStmt.setBoolean(13, false);
        
        preparedStmt.execute();
        
        preparedStmt.close();
        
    }
    
}
