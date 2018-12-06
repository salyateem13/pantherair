/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controller.FlightAdder;
import controller.FlightGetter;
import controller.TicketDelete;
import controller.GetUserData;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Flight;
import models.User;

/**
 *
 * @author samir
 */
public class FlightTableView {

    private TableView <Flight> tableView;
    private User thisUser;
    private Flight selectedFlight ;
    
    FlightTableView(User u, Flight f)
    {
        this.thisUser = u;
        this.selectedFlight = f;
    }
    
    public TableView getFlightListView (ObservableList <Flight> flights)
    {
        tableView = new TableView();
        
        
        
        TableColumn originColumn = new TableColumn("Origin");
        originColumn.setMinWidth(100);
        originColumn.setCellValueFactory(new PropertyValueFactory <> ("origin"));
        
         TableColumn detinationColumn = new TableColumn("Destination");
        detinationColumn.setMinWidth(100);
        detinationColumn.setCellValueFactory(new PropertyValueFactory <> ("destination"));
        
         TableColumn depDateColumn = new TableColumn("Depart Date");
        depDateColumn.setMinWidth(100);
        depDateColumn.setCellValueFactory(new PropertyValueFactory <> ("depDate"));
        
         TableColumn seatNoColumn = new TableColumn("SeatNumber");
        seatNoColumn.setMinWidth(100);
        seatNoColumn.setCellValueFactory(new PropertyValueFactory <> ("seatNo"));
        
         TableColumn flightClassColumn = new TableColumn("Flight Class");
        flightClassColumn.setMinWidth(100);
        flightClassColumn.setCellValueFactory(new PropertyValueFactory <> ("flightClass"));
         
        TableColumn seatNoIDColumn = new TableColumn("Seat ID");
        seatNoIDColumn.setMinWidth(100);
        seatNoIDColumn.setCellValueFactory(new PropertyValueFactory <> ("flightSeatID"));
        
        
        
        
        
        tableView.getColumns().addAll(originColumn,detinationColumn,depDateColumn, seatNoColumn, flightClassColumn, seatNoIDColumn);
        
        tableView.setItems(flights);
        
        
        
        return tableView;
        
    }
    
    void addTicket (ActionEvent event) throws SQLException
    {
        System.out.println("ticket added");
        ObservableList<Flight> flight=  tableView.getSelectionModel().getSelectedItems();
        // get seat number
        //int seatNo = Integer.parseInt(flight.get(0).getSeatNo());
      //  FlightGetter fg = new FlightGetter(this.selectedFlight);
        
        int seatNo = flight.get(0).getFlightSeatID();
        
        
        //get user ID from username
        String uName = thisUser.getUserName();
        GetUserData gud = new GetUserData();
        int uID= gud.getUserID(thisUser);
        
        //Add ticket
        FlightAdder fa = new FlightAdder();
        fa.addTickets(seatNo, uID);
        
        
        
        System.out.println(thisUser.getUserName() + "ticket added");
        
        
    }
    
     void deleteTicket (ActionEvent event) throws SQLException
    {
       
        ObservableList<Flight> flight=  tableView.getSelectionModel().getSelectedItems();
        // get seat id using seat number and flightseatid
       //flightseatid
       int flightSeatID = flight.get(0).getFlightSeatID();
       System.out.println(flightSeatID);
               
        //get user ID from username
        String uName = thisUser.getUserName();
        GetUserData gud = new GetUserData();
        int uID= gud.getUserID(thisUser);
        
        //DElete ticket
        TicketDelete td = new TicketDelete();
        td.deleteTicket(flightSeatID, uID);
        
        
        
        System.out.println(thisUser.getUserName() + "ticket added");
        
        
    }
    
}
