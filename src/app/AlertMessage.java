/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.FlightSearch;
import controller.LogInAuthenticator;
import controller.FlightSearch;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Flight;
import models.User;

/**
 *
 * @author samir
 */



public class AlertMessage {

    static boolean displaySignUpNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Stage window;
    Scene loginScene;
    private TableView tableview;
    static boolean isAuthenticated = false;
    private static boolean isAdmin = false;
    User thisUser;
  
	public static void display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Text txt= new Text(message);
		txt.setTextAlignment(TextAlignment.CENTER);
		
		Button b1= new Button("Okay");
		b1.setOnAction(e ->{
			window.close();
		});
		VBox layout= new VBox(10);
		layout.getChildren().addAll(txt,b1);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene= new Scene(layout,500,125);
		window.setScene(scene);
		window.showAndWait();	
	}
        
        public static boolean displayNode()
        {
            Stage window = new Stage();
       window.setTitle("Panther Air");
       
       
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
   
       
       //login button and action
       Button logInButton = new Button ("Log In");
       GridPane.setConstraints(logInButton, 1, 3);
       logInButton.setOnAction (event -> {
               
           
           
               
             
               
                try {
                    LogInAuthenticator lia = new LogInAuthenticator (userInput.getText(), passInput.getText());
                    isAuthenticated = lia.checkCredentials();
                    boolean isAdmin = lia.isAdmin();
                    System.out.println("LIA.isAdmin is " + isAdmin);
                    
                    
                    if (isAdmin ==false){
                    AuthHome ah = new AuthHome();
                    ah.start(window);
                    } else if (isAdmin == true){
                       AdminHome adminHomePage = new AdminHome();
                        adminHomePage.start(window);
                    }
                 
                   // Stage stage = (Stage) logInButton.getScene().getWindow();
                    //stage.close();
                    /*
                    if (isAuthenticated == true)
                    {
                    lia.setAuth(true);
                    
                    // super.setIsAuth(true);
                    
                    if (isAdmin == true){
                    //on login, change the menubar
                    
                    
                    AdminHome adminHomePage = new AdminHome();
                    adminHomePage.start(window);
                    } else {
                    Home homePage = new Home();
                    homePage.start(window);
                    }
                    
                    
                    Stage stage = (Stage) logInButton.getScene().getWindow();
                    stage.close();
                    }
                    else if (isAuthenticated == false)
                    {
                    lia.setAuth(false);
                    AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");
                    }
                    
                    else
                    AlertMessage.display("Incorrect Login", "Username or password is incorrect. Please try again");
                    } catch (SQLException ex) {
                    Logger.getLogger(AlertMessage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                */ } catch (SQLException ex) {
                    Logger.getLogger(AlertMessage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(AlertMessage.class.getName()).log(Level.SEVERE, null, ex);
                }
           
       });
       
       
       //forgot password button
       Button forgotPass = new Button ("Forgot Password");
       GridPane.setConstraints(forgotPass, 0,3);
       forgotPass.setOnAction(e->{
           ForgotPass forgotPassScene = new ForgotPass();
           forgotPassScene.start(window);
       });
       
       grid.getChildren().addAll(logInLabel, userNameLabel, userInput, passLabel, passInput, logInButton, forgotPass);       
      
       
       Scene loginScene = new Scene (grid, 400, 200);
       window.setScene(loginScene);
       window.show();
       
       return isAuthenticated;
       
        }
            
        public static boolean getIsAuth(){
        return isAuthenticated;
    }
    
    public boolean getIsAdmin (){
        return this.isAdmin;
    }
       
    public  void setIsAuth(boolean b){
         this.isAuthenticated = b;
    }
    
    public void setIsAdmin (boolean b){
         this.isAdmin = b;
    }
    
    public static void displayResults(String origin, String destination, LocalDate depDate, LocalDate retDate, String flightClass) throws SQLException {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		
                
                
                //new flight search object set to input values
                FlightSearch fs = new FlightSearch (origin, destination, depDate, retDate, flightClass);
                //create observablelist
                ObservableList <Flight> flights= FXCollections.observableArrayList();
                
                //set observable list to finddepflight methof
                flights = fs.findDepFlight();
                
      
                TableView tv = new TableView();
                FlightTableView ftv = new FlightTableView();
                tv = ftv.getFlightListView(flights);
               
                Button addFlightButton = new Button("Add Flights");
                addFlightButton.setOnAction(e-> {
                    ftv.addTicket(e);
                });
                
		VBox layout= new VBox(10);
		layout.getChildren().addAll(tv, addFlightButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene= new Scene(layout,500,500);
		window.setScene(scene);
		window.show();	
	}
    
    public static void displaySignUp ()
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
		
        
        VBox layout= new VBox(10);
	layout.getChildren().addAll();
	layout.setAlignment(Pos.CENTER);
		
        Scene scene= new Scene(layout,500,500);
	window.setScene(scene);
	window.show();	
    }
}

