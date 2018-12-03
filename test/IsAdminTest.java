
import controller.LogInAuthenticator;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir
 */
public class IsAdminTest {
   
    public static void main (String[] args) throws SQLException
    {
    LogInAuthenticator lia = new LogInAuthenticator("samir" , "1234");
     boolean temp = lia.isAdmin();
     System.out.println(temp);
    }
    
 
   
}
