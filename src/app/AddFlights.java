/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.FlightSearch;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class AddFlights extends Application {
    private Stage window;
    private User thisUser;
    private Flight flight;
    
    
    public AddFlights(User tu, Flight f)
            {
                this.thisUser =tu;
                this.flight = f;
            }
    
    public void start(Stage primaryStage) throws SQLException{
         window = primaryStage;
	 window.initModality(Modality.APPLICATION_MODAL);
		
                
                
                //new flight search object set to input values
                //FlightSearch fs = new FlightSearch (flight.getOrigin(), flight.getDestination(), LocalDate.parse(flight.getDepDate()), LocalDate.parse(flight.getRetDate()), flight.getFlightClass());
                FlightSearch fs = new FlightSearch();
            //create observablelist
                ObservableList <Flight> flights= FXCollections.observableArrayList();
                
                //set observable list to finddepflight methof
                flights = fs.findDepFlight(this.flight);
                
      
                TableView tv = new TableView();
                FlightTableView ftv = new FlightTableView(this.thisUser, this.flight);
                tv = ftv.getFlightListView(flights);
               
                Button addFlightButton = new Button("Book Flight");
                addFlightButton.setOnAction(e-> {
             try {
                 ftv.addTicket(e);
             } catch (SQLException ex) {
                 Logger.getLogger(AddFlights.class.getName()).log(Level.SEVERE, null, ex);
             }
                });
                
		VBox layout= new VBox(10);
		layout.getChildren().addAll(tv, addFlightButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene= new Scene(layout,500,600);
		window.setScene(scene);
		window.show();	
    }
    
}
