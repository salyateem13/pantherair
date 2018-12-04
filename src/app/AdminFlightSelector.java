/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Interfaces.SearchAgent;
import controller.FlightAdder;
import controller.FlightSearch;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author samir
 */
class AdminFlightSelector implements SearchAgent {

    LocalDate depDate;
    LocalDate retDate;
    String origin;
     String destination;
     String flightClass;
     int numSeats;
    @Override
    public GridPane addFlightSelector () throws SQLException
    {
        
           //seach flights area
          
        GridPane  grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap (5);
        grid.setHgap (5);
        //Origin Label
        Label originLabel = new Label("From:");
        GridPane.setConstraints(originLabel, 0, 0);
        
        //Origin choice box
        ChoiceBox<String> originChoiceBox = new ChoiceBox();
         FlightSearch fsOrigin = new FlightSearch();
         List<String> originList = fsOrigin.getOrigin();
         originChoiceBox.setValue(originList.get(0));
         for(int i = 0; i < originList.size(); i++) {   
             originChoiceBox.getItems().addAll(originList.get(i));
            }
        
        
        originChoiceBox.setValue("Your Location");
        GridPane.setConstraints(originChoiceBox, 1, 0);
        
        //Desination Label
        Label destLabel = new Label("To:");
        GridPane.setConstraints(destLabel, 0, 1);
        
        //Destination choicebox
        ChoiceBox<String> destChoiceBox = new ChoiceBox();
        destChoiceBox.setValue("Your Destination");
        
         
        //event listener for two-way data bind on from
        originChoiceBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue)  -> {
            try {
                destChoiceBox.getItems().clear();
                String originSelection = "Your Destination";
                originSelection = newValue;
                System.out.println(originSelection);
                FlightSearch fsDest = new FlightSearch(originSelection);
                List<String> destList = fsDest.getDest();
                for(int i = 0; i < destList.size(); i++) {
                    destChoiceBox.getItems().add(destList.get(i));
                }
            } catch (SQLException ex) {
                Logger.getLogger(FlightSelector.class.getName()).log(Level.SEVERE, null, ex);
            }
      
            
                    });
        
       
        
       
       
        
        
        GridPane.setConstraints(destChoiceBox, 1, 1);
        
         //Depart Label
        Label departLabel = new Label("Depart Date:");
        GridPane.setConstraints(departLabel, 0, 2);
        
        //Departure Date
        DatePicker departDatePicker= new DatePicker();
        departDatePicker.setOnAction (event -> {
             this.depDate = departDatePicker.getValue();
             System.err.println("Selected date: " + this.depDate);
            
        });
        GridPane.setConstraints(departDatePicker, 1, 2);
        
        
        //Return Label
        Label returnLabel = new Label("Return Date:");
        GridPane.setConstraints(returnLabel, 0, 3);
        
        //Return Date
        DatePicker returnDatePicker= new DatePicker();
        returnDatePicker.setOnAction (event -> {
             LocalDate date = returnDatePicker.getValue();
             System.err.println("Selected date: " + date);
            
        });
        GridPane.setConstraints(returnDatePicker, 1, 3);
        
        //Select Flight Seat Class
        ToggleGroup group = new ToggleGroup();
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
           @Override
           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
               // Has selection.
               if (group.getSelectedToggle() != null) {
                   RadioButton button = (RadioButton) group.getSelectedToggle();
                   System.out.println("Button: " + button.getText());
                   flightClass= button.getText();
               }
           }
       });
        
        RadioButton economy = new RadioButton ("Economy");
        economy.setToggleGroup(group);
        
        RadioButton business = new RadioButton ("Business");
        business.setToggleGroup(group);
        HBox box = new HBox(20, economy,business);
        GridPane.setConstraints(box, 0, 4);
        
        
    
        
        
        //Find Seats Button
        Button findSeatsButton = new Button ("Find Seats");
        GridPane.setConstraints(findSeatsButton, 1, 5);
        findSeatsButton.setOnAction(event ->{
      
          try {
                this.origin = getChoice(originChoiceBox);
                this.destination = getChoice(destChoiceBox);
                this.depDate = departDatePicker.getValue();
                LocalDate retDate = returnDatePicker.getValue();
                
                
                
                //fsf.findDepFlight();
                AlertMessage.displayResults(this.origin, this.destination, this.depDate, this.retDate, this.flightClass);
            } catch (SQLException ex) {
                Logger.getLogger(FlightSelector.class.getName()).log(Level.SEVERE, null, ex);
            }

        });  
        
        //number of seats label
        Label numSeatsLabel = new Label("NumberOfSeats");
        GridPane.setConstraints(numSeatsLabel, 0, 6);
        
        //numSeats INput
        TextField numSeatsInput = new TextField("");
        numSeatsInput.setPromptText("");
        GridPane.setConstraints(numSeatsInput,1,6);
        
         //Add Seats Button
        Button addSeatsButton = new Button ("Add Seats");
        GridPane.setConstraints(addSeatsButton, 1, 7);
        addSeatsButton.setOnAction(e ->{
             
            try {
                this.origin = getChoice(originChoiceBox);
                this.destination = getChoice(destChoiceBox);
                this.depDate = departDatePicker.getValue();
                //LocalDate retDate = returnDatePicker.getValue();
                String numString = numSeatsInput.getText();
                if (numString != null)
                {
                    this.numSeats = Integer.parseInt(numString);
                }
                // this.flightClass = "";
             
                
                FlightAdder fa = new FlightAdder (this.origin, this.destination, this.depDate, this.flightClass, this.numSeats);
                fa.addFlights();
                 for (int i = 1; i <= this.numSeats; i++)
                {
                    fa.addSeats(i);
                    
                   System.out.println("One flightseat added" );
                }
                //String flightClassID = this.flightClass;
                //System.out.println(flightClassID );
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminFlightSelector.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
            
                
            
        
        });
        
        
        grid.getChildren().addAll(originLabel, destLabel, originChoiceBox,destChoiceBox, departLabel, departDatePicker,returnLabel, returnDatePicker, box,numSeatsLabel, numSeatsInput, findSeatsButton, addSeatsButton);
         
        return grid;
    }
    
    private String getChoice (ChoiceBox <String> cb){
       String temp = cb.getValue();
       return temp;
   }
}
