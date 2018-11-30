/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DatabaseConnection.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samir
 */
public class ForgotPassValidator {

    private String securityQuestion;
    private String userName;
    private String answer;
    
    public ForgotPassValidator () {
        
    }
    public ForgotPassValidator (String un){
        this.userName = un;
    }
    
    
    
    
    public String  getSecurityQuestion () throws SQLException {
        String query = "SELECT UT.UserID, UserName , SQ.SecurityQuestionID, SecurityQuestion\n" +
"FROM USER_TABLE  UT INNER JOIN SECURITY_QUESTION SQ ON UT.SecurityQuestionID = SQ.SecurityQuestionID\n" +
"GROUP BY UT.UserID, SQ.SecurityQuestionID, SecurityQuestion\n" +
"HAVING UserName = '" + this.userName + "'";
        ResultSet myResults = getResults(createConnection(), query);
        String temp = null;
        while (myResults.next())
        {
            String sq = myResults.getString("SecurityQuestion");
            temp = sq;
        }
        
        return temp;
        
    }
    
    public boolean validateSecurityQuestion() throws SQLException
    {
        String query = "SELECT UT.UserID, UserName , SQ.SecurityQuestionID, SecurityQuestion, SecurityQuestionAnswer\n" +
"FROM USER_TABLE  UT INNER JOIN SECURITY_QUESTION SQ ON UT.SecurityQuestionID = SQ.SecurityQuestionID\n" +
"GROUP BY UT.UserID, SQ.SecurityQuestionID, SecurityQuestion\n" +
"HAVING UserName = '" + this.userName + "'";
        ResultSet myResults = getResults(createConnection(), query);
        String temp = null;
        while (myResults.next())
        {
            String ans = myResults.getString("SecurityQuestionAnswer");
            temp = ans;
        }
        
        if (temp == this.answer)
        {
            return true;
        }
        else
            return false;
    }
    
    public String getPassword() throws SQLException
    {
        String query = "SELECT Password \n" +
    "FROM USER_TABLE\n" +
    "WHERE UserName = '" + this.userName + "'";
        ResultSet myResults = getResults(createConnection(), query);
        String temp = null;
        while (myResults.next())
        {
        String pass = myResults.getString("Password");
        temp = pass;
        }
        return temp;
        
    }
    public void setAnswer(String a)
    {
        this.answer = a;
       
    }
    
}
