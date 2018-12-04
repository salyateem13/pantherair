/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forums;


import app.AlertMessage;
import app.AuthHome;
import app.Home;
import app.AdminHome;
import controller.GetUserData;
import controller.LogInAuthenticator;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Admin;
import models.User;

/**
 *
 * @author samir
 */
public class LogInForm extends Application {
    
 Stage window;
 Scene loginScene;
 private static boolean isAuth = false;
  private static boolean isAdmin = false;
    
    @Override
    public void start(Stage primaryStage) {
         Stage window = new Stage();
       window.setTitle("Panther Air LogIn");
       
       
       Label logInLabel;
       logInLabel = new Label("Welcome to Panther Air");
        
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
       
        
        //Password label
        Label passLabel = new Label("Password");
        GridPane.setConstraints(passLabel, 0, 2);
        
        //Password input
        PasswordField passInput = new PasswordField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput,1,2);
   
        
       //go back home button
  
       Button goHomeButton = new Button ("Home");
       GridPane.setConstraints(goHomeButton, 0,3);
       goHomeButton.setOnAction(e->{
           
             try {
                 Home home = new Home ();
                 home.start(window);
             } catch (Exception ex) {
                 Logger.getLogger(LogInForm.class.getName()).log(Level.SEVERE, null, ex);
             }
       });
       
       //login button and action
       Button logInButton = new Button ("Log In");
       GridPane.setConstraints(logInButton, 1, 3);
       logInButton.setOnAction (event -> {
               
           
           
               
               try {
                   
                   
                   
                   LogInAuthenticator lia = new LogInAuthenticator (userInput.getText(), passInput.getText());
                   isAuth = lia.checkCredentials();
                   isAdmin = lia.isAdmin();
                   System.out.print(isAuth);
                   System.out.print(isAdmin);
                   if (isAuth == true)
                   {
                       if(isAdmin ==true)
                       {
                       Admin thisAdmin = new Admin  (userInput.getText(), passInput.getText(), true);
                       GetUserData gud = new GetUserData();
                        int uID= gud.getUserID(thisAdmin);
                        thisAdmin.setuserID(Integer.toString(uID));
                       AdminHome ah = new AdminHome();
                       ah.setThisAdmin(thisAdmin);
                       ah.start(window);
                       }
                       else if(isAdmin == false)
                       {
                       User thisUser = new User();
                       GetUserData gud = new GetUserData();
                        int uID= gud.getUserID(thisUser);
                            thisUser.setuserID(Integer.toString(uID));
                       AuthHome ah = new AuthHome();
                       ah.setThisUser(thisUser);
                       ah.start(window);
                       }
                       
                       /*
                       if (isAdmin == true){
                       //on login, change the menubar 
                           
                           
                           AdminHome adminHomePage = new AdminHome();
                        adminHomePage.start(window);
                       } else {
                       Home homePage = new Home();
                       homePage.start(window);
                       userInput.getText(), passInput.getText()
                       }

                       */
                       
                       
                        
                       
                   }
                   else if (isAuth == false)
                   {
                       lia.setAuth(false);
                       AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");  
                       Home home = new Home();
                       home.start(window);
                   }
                   
                   else
                       AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");
                    //Home home = new Home();
                       //home.start(window);
                   
               } catch (SQLException ex) {
                   Logger.getLogger(LogInForm.class.getName()).log(Level.SEVERE, null, ex);
               
               } catch (Exception ex) {
                   Logger.getLogger(LogInForm.class.getName()).log(Level.SEVERE, null, ex);
               }
           
       });
       
       
       //forgot password button
       Button forgotPass = new Button ("Forgot Password");
       GridPane.setConstraints(forgotPass, 1,4);
       forgotPass.setOnAction(e->{
           ForgotPass forgotPassScene = new ForgotPass();
           forgotPassScene.start(window);
       });
       
       
       
       grid.getChildren().addAll(logInLabel, userNameLabel, userInput, passLabel, passInput, logInButton, forgotPass, goHomeButton);       
      
       
       Scene loginScene = new Scene (grid, 400, 200);
       window.setScene(loginScene);
       window.show();
            
        
       
    }


    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public boolean getIsAuth(){
        return this.isAuth;
    }
    
    public boolean getIsAdmin (){
        return this.isAdmin;
    }
}
