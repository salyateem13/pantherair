/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.menus;

import app.AlertMessage;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author samir
 */
public class GeneralMenu {
    
  private boolean isAuthenticated = false;
  private boolean isAdmin = false;
  
    public MenuBar getGeneralMenu()
    {
        Menu menu = new Menu("Home");

        Menu menu1 = new Menu("Account");
        
        //menu.setGraphic(new ImageView("file:Georgia_State_Athletics_logo.svg.png"));
       
        MenuItem menuItem1 = new MenuItem("Sign In");
        menu1.getItems().add(menuItem1);
        menuItem1.setOnAction(e -> {
                //AlertMessage.displayNode();
               // LogInForm LogIn
                ((Node)(e.getSource())).getScene().getWindow().hide();
                
                });
        
        
        MenuItem menuItem2 = new MenuItem("Sign Up");
        menu1.getItems().add(menuItem2);
        menuItem2.setOnAction(e -> {
                System.out.println("Menu Item 1 Selected");
             });

        
     
        
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu, menu1);
        
        return menuBar;
        
    }
    
    public MenuBar getUserMenu  ()
    {
         Menu menu = new Menu("Home");

        Menu menu1 = new Menu("Account");
        
        //menu.setGraphic(new ImageView("file:Georgia_State_Athletics_logo.svg.png"));
       
        MenuItem menuItem1 = new MenuItem("My Flights");
        menu1.getItems().add(menuItem1);
        menuItem1.setOnAction(e -> {
                
                });
        
        
        MenuItem menuItem2 = new MenuItem("Log Out");
        menu1.getItems().add(menuItem2);
        menuItem2.setOnAction(e -> {
                System.out.println("Menu Item 1 Selected");
             });

        
        MenuItem menuItem3 = new MenuItem("Sign In");
        menu1.getItems().add(menuItem3);
        
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu, menu1);
        
        return menuBar;
        
    }
    
    public boolean getIsAuth(){
        return this.isAuthenticated;
    }
    
    public boolean getIsAdmin (){
        return this.isAdmin;
    }
    
}
