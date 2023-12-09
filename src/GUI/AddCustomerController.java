package GUI;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import Car_Rental_System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Add customer controller class
 * @author : Hanan Nisar
 * @version 1
 * Date created : 21 April 2021
 */

public class AddCustomerController {

    @FXML
    private DatePicker entryDate;

    @FXML
    private DatePicker expDate;

    @FXML
    private TextField idTextf;

    @FXML
    private TextField nameTextf;

    @FXML
    private TextField phoneTextf;

    @FXML
    private TextField addressTextf;

    @FXML
    private TextField nationalityTextf;

    @FXML
    private TextField drivingLicenceTextf;

    @FXML
    private TextField passportTextf;

    @FXML
    private Button okayButton;

    @FXML
    private Button cancelButton;

    @FXML
    void initialize() {
    	//ObservableList<Integer> customerid= FXCollections.observableArrayList(CustomerRepository.getCustomerId()); 
    }
    
    /**
   	 * @param event
   	 */
    @FXML
    void handleCancel(ActionEvent event) {

    	Stage stage= (Stage) cancelButton.getScene().getWindow();
    	stage.close();
    }

    
    /**
   	 * @param event
   	 */
    @FXML
    void handleOkay(ActionEvent event) {
  
    	//MainCustomerController.customerOL.remove(MainCustomerController.Visitor.get(0));
    	int idEntered;
    	try {
    		idEntered=Integer.parseInt(idTextf.getText());
    	}catch( NumberFormatException e) {
    		Alert alert= new Alert(AlertType.ERROR,"Only integer values accepted for Customer ID ");
    		alert.showAndWait();
    		return;
    	}
    	
    	String nameEntered = nameTextf.getText();
    	if(nameEntered.trim().isEmpty()) {
    		Alert alert= new Alert(AlertType.ERROR,"Name required ");
    		alert.showAndWait();
    		return;
    	}
    		
    	String phoneEntered=phoneTextf.getText();
    	if(phoneEntered.trim().isEmpty()) {
    		Alert alert= new Alert(AlertType.ERROR,"Phone number required ");
    		alert.showAndWait();
    		return;
    	}
    	
    	String addressEntered=addressTextf.getText();
    	if(addressEntered.trim().isEmpty()) {
    		Alert alert= new Alert(AlertType.ERROR,"address required ");
    		alert.showAndWait();
    		return;
    	}
    	
    	String nationalityEntered=nationalityTextf.getText();
    	if(nationalityEntered.trim().isEmpty()) {
    		Alert alert= new Alert(AlertType.ERROR,"Nationality required ");
    		alert.showAndWait();
    		return;
    	}
    	
    	String drivingLicenceEntered=drivingLicenceTextf.getText();
    	if(drivingLicenceEntered.trim().isEmpty()) {
    		Alert alert= new Alert(AlertType.ERROR,"driving Licence required ");
    		alert.showAndWait();
    		return;
    	}
    	
    	int passportNoEntered;
    	try {
    		passportNoEntered=Integer.parseInt(passportTextf.getText());
    	}catch(NumberFormatException e) {
    		Alert alert= new Alert(AlertType.ERROR,"Passport number should be an integer value");
    		alert.showAndWait();
    		return;	
    		
    	}
    	 /**
       	 * creates new visitor
       	 */
    	
    	Date entry = new Date(entryDate.getValue().toEpochDay());
    	//customer.setEntryDate(entry);
    	
    	Date visa = new Date(expDate.getValue().toEpochDay());
    	//customer.setVisaExpiryDate(visa);
    	Visitor visitor= new Visitor(idEntered,nameEntered,phoneEntered , addressEntered, 
    			nationalityEntered, drivingLicenceEntered,passportNoEntered,entry, visa);
    	
    	Alert alert= new Alert(AlertType.INFORMATION, "Customer details added successfully");
		alert.showAndWait();
		
		Stage stage= (Stage) okayButton.getScene().getWindow();
		stage.close();
    	
    	interaction.saveCustomer(visitor);
    	System.out.println(visitor);
    	handleCancel(null);
    }
    
    /**
   	 * adds new item
   	 */
    public void setFromValues(Visitor visitor) {
    	idTextf.setText(String.format("%d", visitor.getCustomerId()));
    	nameTextf.setText(visitor.getName());
    	phoneTextf.setText(visitor.getPhone());
    	addressTextf.setText(visitor.getAddress());
    	nationalityTextf.setText(visitor.getNationality());
    	drivingLicenceTextf.setText(visitor.getDrivingLicence());
    	
    	passportTextf.setText(String.format("%d", visitor.getPassportNo()));
    	
    	Date entry = new Date();
    	entry = visitor.getEntryDate();
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	Instant instant = entry.toInstant();
    	LocalDate entrylocalDate = instant.atZone(defaultZoneId).toLocalDate();
    	entryDate.setValue(entrylocalDate);
    	
    	Date visa = new Date();
    	visa = visitor.getVisaExpiryDate();
    	ZoneId defaultZone = ZoneId.systemDefault();
    	Instant inst = entry.toInstant();
    	LocalDate visalocalDate = inst.atZone(defaultZone).toLocalDate();
    	expDate.setValue(visalocalDate);
    }
    
    /**
   	 * Customer interaction
   	 */
    private AddCustomerInteraction interaction;
    public void setInteraction(AddCustomerInteraction interaction) {
    this.interaction = interaction;
    }
    /**
   	 * Interface
   	 */
    public interface AddCustomerInteraction{
    public void saveCustomer(Visitor visitor);
    }

}
