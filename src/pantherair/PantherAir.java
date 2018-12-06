/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantherair;

import app.Home;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author samir
 * 
 * This is thge main aoplication 
 * This class pulls the login class to display after the preloader executes all initialization commands
 * 
 */
public class PantherAir extends Application {
    
    BooleanProperty ready = new SimpleBooleanProperty(false);
    public static void main(String[] args) {
    	launch(args);
    }

    
    @Override
    public void start(Stage primaryStage) {
    longStart();

        try {
            //Scene
            Scene scene = new Scene(new BorderPane(), 1224, 968);
            
            
            //Primary Stage
            primaryStage.setTitle("Panther Air");
            primaryStage.setScene(scene);
            
            // After the app is ready, show the stage
        ready.addListener(new ChangeListener<Boolean>(){
            public void changed(
                ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                    if (Boolean.TRUE.equals(t1)) {
                        Platform.runLater(new Runnable() {
                            public void run() {
                                try {
                                    Home home = new Home();
                                    home.start(primaryStage);
                                } catch (Exception ex) {
                                    Logger.getLogger(PantherAir.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });
                    }
                }
        });      
            
        } catch (Exception ex) {
            Logger.getLogger(PantherAir.class.getName()).log(Level.SEVERE, null, ex);
        }
        


    }
    

    private void longStart() {
        //simulate long init in background
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                int max = 10;
                for (int i = 1; i <= max; i++) {
                    Thread.sleep(200);
                    // Send progress to preloader
                    notifyPreloader(new ProgressNotification(((double) i)/max));
                }
                // After init is ready, the app is ready to be shown
                // Do this before hiding the preloader stage to prevent the 
                // app from exiting prematurely
                ready.setValue(Boolean.TRUE);
 
                notifyPreloader(new StateChangeNotification(
                    StateChangeNotification.Type.BEFORE_START));
                
                return null;
            }
        };
        new Thread(task).start();
    }
   
    
}
