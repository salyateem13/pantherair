/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author samir
 */
public class ForgotPass extends Application{
   
    Stage window;
    Scene forgotPassScene;
    
    public static void main(String [] args ){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    
        window = primaryStage;
        window.setTitle("Forgot Password");
        
        
        GridPane  grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap (5);
        grid.setHgap (5);
        
        
        //UserName Label
        Label userNameLabel = new Label("User Name");
        GridPane.setConstraints(userNameLabel, 0, 1);
        
        //UserName INput
        TextField userInput = new TextField("");
        userInput.setPromptText("User Name");
        GridPane.setConstraints(userInput,1,1);
        
        //Forgot password button and action
       Button forgotPassButton = new Button ("Forgot Pass");
       GridPane.setConstraints(forgotPassButton, 1, 3);
       forgotPassButton.setOnAction (event -> {
         
           
           String userName;
           userName= userInput.getText();
           FPSecurityQuestion fpsq = new FPSecurityQuestion(userName);
           fpsq.start(window);
                   
                   
           
       });
       
         grid.getChildren().addAll( userNameLabel, userInput, forgotPassButton);       
      
       
       forgotPassScene = new Scene (grid, 400, 200);
       window.setScene(forgotPassScene);
       window.show();
           
       
    }
    
}
