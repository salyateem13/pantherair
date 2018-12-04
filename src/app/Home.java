/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 *
 * @author samir
 */


public class Home extends Application {
        
    Scene loginScene;
    static private boolean isAuth= false;
    private boolean isAdmin = false;

     @Override
     public void start(Stage stage) throws Exception {
          
        BorderPane layout = new BorderPane();
         
        FlightSelector fs = new FlightSelector();
        layout.setLeft(fs.addFlightSelector());
        
        HomePageTilePane hptp = new HomePageTilePane();
        layout.setCenter(hptp.addHomePageTilePane());
        
        
        Menu menu = new Menu("Home");

        Menu menu1 = new Menu("Account");
        
        //menu.setGraphic(new ImageView("file:Georgia_State_Athletics_logo.svg.png"));
         MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu, menu1);
         layout.setTop(menuBar);   
         
        MenuItem menuItem1 = new MenuItem("Sign In");
        menu1.getItems().add(menuItem1);
        menuItem1.setOnAction(e -> {
               isAuth =  AlertMessage.displayNode();
               System.out.println (isAuth);
               stage.close();
                
                });
      
        
        MenuItem menuItem2 = new MenuItem("Sign Up");
        menu1.getItems().add(menuItem2);
        menuItem2.setOnAction(e -> {
                System.out.println("Menu Item 1 Selected");
                isAuth =  AlertMessage.displaySignUpNode();
               System.out.println (isAuth);
             });

        
        
        
        stage.setScene(new Scene(layout));
        stage.setWidth(1000);
        stage.setHeight(300);
        stage.show();
     }

     public static void main(String args[]) {
          launch(args);
     }
    
        

    
    
}

    

