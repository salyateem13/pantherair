package forums;

import app.FlightSelector;
import app.Home;
import controller.FlightSearch;
import controller.SetUserData;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.Admin;
import models.User;




/* Sign Up 
 * author @emmanuel
 * 
 */


public class SignUpForum extends Application {
     Stage window;
     String secQuestionClass;
     ChoiceBox<String> secChoiceBox;
     private String userStatus;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
          window = primaryStage;
            
            window.setTitle("Sign Up PantherAir");
        
        
        // Create the registration form grid pane
        GridPane gridPane = createSignUpFormPane();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(gridPane, 1000, 1000);
        // Set the scene in primary stage	
        window.setScene(scene);
        
        window.show();
        
        
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
        // Add State Label
        Label cityLabel = new Label("City : ");
        gridPane.add(cityLabel, 0,6);
        
        // Add State Text Field
        TextField cityField = new TextField();
        cityField.setPrefHeight(30);
        gridPane.add(cityField, 1,6);
           
        // Add ZipCode Label
        Label zipLabel = new Label("Zip : ");
        gridPane.add(zipLabel, 0,7);
        
        // Add ZipCode Text Field
        TextField zipField = new TextField();
        zipField.setPrefHeight(30);
        gridPane.add(zipField, 1,7);
        
        // Add State Label
        Label stateLabel = new Label("State : ");
        gridPane.add(stateLabel, 0,8);
        
        // Add State Text Field
        TextField stateField = new TextField();
        stateField.setPrefHeight(30);
        gridPane.add(stateField, 1,8);
        
        
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
        secChoiceBox = new ChoiceBox<>();
        secChoiceBox.getItems().addAll(
            "What is your favorite book?",
            "What is the name of your pet?",
            "What is the name of yout elementary school?"          
        );
        secChoiceBox.setValue("Pick Secuirty Question");
        gridPane.add(secChoiceBox, 1, 11);
        
        
        
        
         // Add SQA Text Field
        TextField sqaField = new TextField("Security Question Answer");
        sqaField.setPrefHeight(30);
        gridPane.add(sqaField, 1,12);
       
        


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
        
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
           @Override
           public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
               // Has selection.
               if (group.getSelectedToggle() != null) {
                   RadioButton button = (RadioButton) group.getSelectedToggle();
                   System.out.println("Button: " + button.getText());
                    userStatus = button.getText();
               }
           }
       });

        
        Image imageSB = new Image(getClass().getResourceAsStream("sign_up_button.png"));
       
        
        
        // Add Submit Button
        Button submitButton = new Button();
        submitButton.setGraphic(new ImageView (imageSB));
       // submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        gridPane.add(submitButton, 0, 15, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));
        

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            
            
            
            //if Admin radiobutton selection
            
            
        
                
            //else if customer radiobutton selected
            
            
            //else show alert
         
            @Override
            public void handle(ActionEvent event) {
                //set security question id for Object creations
                String temp = secChoiceBox.getValue();
                int sqi = 0;
                if (Objects.equals(temp, new String("What is your favorite book?")))
                {
                    sqi = 5001; 
                }else if (Objects.equals(temp, new String("What is the name of your pet?")))
                    sqi = 5002;
                
                else if (Objects.equals(temp, new String("What is the name of yout elementary school?")))
                    sqi = 5003;
                
        
                
                
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
                
                
                if (validateNumber(ssnField) == false) {
            		showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please input only numbers for \nsocial security number xxx-xx-xxxx (no dashes)");   
            		return;
            	}
                
                if (ssnField.getText().length() != 9) {
                	showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please input 9 numbers for \nsocial security number ");
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
                if(secChoiceBox.getSelectionModel().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please choose a security question");
                    return;
                }
                
                if(Objects.equals(userStatus, new String("Admin")))
                {
                    try {
                        
                        //create admin object
                        Admin thisAdmin = new Admin(passwordField.getText(), userNameField.getText(),firstNameField.getText(), lastNameField.getText(), addressField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), emailField.getText(), Integer.toString(sqi), sqaField.getText(), ssnField.getText(), true);
                        
                        //pass admin object through controller
                        SetUserData sud = new SetUserData();
                        sud.addAdmin(thisAdmin);
                        
                        Home home = new Home();
                        Stage stage = new Stage();
                        home.start(stage);
                        
                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + firstNameField.getText() + " " + lastNameField.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUpForum.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(SignUpForum.class.getName()).log(Level.SEVERE, null, ex);
                    }

                   
                }
                
                
                else if (Objects.equals(userStatus, new String("Non-Admin")))
                {
                    try {
                        // create user object
                        User thisUser = new User(passwordField.getText(), userNameField.getText(),firstNameField.getText(), lastNameField.getText(), addressField.getText(), cityField.getText(), stateField.getText(), zipField.getText(), emailField.getText(), Integer.toString(sqi), sqaField.getText(), ssnField.getText());
                        //pass admin object through controller
                        SetUserData sud = new SetUserData();
                        sud.addUser(thisUser);
                        
                         Home home = new Home();
                        Stage stage = new Stage();
                        home.start(stage);
                        
                        //pass user object through controller
                        showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + firstNameField.getText() + " " + lastNameField.getText());
                    } catch (SQLException ex) {
                        Logger.getLogger(SignUpForum.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(SignUpForum.class.getName()).log(Level.SEVERE, null, ex);
                    }

                 }
                else
        showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Registration Failed", "Sorry!");
 
                

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

