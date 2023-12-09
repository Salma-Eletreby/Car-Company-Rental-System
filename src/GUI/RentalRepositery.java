/**
* @author Salma Shady 202005204
* @version 1.0
* Created on: 16/04/2021
*/
package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Car_Rental_System.*;
import javafx.collections.ObservableList;

import java.io.FileInputStream;


public class RentalRepositery {
	
	/**creates an array list of customers from file*/
	static ArrayList<Customer> loadCustomers() {
		FileInputStream fIn;
    	ObjectInputStream oIn;
    	
    	Customer cust = new Customer();
    	ArrayList <Customer>customer = new ArrayList <Customer>();
    	
    	try {
    		ObjectInputStream in ;
    		System.out.println("loaded data of customers:");
    		
    		in = new ObjectInputStream(new FileInputStream("data/Customers.dat"));
    			
    			while(in != null)
    			{
    				cust = (Customer) in.readObject();
    				customer.add(cust);
    				System.out.println(cust);
    			}
 
    		} catch (IOException e) {
    			System.out.println(" ");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	
    	return customer;
    	}
	
	/**creates an array list of customer ID from file*/
	public static List<Integer> getCustomerId(){
		List<Integer> customerID = new ArrayList<Integer>();
		for (Customer c:loadCustomers())
		{
			if (!customerID.contains(c.getCustomerId()))
					{
				customerID.add(c.getCustomerId());
					}
		}
		return customerID;
	}

	/**creates an array list of cars from file*/
	static ArrayList<Car> loadCars() {
		FileInputStream fIn;
    	ObjectInputStream oIn;
    	
    	Car c = new Car();
    	ArrayList <Car>car = new ArrayList <Car>();
    	
    	try {
    		ObjectInputStream in ;
    		System.out.println("loaded data of Cars:");
    		
    		in = new ObjectInputStream(new FileInputStream("data/Cars.dat"));
    			
    			while(in != null)
    			{
    				c = (Car) in.readObject();
    				car.add(c);
    				System.out.println(c);
    			}
 
    		} catch (IOException e) {
    			System.out.println(" ");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	
    	return car;
    	}
	
	/**creates an array list of cars' plate numbers from file*/
	public static List<String> getPlateNo(){
		List<String> PlateNo = new ArrayList<String>();
		for (Car c:loadCars())
		{
			if (!PlateNo.contains(c.getPlateNo()))
					{
				PlateNo.add(c.getPlateNo());
					}
		}
		return PlateNo;
	}
	
	/**creates an array list of rentals from file*/
	static ArrayList<Rental> loadRentals() {
		FileInputStream fIn;
    	ObjectInputStream oIn;
    	
    	Rental r = new Rental();
    	ArrayList <Rental> rental = new ArrayList <Rental>();
    	
    	try {
    		ObjectInputStream in ;
    		System.out.println("loaded data of Rentals:");
    		
    		in = new ObjectInputStream(new FileInputStream("data/Rentals.dat"));
    			
    			while(in != null)
    			{
    				r = (Rental) in.readObject();
    				rental.add(r);
    				System.out.println(r);
    			}
 
    		} catch (IOException e) {
    			System.out.println(" ");
    		} catch (ClassNotFoundException e) {
    			e.printStackTrace();
    		}
    	
    	return rental;
    	}
	
	/**creates an array list of rentals of specific customer from file*/
	public static List<Rental> getRentalsCustomer(int customerID){
		List<Rental> rentals = new ArrayList<Rental>();
		for (Rental r:loadRentals())
		{
			if (r.getCustomer().getCustomerId() == customerID)
					{
						rentals.add(r);
					}
		}
		return rentals;
	}
	
	/**saves the data of rentals to the file*/
	static void saveDate(ObservableList<Rental> rental)
	{
		FileOutputStream fOut;
    	ObjectOutputStream oOut;
    	
    	try
    	{
    		fOut = new FileOutputStream("data/Rentals.dat");
    	    oOut = new ObjectOutputStream(fOut);
    	    
    	    for(Rental r: rental)
    	    {
    	    	oOut.writeObject(r);
    	    }
    	    oOut.close();
    	    fOut.close();
    	}
    	catch (FileNotFoundException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (IOException e) 
    	{
    	    e.printStackTrace();
    	}
	}
}
