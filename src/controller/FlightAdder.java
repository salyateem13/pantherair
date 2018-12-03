/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import app.AlertMessage;
import static controller.DatabaseConnection.createConnection;
import static controller.DatabaseConnection.getPrepareStatement;
import static controller.DatabaseConnection.getResults;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author samir
 */
public class FlightAdder {
    private String origin = "";
    private String destination ="";
    private LocalDate depDate ;
    private String flightClass = "";
    private int numOfSeats;
    private int flightID;
 

    public FlightAdder(String origin, String destination, LocalDate depDate, String flightClass, int numOfSeats) {
    this.origin = origin;
    this.destination  = destination;
    this.depDate = depDate;
    this.flightClass = flightClass;
    this.numOfSeats = numOfSeats;
    
    }
    
    public int getFlightScheduleID () throws SQLException
    {
        int flightScheduleID = 0;
        String query = "SELECT ScheduleID\n" +
        "FROM FLIGHT_SCHEDULE\n" +
        "Where origin = '" + this.origin + "' AND destination ='" + this.destination + "'";
        ResultSet myResults = getResults(createConnection(), query);
        while (myResults.next())
        {
         flightScheduleID = myResults.getInt("ScheduleID");
            return flightScheduleID;
        }
        return flightScheduleID;
        
    }
    
    public int getClassID () throws SQLException
    {
        int classID = 0;
        String query = "SELECT TravelClassID\n" +
        "from TRAVEL_CLASS\n" +
        "where Class LIKE  '%" + this.flightClass +"%'";
        ResultSet myResults = getResults(createConnection(), query);
        while (myResults.next())
        {
            classID = Integer.parseInt(myResults.getString("TravelClassID"));
        }
        return classID;
    }
    
    public int getFlightID () throws SQLException 
    {
        this.flightID = 0;
        String query ="Select * From FLIGHTS WHERE DepartDate = '" + this.depDate.toString() + "' AND ScheduleID = '"+ Integer.toString(this.getFlightScheduleID()) + "'";
        ResultSet myResults = getResults(createConnection(), query);
        while (myResults.next())
        {
            this.flightID = Integer.parseInt(myResults.getString("FlightID"));
            
        }
        return this.flightID;
    }
    
    public void addFlights () throws SQLException
    {
       String query = "INSERT INTO Flights ( ScheduleID, DepartDate )\n" +
        "VALUES ( ?, ?)";
       
        PreparedStatement  preparedStmt = getPrepareStatement(query);
        preparedStmt.setInt(1, getFlightScheduleID());
        preparedStmt.setDate(2, java.sql.Date.valueOf(this.depDate));
        preparedStmt.execute();
       
    }

    public void addSeats(int num) throws SQLException {
        String query = "INSERT INTO FLIGHT_SEATS (FlightID, TravelClassID, SeatNumber)\n" +
        "VALUES (?, ?, ?)";
        
        PreparedStatement  preparedStmt = getPrepareStatement(query);
        preparedStmt.setInt(1, getFlightID());
        preparedStmt.setInt(2, getClassID());
        preparedStmt.setInt(3, num);
        preparedStmt.execute();

        
    }

}
