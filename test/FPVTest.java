
import controller.ForgotPassValidator;
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
public class FPVTest {
    
    public static void main(String [] args) throws SQLException
    {
        ForgotPassValidator fpv = new ForgotPassValidator("root");
        String temp = fpv.getSecurityQuestion();
        System.out.print(temp);
        
    }
}
