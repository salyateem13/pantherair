/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author samir
 */
public class Home extends Application {
    
    private static Stage window;
    private static Scene home;
    private static GridPane grid;
    
    public static void main(String [] args)
    {
        launch(args);
    }

    public static Stage getStage () 
            {
                return window;
            }
    
    public static GridPane getGridPane()
    {
         return grid;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Panther Air");
        
        grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap (8);
        grid.setHgap (10);
        
        
        
         //Password label
        Label passLabel = new Label("Home");
        GridPane.setConstraints(passLabel, 0, 1);
        
        grid.getChildren().addAll(passLabel);
        home = new Scene (grid, 500, 500);
        window.setScene(home);
        window.show();
        
        
        
        
        
        
        
    }
    
}
