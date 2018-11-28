
import java.sql.*;
import controller.*;
import static controller.DatabaseConnection.createConnection;
import static controller.DatabaseConnection.getResults;
 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir
 */
public class DatabaseTest {
    
    public static void main(String [] args) throws SQLException
    {
     
    //ResultSet rs =  getResults(createConnection(), "Select * FROM USER_TABLE");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PantherAir", "root", "Inshallah2020");
            
            //Create a statement
        Statement statement = con.createStatement();
        
        ResultSet  myResult = statement.executeQuery( "Select * FROM USER_TABLE WHERE UserName = 'samir'");
        boolean isAuthenticated;
        
        while (myResult.next())   
     {
         String password = myResult.getString("Password");
         System.out.println(password);
         if (password == null) 
           isAuthenticated = false;
       else if (password.equals("124"))
           isAuthenticated = true;
       else 
           isAuthenticated = false;
       
       System.out.println(isAuthenticated);
     }
        
        
    
    
    
    }
    
    
          
    
}
