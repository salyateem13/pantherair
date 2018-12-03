/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author samir
 */


public class AuthHome extends Application {
        
    Scene loginScene;
    

     @Override
     public void start(Stage stage) throws Exception {
          
        BorderPane layout = new BorderPane();
         
        FlightSelector fs1 = new FlightSelector();
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
                
                });
      
        
        MenuItem menuItem2 = new MenuItem("Log Out");
        menu3.getItems().add(menuItem2);
        menuItem2.setOnAction(e -> {
                System.out.println("Menu Item 1 Selected");
             });

   
        
        
        
        stage.setScene(new Scene(layout));
        stage.setWidth(1000);
        stage.setHeight(300);
        stage.show();
     }

     public static void main(String args[]) {
          launch(args);
     }
    
        

    
    
}

    

