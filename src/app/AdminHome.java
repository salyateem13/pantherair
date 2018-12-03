/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.SQLException;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author samir
 */
class AdminHome extends Home {
    
      @Override
     public void start(Stage stage) throws Exception {
          
        BorderPane layout = new BorderPane();
         
        AdminFlightSelector afs = new AdminFlightSelector();
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
    
    
    
}
