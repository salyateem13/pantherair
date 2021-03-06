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
public class Admin extends User {
    
   
    private SimpleStringProperty userID = new SimpleStringProperty("");
 
     private SimpleStringProperty password = new SimpleStringProperty("");
    private SimpleStringProperty userName = new SimpleStringProperty("");
    private SimpleStringProperty firstName = new SimpleStringProperty("");
     private SimpleStringProperty lastName = new SimpleStringProperty("");
     private SimpleStringProperty address = new SimpleStringProperty("");
     private SimpleStringProperty city = new SimpleStringProperty("");
     private SimpleStringProperty zipField = new SimpleStringProperty("");
     private SimpleStringProperty email = new SimpleStringProperty("");
     private SimpleStringProperty state = new SimpleStringProperty("");
     private SimpleStringProperty securityQuestionID = new SimpleStringProperty("");
      private SimpleStringProperty securityQuestionAnswer = new SimpleStringProperty("");
    private SimpleStringProperty ssn = new SimpleStringProperty("");
    private boolean isAdmin ;
    private int adminCode = 1234;
    
    
    public  Admin()
    {
        super();
    }
    public Admin (String un, String pw, boolean isAdmin)
    {
      setUserName(un);
      setPassword(pw);
      this.isAdmin = isAdmin;
      
      
        
    }
    
    public Admin (String pass, String un, String fn, String ln, String a, String c, String s, String z, String e, String sqi, String sqa, String ssn, boolean isAdmin)
    {
        setPassword(pass);
        setUserName(un);
        setFirstName (fn);
        setLastName (ln);
        setAddress(a);
        setCity(c);
        setState(s);
        setZipField(z);
        setEmail(e);
        setSecurityQuestionID(sqi);
        setSecurityQuestionAnswer(sqa);
        setSsn(ssn);
        this.isAdmin = true;
        
        
        
        
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName.get();
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstname) {
        firstName.set(firstname);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName.get();
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String ln) {
        lastName.set(ln);
    }

    /**
     * @return the addressField
     */
    public String getAddress() {
        return address.get();
    }

    /**
     * @param addressField the addressField to set
     */
    public void setAddress(String af) {
        address.set(af);
    }

    /**
     * @return the cityField
     */
    public String getCity() {
        return city.get();
    }

    /**
     * @param cityField the cityField to set
     */
    public void setCity(String cf) {
        city.set(cf);
    }

    /**
     * @return the zipField
     */
    public String getZipField() {
        return zipField.get();
    }

    /**
     * @param zipField the zipField to set
     */
    public void setZipField(String zf) {
        zipField.set(zf);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email.get();
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String e) {
        email.set(e);
    }

    /**
     * @return the state
     */
    public String getState() {
        return state.get();
    }

    /**
     * @param state the state to set
     */
    public void setState(String s) {
        state.set(s);
    }

    /**
     * @return the securityQuestionID
     */
    public String getSecurityQuestionID() {
        return securityQuestionID.get();
    }

    /**
     * @param securityQuestionID the securityQuestionID to set
     */
    public void setSecurityQuestionID(String sq) {
       securityQuestionID.set(sq);
    }

    /**
     * @return the securityQuestionAnswer
     */
    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer.get();
    }

    /**
     * @param securityQuestionAnswer the securityQuestionAnswer to set
     */
    public void setSecurityQuestionAnswer(String sqa) {
        securityQuestionAnswer.set(sqa);
    }

    /**
     * @return the ssn
     */
    public String getSsn() {
        return ssn.get();
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(String ss) {
        ssn.set(ss);
    }

    /**
     * @return the isAdmin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

   
    
    
}
