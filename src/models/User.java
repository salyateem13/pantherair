/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author samir
 */
public class User {
    private SimpleStringProperty userName = new SimpleStringProperty("");
    private SimpleStringProperty password = new SimpleStringProperty("");
    private SimpleStringProperty userID = new SimpleStringProperty("");
   
    
    public User ()
    {
        
    }
    
    public User(String un, String pw)
    {
      setUserName(un);
      setPassword(pw);
      
   
      
    }

    /**
     * @return the origin
     */
    public String getUserName() {
        return userName.get();
    }

    /**
     * @param un the origin to set
     */
    public void setUserName(String un) {
        userName.set(un);
    }

    /**
     * @return the destination
     */
    public String getPassword() {
        return password.get();
    }

    /**
     * @param pasword the destination to set
     */
    public void setPassword(String pass) {
        password.set(pass);
    }

    /**
     * @return the depDate
     */
    public String getUserID() {
        return userID.get();
    }

    /**
     * @param uid
     */
    public void setuserID (String uid) {
        userID.set(uid);
        
    }
    
    
}

