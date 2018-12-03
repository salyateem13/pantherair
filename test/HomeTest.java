/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samir
 */

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class HomeTest extends Application {

     public static class HBoxCell extends HBox {
          Label label = new Label();
          Button button = new Button();

          HBoxCell(String labelText, String buttonText) {
               super();

               label.setText(labelText);
               label.setMaxWidth(Double.MAX_VALUE);
               HBox.setHgrow(label, Priority.ALWAYS);

               button.setText(buttonText);

               this.getChildren().addAll(label, button);
          }
     }

   public ListView addFlightsList(){
         
        //Flights area
          List<HBoxCell> list = new ArrayList<>();
          for (int i = 0; i < 12; i++) {
               list.add(new HBoxCell("Item " + i, "Button " + i));
          }

          ListView<HBoxCell> listView = new ListView<HBoxCell>();
          ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
          listView.setItems(myObservableList);

          
          
          return listView;
       
   }
   
   public TilePane addHomePageTilePane () throws FileNotFoundException {
        TilePane tile = new TilePane();
    tile.setHgap(8);
    tile.setPrefColumns(4);
    
    Button b1 = new Button("Flights for Less than $200");
    
    tile.getChildren().add(b1);
    
    
    return tile;
 
   }
     
   public GridPane addFlightSelector() {
       
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
       for (int i =0, )
        originChoiceBox.getItems().addAll("Apples");
        originChoiceBox.setValue("Your Location");
        GridPane.setConstraints(originChoiceBox, 1, 0);
        
        //Desination Label
        Label destLabel = new Label("To:");
        GridPane.setConstraints(destLabel, 0, 1);
        
        //Destination choicebox
        ChoiceBox<String> destChoiceBox = new ChoiceBox();
        destChoiceBox.getItems().addAll("Atlanta");
        destChoiceBox.setValue("Your Destination");
        GridPane.setConstraints(destChoiceBox, 1, 1);
        
         //Depart Label
        Label departLabel = new Label("Depart Date:");
        GridPane.setConstraints(departLabel, 0, 2);
        
        //Departure Date
        final DatePicker departDate= new DatePicker();
        departDate.setOnAction (event -> {
             LocalDate date = departDate.getValue();
             System.err.println("Selected date: " + date);
            
        });
        GridPane.setConstraints(departDate, 1, 2);
        
        
        //Return Label
        Label returnLabel = new Label("Return Date:");
        GridPane.setConstraints(returnLabel, 0, 3);
        
        //Return Date
        final DatePicker returnDate= new DatePicker();
        returnDate.setOnAction (event -> {
             LocalDate date = returnDate.getValue();
             System.err.println("Selected date: " + date);
            
        });
        GridPane.setConstraints(returnDate, 1, 3);
        
        //Select Flight Seat Class
        ToggleGroup group = new ToggleGroup();
        RadioButton economy = new RadioButton ("Economy Class");
        economy.setToggleGroup(group);
        RadioButton business = new RadioButton ("Business Class");
        business.setToggleGroup(group);
        HBox box = new HBox(20, economy,business);
        GridPane.setConstraints(box, 0, 4);
        
        
        //add flights admin only
        
        
        
        //Find Seats Button
        Button findSeatsButton = new Button ("Find Seats");
        GridPane.setConstraints(findSeatsButton, 1, 5);
        findSeatsButton.setOnAction(event ->{
        
        String origin = getChoice(originChoiceBox);
        String destination = getChoice(destChoiceBox);
        
      
        
        });
                
                
        
        
        grid.getChildren().addAll(originLabel, destLabel, originChoiceBox,destChoiceBox, departLabel, departDate,returnLabel, returnDate, box, findSeatsButton);
         
        return grid;
   }
   
   private String getChoice (ChoiceBox <String> cb){
       String temp = cb.getValue();
       return temp;
   }
     

     @Override
     public void start(Stage stage) throws Exception {
          
        BorderPane layout = new BorderPane();
         
        layout.setLeft(addFlightSelector());
         
        layout.setCenter(addHomePageTilePane());
        
        stage.setScene(new Scene(layout));
        stage.setWidth(1000);
        stage.setHeight(1000);
        stage.show();
     }

     public static void main(String args[]) {
          launch(args);
     }
}
