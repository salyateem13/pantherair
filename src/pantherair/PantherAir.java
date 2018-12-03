/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantherair;

import app.LogIn;
import app.Home;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author samir
 * 
 * This is thge main aoplication 
 * This class pulls the login class to display after the preloader executes all initialization commands
 * 
 */
public class PantherAir extends Application {
    public static void main(String[] args) {
    	launch(args);
    }

 

    @Override
    public void start(Stage primaryStage) {
	
        try {
            //Scene
            Scene scene = new Scene(new BorderPane(), 1224, 968);
            
            
            //Primary Stage
            primaryStage.setTitle("Panther Air");
            primaryStage.setScene(scene);
            
            Home home = new Home();
            home.start(primaryStage);
        } catch (Exception ex) {
            Logger.getLogger(PantherAir.class.getName()).log(Level.SEVERE, null, ex);
        }
        


    }
    

   
    
}
