/**
 * 14-4-2021
 * @author Sarah Al-Qersh and Salma Eletreby
 * @version 1
 * Created on 14/4/2021
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

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Car_Rental_System.*;


public class UpdateCarWindowController {
	private Car myCar;
	
    /**Button that sends the new data to table*/
	@FXML
    private Button UpdateButton;

	/**button that closes window*/
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

    /**closes the window*/
    @FXML
    void doCancel(ActionEvent event) {
    	Stage st=(Stage) CancelButton.getScene().getWindow();
    	st.close();
    }

    /**updates the data */
    @FXML
    void doUpdate(ActionEvent event) {
    	String plateNum=plateNoText.getText();
    	String model=modelText.getText();
    	String tmp=TypeText.getText();
    	CarType type = null;
    	try {
    		type=CarType.valueOf(tmp);
    		
    	}catch(IllegalArgumentException ex) {
    		if(type==null) {
        		showAlert(AlertType.ERROR, "Invalid Car Type!",
                        String.format("please enter one of the following Car Types: SEDAN,SUV,VAN,TRUCK") );
            	
        		return ;
        		
        	}
    		
    	}

    	boolean avaliable=false;
    	if(yesRadio.isSelected()) {
    		
    		avaliable=true;
    	}
    	myCar.setPlateNo(plateNum);
    	myCar.setModel(model);	
    	myCar.setType(type);
    	myCar.setAvailable(avaliable);
    	
    	
    	//ObservableList<Car> carOL= FXCollections.observableArrayList(CarRepositery.loadCars());
    	//carOL.add(myCar);
    	
    	//CarRepositery.saveDate(carOL);
    	
    	interaction.updateCar(myCar);
    	showAlert(AlertType.INFORMATION, "update Successful!",
                String.format("Car with plate number:%s is updated", myCar.getPlateNo()) );
    	 doCancel(null);
    }

    private UpdateCarInteraction interaction;

	public void setInteraction(UpdateCarInteraction interaction) {
		this.interaction = interaction;
	}
	
	private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

	/**fills the text fields with the data from table view*/
	public void setCar(Car selectedItem) {
		myCar=selectedItem;
		plateNoText.setText(selectedItem.getPlateNo());
		modelText.setText(selectedItem.getModel());
		TypeText.setText(selectedItem.getType().toString());
		if(selectedItem.getIsAvailable()) {
			
			yesRadio.setSelected(true);
			
		}
		else
			noRadio.setSelected(true);
		
	}  
}
