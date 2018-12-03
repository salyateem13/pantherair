/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Flight;

/**
 *
 * @author samir
 */
public class FlightTableView {

    private TableView <Flight> tableView;
    
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
        
        
        
        
        
        
        tableView.getColumns().addAll(originColumn,detinationColumn,depDateColumn, seatNoColumn, flightClassColumn);
        
        tableView.setItems(flights);
        
        
        
        return tableView;
        
    }
    
    void addTicket (ActionEvent event)
    {
        System.out.println("ticket added");
        ObservableList<Flight> flight=  tableView.getSelectionModel().getSelectedItems();
        System.out.println(flight.get(0).getSeatNo());
    }
    
}
