/**
* @author Salma Shady 202005204
* @version 1.0
* Created on: 16/04/2021
*/
package GUI;

import java.io.IOException;

import Car_Rental_System.Rental;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainWindowController implements AddRentalInteraction {

	/**Button that opens Cars Window*/
    @FXML
    private Button carsButton;

    /**Button that opens Customers Window*/
    @FXML
    private Button customersButton;

    /**Button that opens rentals Window*/
    @FXML
    private Button rentalsButton;

    /**method that opens customer Window*/
    @FXML
    void OpenCustomer(ActionEvent event) 
    {
    	Stage stage = new Stage();
    	Parent root;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("MainCustWindow.fxml"));
    	try {
    		root = loader.load();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cars");
    		stage.show();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    /**method that opens cars Window*/
    @FXML
    void openCars(ActionEvent event) {
    	Stage stage = new Stage();
    	Parent root;
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("CarMainWindow.fxml"));
    	try {
    		root = loader.load();
    		stage.setScene(new Scene(root));
    		stage.setTitle("Cars");
    		stage.show();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    }

    /**method that opens rentals Window*/
    @FXML
    void openRental(ActionEvent event) 
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RentalsWindow.fxml"));
		Parent root;
		try {
			root = loader.load();
			RentalWindowController controller = loader.getController();
			controller.setInteraction(this);
			Scene s = new Scene(root);
			Stage st = new Stage();
			st.setScene(s);
			st.show();

		} catch (IOException e) {

			e.printStackTrace();
		}
    }
}
