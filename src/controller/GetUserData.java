/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DatabaseConnection.createConnection;
import static controller.DatabaseConnection.getResults;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.User;

/**
 *
 * @author samir
 */
public class GetUserData {
    
    public int getUserID(User u) throws SQLException
    {
        String query = "Select UserID\n" +
            "From USER_TABLE\n" +
        "where UserName = '"+ u.getUserName() +"';";
        ResultSet myResults = getResults(createConnection(), query);
        int userId =0;

          
      while (myResults.next())   
     {
          userId = Integer.parseInt(myResults.getString("UserID")); 
     }
      return userId;
    }
    
   
}
