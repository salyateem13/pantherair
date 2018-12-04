package forums;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.ComboBox;




/* Sign Up 
 * author @emmanuel
 * 
 */


public class SignUpForum extends Application {
    
     String secQuestionClass;
     ComboBox<String> secQComboBox;
	
	
	public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Sign Up PantherAir");
        
        
        // Create the registration form grid pane
        GridPane gridPane = createSignUpFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 900, 900);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        
    }


    private GridPane createSignUpFormPane() {
        
        
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // Add Header
     
        
        Label headerLabel = new Label("Sign Up For PantherAir Account");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));
        
 
        // Add First Name Label
        Label nameLabel = new Label("First Name : ");
        gridPane.add(nameLabel, 0,1);

        // Add First Name Text Field
        TextField firstNameField = new TextField();
        firstNameField.setPrefHeight(30);
        gridPane.add(firstNameField, 1,1);

        // Add Last Name Label
        Label lastNameLabel = new Label("Last Name : ");
        gridPane.add(lastNameLabel, 0,2);
       
        // Add Last Name Text Field
        TextField lastNameField = new TextField();
        lastNameField.setPrefHeight(30);
        gridPane.add(lastNameField, 1,2);
        
        // Add Social Security Number Label
        Label ssnLabel = new Label("SSN : ");
        gridPane.add(ssnLabel, 0,3);
        
        // Add Social Security Number Text Field
        TextField ssnField = new TextField();
        ssnField.setPrefHeight(30);       
        gridPane.add(ssnField, 1,3);
      
        // Add Address Label
        Label addressLabel = new Label("Address Line : ");
        gridPane.add(addressLabel, 0,4);
        
        // Add Address Text Field
        TextField addressField = new TextField();
        addressField.setPrefHeight(30);
        gridPane.add(addressField, 1,4);

        // Add Email Label
        Label emailLabel = new Label("Email : ");
        gridPane.add(emailLabel, 0, 5);

        // Add Email Text Field
        TextField emailField = new TextField();
        emailField.setPrefHeight(30);
        gridPane.add(emailField, 1, 5);
           
        // Add ZipCode Label
        Label zipLabel = new Label("Zip : ");
        gridPane.add(zipLabel, 0,6);
        
        // Add ZipCode Text Field
        TextField zipField = new TextField();
        zipField.setPrefHeight(30);
        gridPane.add(zipField, 1,6);
        
        // Add State Label
        Label stateLabel = new Label("Address : ");
        gridPane.add(stateLabel, 0,7);
        
        // Add State Text Field
        TextField stateField = new TextField();
        stateField.setPrefHeight(30);
        gridPane.add(stateField, 1,7);
        
        // Add UserID Label
        Label userIDLabel = new Label("UserID : ");
        gridPane.add(userIDLabel, 0,8);
        
        // Add UserID Text Field
        TextField userIDField = new TextField();
        userIDField.setPrefHeight(30);
        gridPane.add(userIDField, 1, 8);
        
        // Add UserName Label
        Label userNameLabel = new Label("Username : ");
        gridPane.add(userNameLabel, 0,9);
        
        // Add UserName Text Field
        TextField userNameField = new TextField();
        userNameField.setPrefHeight(30);
        gridPane.add(userNameField, 1,9);

        // Add Password Label
        Label passwordLabel = new Label("Password : ");
        gridPane.add(passwordLabel, 0, 10);

        // Add Password Field
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(30);
        gridPane.add(passwordField, 1, 10);
        
        
        // Add secQLabel
        Label secQLabel = new Label("Question: ");
        gridPane.add(secQLabel, 0, 11);
        
        //Add SecurityQuestionComboBox
        secQComboBox = new ComboBox<>();
        secQComboBox.getItems().addAll(
            "What is your favorite book?",
            "What is the name of your pet",
            "What is the name of yout elementary school?"          
        );
        secQComboBox.setPromptText("Pick Secuirty Question");
        gridPane.add(secQComboBox, 1, 11);


        // Add AccountStatus Label
        Label acctStatusLabel = new Label("Pick Status : ");
        gridPane.add(acctStatusLabel, 0, 13);
        
        //Add RadioButtons for account status
        final ToggleGroup group = new ToggleGroup();
        
        RadioButton rb1 = new RadioButton("Non-Admin");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        gridPane.add(rb1, 1, 13);
        
        RadioButton rb2 = new RadioButton("Admin");
        rb2.setToggleGroup(group);
        gridPane.add(rb2, 1, 14);

        // Add Submit Button
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(30);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 15, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(firstNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your first name");
                    return;
                }
                
                if(lastNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your last name");
                    return;
                }
                
                if(userNameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter username");
                    return;
                }
                
                if(addressField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter valid address");
                    return;
                }
                
                if(userIDField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a user ID");                                                
                    return;
                }
                
                if (validateNumber(ssnField) == false) {
            		showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please input only numbers for \nsocial security number xxx-xx-xxxx (no dashes)");   
            		return;
            	}
                
                if (ssnField.getText().length() != 9) {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please input 9 numbers for \nsocial security number ");
                	return;
                }
                
            	if (validateNumber(userIDField) == false) {
            		showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please input only numbers for user ID");   
            		return;
            	}
            	
            	if (validateNumber(zipField) == false) {
            		showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please input only numbers for zip code");   
            		return;
            	}
            	
            	if(stateField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter state");
                    return;
            	}
            	
                if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your email");
                    return;
                }
                if(passwordField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a password");
                    return;
                }
                
                //comboBox error prompt
                if(secQComboBox.getSelectionModel().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please choose a security question");
                    return;
                }

                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + firstNameField.getText() + " " + lastNameField.getText());
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    
    
    
    private boolean validateNumber(TextField id) {
    
		Pattern j = Pattern.compile("[0-9]+");
		Matcher m = j.matcher(id.getText());
		
		if (m.find() && m.group().equals(id.getText())){		
			return true;
		}
		
		else {
					
			return false;
		}
		
		
    }
    public static void main(String[] args) {
        launch(args);
    }
}

