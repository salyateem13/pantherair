/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.DatabaseConnection.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import models.Flight;
import models.User;

/**
 *
 * @author samir
 */
public class FlightSearch {
    private String origin;
    private String destination ;
    private LocalDate depDate;
    private LocalDate retDate;
    private String flightClass ;
    
    
    private TableView tableview;
    //TABLE VIEW AND DATA
    private ObservableList<ObservableList> data;
    
    
    public FlightSearch() {
       
    }
    
    public FlightSearch(String o)
    {
        this.origin = o;
       
    }
    public FlightSearch (String o, String d, LocalDate dd, LocalDate rd, String fc)
    {
        this.origin = o;
        this.destination = d;
        this.depDate = dd;
        this.retDate = rd;
        this.flightClass = fc;
    }
    
    
    
    
    public List<String> getOrigin() throws SQLException
    {
        String query = " SELECT Origin\n" +
        "From FLIGHT_SCHEDULE\n" +
        "group by origin";
        ResultSet myResults = getResults(createConnection(), query);
        List<String> origin = new ArrayList<>();

          
      while (myResults.next())   
     {
          origin.add(myResults.getString("origin")); 
     }
      return origin;
    }
    
    
    public List<String> getDest () throws SQLException
    {
        String query = "SELECT destination\n" +
"From FLIGHT_SCHEDULE where origin = '" + this.origin + "' group by destination";
        
        ResultSet myResults = getResults(createConnection(), query);
        List<String> destination = new ArrayList<>();
        
        while (myResults.next())   
     {
          destination.add(myResults.getString("destination")); 
         
     }
      return destination;
        
        
    }
    
    public ObservableList <Flight> findDepFlight (Flight f) throws SQLException
    {
        
        String query = "Select fs.FlightSeatID, f.FlightID, tc.TravelClassID, SeatNumber, fsh.ScheduleID, origin, destination, Class, DepartDate\n" +
"From ((FLIGHT_SEATS fs  INNER JOIN  Flights f ON f.FlightID = fs.FlightID)\n" +
"			INNER JOIN FLIGHT_SCHEDULE fsh ON f.ScheduleID = fsh.ScheduleID) \n" +
"				INNER JOIN TRAVEL_CLASS tc ON fs.TravelClassID= tc.TravelClassID\n" +
"GROUP BY fs.FlightSeatID, f.FlightID, TravelClassID, SeatNumber, fsh.ScheduleID, origin, destination, Class, DepartDate\n" +
"HAVING DepartDate = '"+ f.getDepDate().toString() +"'\n" +
" AND Class LIKE  '%"+ f.getFlightClass() +"%'\n" +
"AND origin = '"+ f.getOrigin() + "' AND FlightSeatID NOT IN (SELECT FlightSeatID FROM TICKETS) ";
        ObservableList <Flight> flights = FXCollections.observableArrayList();
        ResultSet myResults = getResults(createConnection(), query);
         while(myResults.next())
         {
             flights.add(new Flight(
                     myResults.getString("origin"), 
                     myResults.getString("destination"),
                     myResults.getString("DepartDate"),
                     myResults.getString("SeatNumber"),
                     myResults.getString("Class"),
                     myResults.getInt("FlightSeatId")
             ));
             
         }
         
         return flights;
         
    }
         
    
    //public insertFlight()

    public ObservableList<Flight> findMyFlights(User thisUser) throws SQLException {
          String query = "Select fs.FlightSeatID, f.FlightID, tc.TravelClassID, SeatNumber, fsh.ScheduleID, origin, destination, Class, DepartDate, t.UserID\n" +
"From (((FLIGHT_SEATS fs  INNER JOIN  Flights f ON f.FlightID = fs.FlightID)\n" +
"			INNER JOIN FLIGHT_SCHEDULE fsh ON f.ScheduleID = fsh.ScheduleID) \n" +
"				INNER JOIN TRAVEL_CLASS tc ON fs.TravelClassID= tc.TravelClassID)\n" +
"                INNER JOIN TICKETS t ON fs.FlightSeatID = t.FlightSeatID\n" +
"GROUP BY fs.FlightSeatID, f.FlightID, TravelClassID, SeatNumber, fsh.ScheduleID, origin, destination, Class, DepartDate ,  t.UserID\n" +
"HAVING UserID = " +thisUser.getUserID();
        ObservableList <Flight> flights = FXCollections.observableArrayList();
        ResultSet myResults = getResults(createConnection(), query);
         while(myResults.next())
         {
             flights.add(new Flight(
                     myResults.getString("origin"), 
                     myResults.getString("destination"),
                     myResults.getString("DepartDate"),
                     myResults.getString("SeatNumber"),
                     myResults.getString("Class"),
                     myResults.getInt("FlightSeatId")
             ));
             
         }
         
         return flights;
         
    }
    
}
