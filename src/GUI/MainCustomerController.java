package GUI;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import Car_Rental_System.*;
import GUI.AddCustomerController.AddCustomerInteraction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * Main Customer Controller Class
 * @author : Hanan Nisar
 * @version 1
 * Date created : 21 April 2021
 */

public class MainCustomerController implements AddCustomerInteraction{

	/**opens add window*/
    @FXML
    private Button addButton;

    /**opens update window*/
    @FXML
    private Button updateButton;

    /**deletes an object*/
    @FXML
    private Button deleteButton;

   /**saves to file*/
    @FXML
    private Button saveButton;

    @FXML
    private TableView<Visitor> custTableView;

    @FXML
    private TableColumn<Visitor, Integer> ID;

    @FXML
    private TableColumn<Visitor, String> Name;

    @FXML
    private TableColumn<Visitor, String> Phone;

    @FXML
    private TableColumn<Visitor, String> Address;

    @FXML
    private TableColumn<Visitor, String> Nationality;

    @FXML
    private TableColumn<Visitor, String> PassportNo;

    @FXML
    private TableColumn<Visitor, String> DrivingLicence;

    @FXML
    private TableColumn<Visitor, LocalDate> EntryDate;

    @FXML
    private TableColumn<Visitor, LocalDate> ExpiryDate;

    static ObservableList<Visitor> customerOL=FXCollections.observableArrayList(CustomerRepository.loadCustomers());
    
    @FXML
    void initialize() {
    	ID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
    	Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
    	Phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
    	Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
    	Nationality.setCellValueFactory(new PropertyValueFactory<>("Nationality"));
    	PassportNo.setCellValueFactory(new PropertyValueFactory<>("passportNo"));
    	DrivingLicence.setCellValueFactory(new PropertyValueFactory<>("DrivingLicence"));
    	EntryDate.setCellValueFactory(new PropertyValueFactory<>("entryDate"));
    	ExpiryDate.setCellValueFactory(new PropertyValueFactory<>("visaExpiryDate"));
    	custTableView.setItems(customerOL);
    }
    
    
    /**
	 * @param event
	 */
    @FXML
    void handleAddCust(ActionEvent event) {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCustomerView.fxml"));
    	 try {
    	Parent root = loader.load();
    	AddCustomerController controller = loader.getController();
    	controller.setInteraction(this);
    	 //controller
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    	custTableView.setItems(customerOL);
    	} catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
    }

    /**
   	 * @param event
   	 */
    
    @FXML
    void handleDeleteCust(ActionEvent event) {
    	int index=custTableView.getSelectionModel().getSelectedIndex();
    	customerOL.remove(index);
    	custTableView.setItems(customerOL);
    }

    /**
   	 * @param event
   	 */
    
    @FXML
    void handleSaveCust(ActionEvent event) {
    	Customer[] customerArray= customerOL.toArray(new Customer [customerOL.size()]);
    	CustomerRepository.saveData(customerOL);
    }

    /**
   	 * @param event
   	 */
    
    @FXML
    void handleUpdateCust(ActionEvent event) {

    	int index=custTableView.getSelectionModel().getSelectedIndex();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCustomerView.fxml"));
   	 try {
    	Parent root = loader.load();
    	AddCustomerController controller = loader.getController();
    	controller.setInteraction(this);
    	 //controller
    	controller.setFromValues(customerOL.get(index));
    	customerOL.remove(index);
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    	custTableView.setItems(customerOL);
    	} catch (IOException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	}
    }
    
    /**
   	 * adds new item
   	 */

	@Override
	public void saveCustomer(Visitor visitor) {
		customerOL.add(visitor);
		
	}

}
