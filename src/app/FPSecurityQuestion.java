/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.ForgotPassValidator;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FPSecurityQuestion extends Application {
    
    private String userName;
    Stage window;
    Scene fpsqScene;
    
    
    
    public FPSecurityQuestion (String un){
        this.userName = un;
    }
    
    public static void main(String[] args)
    {
        launch(args);
       
    }
    
    @Override
    public void start (Stage primaryStage) throws SQLException
    {
        window = primaryStage;
        window.setTitle("Recover Password");
        GridPane  grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap (5);
        grid.setHgap (5);
        
        ForgotPassValidator fpv = new ForgotPassValidator (userName);
        
        //Security question label
        Label sqLabel = new Label("Security Question: ");
        GridPane.setConstraints(sqLabel, 0, 1);
        
        //Display security question
        Label sequrityQuestion = new Label(fpv.getSecurityQuestion());
        GridPane.setConstraints(sequrityQuestion, 1, 1);
        
        //Inut for security question answer
         TextField sqInput = new TextField("");
        sqInput.setPromptText("Answer");
        GridPane.setConstraints(sqInput,2,1);
        
        //Get password
       Button getPass = new Button ("Get Password");
       GridPane.setConstraints(getPass, 1, 3);
       getPass.setOnAction (event -> {
            try {
                //on click get pass word and display in alert box
                String answer = sqInput.getText();
                fpv.setAnswer(answer);
                boolean temp = fpv.validateSecurityQuestion();
                
                if(temp == true)
                {
                    AlertMessage.display("Congratulations!", "Here is your password: " + fpv.getPassword());
                }
                else
                    AlertMessage.display("Sorry!", "Your answer is incorrect");
            } catch (SQLException ex) {
                Logger.getLogger(FPSecurityQuestion.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
          
           
       });
       
       grid.getChildren().addAll( sqLabel, sequrityQuestion, getPass, sqInput);       
      
       
       fpsqScene = new Scene (grid, 400, 200);
       window.setScene(fpsqScene);
       window.show();
       
       }
        
    }
    
    
    
    

