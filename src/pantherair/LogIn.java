/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantherair;

import app.AlertMessage;
import app.Home;
import controller.LogInAuthenticator;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author samir
 */
public class LogIn extends Application {
    
 Stage window;
 Scene loginScene;
    
    
    @Override
    public void start(Stage primaryStage) {
       //initiliaze window and set title
       window = primaryStage;
       window.setTitle("Panther Air");
       
       
       Label logInLabel;
       logInLabel = new Label("Welcome to Panther Air");
        
        GridPane  grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap (5);
        grid.setHgap (5);
        
        
        //UserName Label
        Label userNameLabel = new Label("User Name");
        GridPane.setConstraints(userNameLabel, 0, 0);
        
        //UserName INput
        TextField userInput = new TextField("");
        userInput.setPromptText("User Name");
        GridPane.setConstraints(userInput,1,0);
       
        
        //Password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 1);
        
        //Password input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput,1,1);
   
       
       //login button and action
       Button logInButton = new Button ("Log In");
       GridPane.setConstraints(logInButton, 1, 2);
       logInButton.setOnAction (event -> {
               
           
           
               
               try {
                   LogInAuthenticator lia = new LogInAuthenticator (userInput.getText(), passInput.getText());
                   boolean temp = lia.checkCredentials();
                   System.out.println("User authenticated is" + temp);
                   if (temp == true)
                   {
                       Home homePage = new Home();
                       homePage.start(window);
                   }
                   else if (temp == true)
                   {
                       AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");                    
                   }
                   
                   else
                       AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");
                   
               } catch (SQLException ex) {
                   Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
               
               } catch (Exception ex) {
                   Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
               }
           
       });
       
        //signup button and sction
       Button signUpButton = new Button ("Sign Up");
       GridPane.setConstraints(signUpButton, 2, 2);
       //signUpButton.setOnAction(e-> );
       
       //forgot password button
       Button forgotPass = new Button ("Forgot Password");
       GridPane.setConstraints(forgotPass, 1,3);
     
       
       
       
       grid.getChildren().addAll(userNameLabel, userInput, passLabel, passInput, logInButton, signUpButton, forgotPass);       
      
       
       loginScene = new Scene (grid, 300, 200);
       window.setScene(loginScene);
       window.show();
       
       
       
       
       
       
       
    }

    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
