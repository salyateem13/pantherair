/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.menus.AuthMenu;
import java.sql.SQLException;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import models.Admin;
import models.User;

/**
 *
 * @author samir
 */
public class AdminHome extends Application {
     Admin thisAdmin;
    
    
      @Override
     public void start(Stage stage) throws Exception {
          
        BorderPane layout = new BorderPane();
         
        
        Menu menu = new Menu("Home");

        Menu menu1 = new Menu("Account");
        
        //menu.setGraphic(new ImageView("file:Georgia_State_Athletics_logo.svg.png"));
       
        MenuItem menuItem1 = new MenuItem("Sign Out");
        menu1.getItems().add(menuItem1);
        menuItem1.setOnAction(e -> {
                
                stage.close();
                
                });
        
        
        MenuItem menuItem2 = new MenuItem("My Flights");
        menu1.getItems().add(menuItem2);
        menuItem2.setOnAction(e -> {
            try {
                MyFlights mf = new MyFlights((User) thisAdmin);
                mf.start(stage);
            } catch (Exception ex) {
                Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                       
             });

        
     
        
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu, menu1);
        
        layout.setTop(menuBar);
        
        AdminFlightSelector afs = new AdminFlightSelector(this.thisAdmin);
        layout.setLeft(afs.addFlightSelector());
        
        HomePageTilePane hptp = new HomePageTilePane();
        layout.setCenter(hptp.addHomePageTilePane());
        
       // FlightListView flv = new FlightListView ();
        //layout.setCenter(flv.getFlightListView());
        
        stage.setScene(new Scene(layout));
        stage.setWidth(1000);
        stage.setHeight(300);
        stage.show();
     }

     public static void main(String args[]) {
          launch(args);
     }
    
    public void setThisAdmin (Admin a)
     {
         this.thisAdmin = a;
     }
    
}
