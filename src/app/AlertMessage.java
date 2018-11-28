/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author samir
 */



public class AlertMessage {
	public static void display(String title, String message) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Text txt= new Text(message);
		txt.setTextAlignment(TextAlignment.CENTER);
		
		Button b1= new Button("Okay");
		b1.setOnAction(e ->{
			window.close();
		});
		VBox layout= new VBox(10);
		layout.getChildren().addAll(txt,b1);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene= new Scene(layout,500,125);
		window.setScene(scene);
		window.showAndWait();	
	}
}
