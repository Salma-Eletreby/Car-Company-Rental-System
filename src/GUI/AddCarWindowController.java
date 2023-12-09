/**
 * 
 * @author Sarah Al-Qershi 
 * 14-4-2021
 * the class with controls the add button 
 *
 */

package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import Car_Rental_System.*;

public class AddCarWindowController {

	/**Button That adds the object to table*/
    @FXML
    private Button AddButton;

    /**Button that closes the screen without saving*/
    @FXML
    private Button CancelButton;

    /**text field for plate number*/
    @FXML
    private TextField plateNoText;

    /**text field for model*/
    @FXML
    private TextField modelText;

    /**text field for type*/
    @FXML
    private TextField TypeText;

    /**radio button for available*/
    @FXML
    private RadioButton yesRadio;

    /**grouping two radio buttons so only one can be selected*/
    @FXML
    private ToggleGroup Availability;

    /**radio button for not available*/
    @FXML
    private RadioButton noRadio;

    /**
     * Add a new object of type Car
     * @param event
     */
    @FXML
    void doAdd(ActionEvent event)
    {
    	String plateNum=plateNoText.getText();
    	String model=modelText.getText();
    	String tmp=TypeText.getText();
    	CarType type=null;
    	
    	try 
    	{
    		type=CarType.valueOf(tmp.toUpperCase());
    	}
    	catch(IllegalArgumentException ex) 
    	{
    		if(type==null) {
    			showAlert(AlertType.ERROR, "Invalid Car Type!",
    					String.format("please enter one of the following Car Types: SEDAN,SUV,VAN,TRUCK") );

    			return;
    		}
    	}

    	boolean available=false;
    	if(yesRadio.isSelected()) 
    	{
    		available=true;
    	}
    	else
    	{
    		available = false;
    	}

    	Car c=new Car(plateNum,model,type,available);
    	
    	ObservableList<Car> carOL= FXCollections.observableArrayList(CarRepositery.loadCars());
    	carOL.add(c);
    	
    	CarRepositery.saveDate(carOL);

    	showAlert(AlertType.INFORMATION, "Save Successful!",
                String.format("Car with plate number:%s is saved", 
                		c.getPlateNo()) );
    	//doCancel(null);
    	 
    }

    /**
     * Closes the window without adding a new Car object
     * @param event
     */
    @FXML
    void doCancel(ActionEvent event) 
    {
    	Stage st=(Stage) CancelButton.getScene().getWindow();
    	st.close();
    }

    private AddCarInteraction interaction;
	 /**
	  * this method will go to (AddCalnteraction) class  and will save the car 
	  * @param interaction
	  */

		public void setInteraction(AddCarInteraction interaction) {
			this.interaction = interaction;
		}
		
		private void showAlert(AlertType alertType, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.show();
	    }  
	
}
