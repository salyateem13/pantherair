/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.FlightSearch;
import controller.GetUserData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Flight;
import models.User;

/**
 *
 * @author samir
 */
class MyFlights extends Application {
    
    private User thisUser;
    private Flight flight;
    
public MyFlights (User u)
{
    this.thisUser = u;
   
}
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
	
        
                
                
        //new flight search object set to input values
        //FlightSearch fs = new FlightSearch ();
         
        //create observablelist of flights
        //ObservableList <Flight> flights= FXCollections.observableArrayList();
                
        //set observable list to finddepflight methof
         //flights = fs.findDepFlight();
                
       ObservableList <Flight> flights= FXCollections.observableArrayList();
        TableView tv = new TableView();
        FlightSearch fs = new FlightSearch();
        
        FlightTableView ftv = new FlightTableView(this.thisUser, this.flight);
        
       
      
       // return arraylist of flights with flightseatid included
       flights = fs.findMyFlights(this.thisUser);
       
       tv = ftv.getFlightListView(flights);
       
               
        Button addFlightButton = new Button("Delete Flight");
        addFlightButton.setOnAction(e-> {
            try {
                ftv.deleteTicket(e);
            } catch (SQLException ex) {
                Logger.getLogger(MyFlights.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
                
	VBox layout= new VBox(10);
	layout.getChildren().addAll(tv, addFlightButton);
	layout.setAlignment(Pos.CENTER);
		
	Scene scene= new Scene(layout,500,500);
	window.setScene(scene);
	window.show();	
    }
    
    
    public void setThisUser (User u)
    {
        this.thisUser = u;
    }
    
    
}
