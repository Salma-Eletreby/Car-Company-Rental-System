/**
 * 14-4-2021
 * @author Sarah Al-Qersh and Salma Eletreby
 * @version 1
 * Created on 14/4/2021
 */
package GUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Optional;

import Car_Rental_System.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CarMainWindowController implements AddCarInteraction,UpdateCarInteraction{

	/**Button that opens add window*/
    @FXML
    private Button AddButton;

    /**Button that opens update window*/
    @FXML
    private Button UpdateButton;

    /**button that deletes selected item*/
    @FXML
    private Button DeleteButton;

    /**button that saves data permenaantly in files*/
    @FXML
    private Button SaveButton;

    /**table to display items*/
    @FXML
    private TableView<Car> CarTable;

    /**column for plate number*/
    @FXML
    private TableColumn<Car, String> plateNoCol;

    /**column for model*/
    @FXML
    private TableColumn<Car, String> modelCol;

    /**column for type*/
    @FXML
    private TableColumn<Car, CarType> typeCol;

    /**column for availability*/
    @FXML
    private TableColumn<Car, Boolean> availableCol;
    
    ObservableList<Car> carOL = FXCollections.observableArrayList(CarRepositery.loadCars());;
   
    /**opens the add window*/
    @FXML
    void doAdd(ActionEvent event) 
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("AddCarWindow.fxml"));
		Parent root;
		try {
			root = loader.load();
			AddCarWindowController controller = loader.getController();
			controller.setInteraction(this);
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setScene(s);
			st.show();
			
			st.setOnCloseRequest(e -> {ObservableList<Car> carOL= FXCollections.observableArrayList(CarRepositery.loadCars());
			CarTable.setItems(carOL);} );
		} catch (IOException e) {

			e.printStackTrace();
		}
		
    }

    /**deletes a car*/
    @FXML
    void doDelete(ActionEvent event) {
    	if (CarTable.getSelectionModel().getSelectedIndex() == -1) {
			showAlert(AlertType.ERROR, "Delete error", "please select car to delete ");
			return;

		}
		Optional<ButtonType> isConfirmed = showConfirmationDialog("Confirm Delete","Are you sure you want to delete this car?");
		if (isConfirmed.get() == ButtonType.OK){
			carOL.remove(CarTable.getSelectionModel().getSelectedItem());
		} 

    }

    /**saves data to file*/
    @FXML
    void doSave(ActionEvent event) {
    	CarRepositery.saveDate(carOL);
    }

    /**updates data of selected items*/
    @FXML
    void doUpdate(ActionEvent event) {
    	if (CarTable.getSelectionModel().getSelectedIndex() == -1) {
			showAlert(AlertType.ERROR, "Update error", "please select car to update ");
			return;

		}
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateCarWindow.fxml"));
		Parent root;
		try {
			root = loader.load();
			UpdateCarWindowController controller = loader.getController();
			controller.setInteraction(this);
			controller.setCar(CarTable.getSelectionModel().getSelectedItem());
		
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setScene(s);
			st.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
    }

    /**Fills the columns and table with data*/
    @FXML
    void initialize() {
    
    	
    	plateNoCol.setCellValueFactory(new PropertyValueFactory<>("plateNo"));
    	modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    	availableCol.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
    	
    	CarTable.setItems(carOL);
    	
    }

	@Override
	public void SaveCar(Car car) {
		// TODO Auto-generated method stub
		carOL.add(car);
	}   
	
	/**creates a pop up window*/
	private void showAlert(AlertType alertType, String title, String message) {
		Alert alert = new Alert(alertType);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.show();
	}
	
	/**creates a pop up window*/
	private Optional<ButtonType> showConfirmationDialog(String title, String message) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setContentText(message);

		return alert.showAndWait();
	}

	@Override
	public void updateCar(Car car) {
		// TODO Auto-generated method stub
		
	}
}
