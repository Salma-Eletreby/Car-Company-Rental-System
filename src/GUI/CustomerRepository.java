/**
 * Main Customer Controller Class
 * @author : Hanan Nisar
 * @version 1
 * Date created : 21 April 2021
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


public class CustomerRepository {
	
	/**loads customer data from file*/
	static ArrayList<Visitor> loadCustomers() {
		FileInputStream fIn;
    	ObjectInputStream oIn;
    	
    	Visitor cust = new Visitor();
    	ArrayList <Visitor>customer = new ArrayList <Visitor>();
    	
    	try {
    		ObjectInputStream in ;
    		System.out.println("loaded data of visitor:");
    		
    		in = new ObjectInputStream(new FileInputStream("data/Visitor.dat"));
    			
    			while(in != null)
    			{
    				cust = (Visitor) in.readObject();
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
	
	/**gets customer ID from file*/
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

	/**loads data of cars from file*/
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
	
	/**gets plate number of cars from file*/
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
	
	/**gets Rentals from file*/
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
	
	/**gets rentals by customer ID from file*/
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
	
	/**saves date to file*/
	static void saveData(ObservableList<Visitor> customerOL)
	{
		FileOutputStream fOut;
    	ObjectOutputStream oOut;
    	
    	try
    	{
    		fOut = new FileOutputStream("data/Customer.dat");
    	    oOut = new ObjectOutputStream(fOut);
    	    
    	    for(Customer c: customerOL)
    	    {
    	    	oOut.writeObject(c);
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
