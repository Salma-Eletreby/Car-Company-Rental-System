/**
* @author Salma Shady 202005204
* @version 1.0
* Created on: 16/04/2021
*/
package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Car_Rental_System.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RentalWindowController {

	/**Combo box containing list customer ID*/
    @FXML
    private ComboBox<Integer> CustomerIDCombo;

    /**Combo box containing list car plate numbers*/
    @FXML
    private ComboBox<String> CarPlateCombo;

    /**opens calendar to choose date for start of rental*/
    @FXML
    private DatePicker startDatePicker;

    /**opens calendar to choose date for end of rental*/
    @FXML
    private DatePicker endDatePicker;

    /**button that adds rental*/
    @FXML
    private Button RentButton;
    
    /**table that displays information*/
    @FXML
    private TableView<Rental> RentalTable;

    /**column that shows start date of rental*/
    @FXML
    private TableColumn<Rental, LocalDate> startDateCol;

    /**column that shows end date of rental*/
    @FXML
    private TableColumn<Rental, LocalDate> endDateCol;

    /**column that shows deposit of rental*/
    @FXML
    private TableColumn<Rental, Double> depositCol;

    /**column that shows invoice number of rental*/
    @FXML
    private TableColumn<?, ?> invoiceNoCol;

    /**column that shows invoice date of rental*/
    @FXML
    private TableColumn<?, ?> invoiceDateCol;

    /**column that shows total amount of money of rental*/
    @FXML
    private TableColumn<Rental, Double> totalCol;
    
    ObservableList<Integer> idOL= FXCollections.observableArrayList(RentalRepositery.getCustomerId());
    ObservableList<String> plateNoOL= FXCollections.observableArrayList(RentalRepositery.getPlateNo());
    ObservableList<Rental> rentalOL= FXCollections.observableArrayList(RentalRepositery.loadRentals());
    
    FCom_Rental_System system = new FCom_Rental_System(RentalRepositery.loadCustomers(),RentalRepositery.loadCars(),RentalRepositery.loadRentals());
    
    /**method that creates a new rental*/
    @FXML
    void AddRental(ActionEvent event) {
    	Rental ren = new Rental();
    	
    	Integer IDSelected=CustomerIDCombo.getValue();
    	String carSelected=CarPlateCombo.getValue();
    	LocalDate end = endDatePicker.getValue();
    	LocalDate start = startDatePicker.getValue();
    	
    	ren.setCustomer(system.findCustomer(IDSelected));
    	ren.setCar(system.findCar(carSelected));
    	ren.setStartDate(start);
    	ren.setEndDate(end);
    	ren.setDeposit();
    	
    	ObservableList<Rental> CustomerRental= FXCollections.observableArrayList(RentalRepositery.getRentalsCustomer(IDSelected));
    	
    	int invNo = 123;
    	Date invDate =  new Date(22/4/2021);
    	
    	Date date1 = new Date (2020,2,12);
		Payment pay1 = new Payment("cash",1011,1000,date1);
		Date date2 = new Date (2020,3,14);
		Payment pay2 = new Payment("credit",1213,2000,date2);
		
		ArrayList <Payment> payments = new ArrayList <Payment>();
		payments.add(pay1);
		payments.add(pay2);
    	
    	Invoice inv = new Invoice(invNo,invDate,payments);
    	ren.setInvoice(inv);
    	
    	CustomerRental.add(ren);
    	RentalTable.setItems(CustomerRental);
    	
    	rentalOL.add(ren);
    	RentalRepositery.saveDate(rentalOL);
    }
    
    /**fills the combo box for the car plate with data*/
    @FXML
    void ChooseCar(ActionEvent event) {
    	String carSelected=CarPlateCombo.getValue();
    	CarPlateCombo.setItems(plateNoOL);
    }

    @FXML
    void ChooseEndDate(ActionEvent event) {
    	LocalDate end = endDatePicker.getValue();

    }

    /**fills the combo box for the customer ID with data*/
    @FXML
    void ChooseID(ActionEvent event) 
    {
    	Integer IDSelected=CustomerIDCombo.getValue();
    	CustomerIDCombo.setItems(idOL);
    }

    @FXML
    void ChooseStartDate(ActionEvent event) {
    	LocalDate start = startDatePicker.getValue();

    }

    
    /**Fills the columns and table with data*/
    @FXML
    void initialize() {
    	CustomerIDCombo.setItems(idOL);
    	CarPlateCombo.setItems(plateNoOL);
    
    	
    	
    	startDateCol.setCellValueFactory(new PropertyValueFactory<>("StartDate"));
    	endDateCol.setCellValueFactory(new PropertyValueFactory<>("EndDate"));
    	depositCol.setCellValueFactory(new PropertyValueFactory<>("Deposit"));
    	invoiceNoCol.setCellValueFactory(new PropertyValueFactory<>("invoiceNo"));
    	invoiceDateCol.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
    	totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
    }
    
    /**to be able for the rentals window to open from main window*/
    private AddRentalInteraction interaction;

		public void setInteraction(AddRentalInteraction interaction) {
			this.interaction = interaction;
		}
}
