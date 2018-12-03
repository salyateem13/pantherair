/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

/**
 *
 * @author samir
 */
public class HomePageTilePane {
    
   public TilePane addHomePageTilePane ()  {
    TilePane tile = new TilePane();
    tile.setHgap(8);
    tile.setPrefColumns(4);
    
    Button b1 = new Button("Flights for Less than $200");
    b1.setPrefSize(100, 100);

    Button b2 = new Button("Busines Class Flights");
    b2.setPrefSize(100, 100);
    
    Button b3 = new Button("Flights for Less than $100");
    b3.setPrefSize(100, 100);
    
    Button b4 = new Button("Economy Class Flights");
    b4.setPrefSize(100, 100);

    
    tile.getChildren().addAll(b1, b2, b3, b4);
    
    
    return tile;
 
   }
    
}
