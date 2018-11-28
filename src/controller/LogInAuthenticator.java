/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author samir
 */

   

import static controller.DatabaseConnection.*;
import java.sql.ResultSet;
import java.sql.SQLException;




public class LogInAuthenticator {
    
    private String userName;
    private String password;
    
    
    public LogInAuthenticator (String un, String pass)
    {
        this.userName = un;
        this.password = pass;
        
        
    }

    public LogInAuthenticator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public boolean checkCredentials() throws SQLException
    {
        boolean isAuthenticated = false;
        String query = "SELECT Password FROM USER_TABLE WHERE UserName = '" + this.userName + "'";
        
        ResultSet myResults = getResults(createConnection(), query);
        
        //String temp = myResults.getString(1);
        
      while (myResults.next())   
     {
         String temp = myResults.getString("Password");
  
         if (temp == null) 
         {
           isAuthenticated = false;
           return isAuthenticated;
         }
       else if (temp.equals(this.password))
       {
           isAuthenticated = true;
           return isAuthenticated;
       }
       else 
       {
           isAuthenticated = false;
            return isAuthenticated;
       }
       
       //System.out.println(isAuthenticated);
     }
      return isAuthenticated;
      
	
    
   }
    
    
    
    
}


/*
//Execute SQL query
		ResultSet myResult = statement.executeQuery("SELECT * FROM USER_TABLE");
	
		//Process the result set
		try
                {
                     ResultSet myResults = getResults( createConnection(), "SELECT * FROM USER_TABLE");
                
                    while(myResults.next()) {
			System.out.println(myResults.getString("FirstName") + " " + myResults.getString("LastName"));
                        }
		
		
		}
		
                catch(SQLException e)
		{
			e.printStackTrace();
		}
		*/