/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 *
 * @author samir
 */
public class FPSecurityQuestion extends Application {
    
    private String userName;
    Stage window;
    
    
    public FPSecurityQuestion (String un){
        this.userName = un;
    }
    
    public static void main(String[] args)
    {
        launch(args);
       
    }
    
    @Override
    public void start (Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Recover Password");
        
    }
    
    
    
    
}
