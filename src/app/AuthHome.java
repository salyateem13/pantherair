/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.User;



/**
 *
 * @author samir
 */


public class AuthHome extends Application {
        
    Scene loginScene;
    User thisUser;
           

     @Override
     public void start(Stage stage) throws Exception {
          
        BorderPane layout = new BorderPane();
         
        FlightSelector fs1 = new FlightSelector(thisUser);
        layout.setLeft(fs1.addFlightSelector());
        
        HomePageTilePane hptp1 = new HomePageTilePane();
        layout.setCenter(hptp1.addHomePageTilePane());
        
        
        Menu menu2 = new Menu("Home");

        Menu menu3 = new Menu("Account");
        
        //menu.setGraphic(new ImageView("file:Georgia_State_Athletics_logo.svg.png"));
         MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu2, menu3);
         layout.setTop(menuBar);   
         
        MenuItem menuItem3 = new MenuItem("My Flights");
        menu3.getItems().add(menuItem3);
        menuItem3.setOnAction(e -> {
            try {
                MyFlights mf = new MyFlights(thisUser);
                mf.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(AuthHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                });
      
        
        MenuItem menuItem2 = new MenuItem("Log Out");
        menu3.getItems().add(menuItem2);
        menuItem2.setOnAction(e -> {
            try {
                Home home = new Home();
                home.start(stage);
                stage.close();
            } catch (Exception ex) {
                Logger.getLogger(AuthHome.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
                stage.close();
            }
                
             });

   
        
        
        
        stage.setScene(new Scene(layout));
        stage.setWidth(1000);
        stage.setHeight(300);
        stage.show();
     }

     public static void main(String args[]) {
          launch(args);
     }
     
     
    
        public void setThisUser (User u)
     {
         this.thisUser = u;
     }

    
    
}

    

