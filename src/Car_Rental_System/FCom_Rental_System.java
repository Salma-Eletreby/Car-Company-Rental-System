package Car_Rental_System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import java.time.LocalDate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * @author Hanan Nisar 201805719 and Salma Shady 202005204
 * @version 1.0
 * Created on: 31/03/2021
 */

public class FCom_Rental_System 
{
	/**
	 * A list of customers and their details
	 */
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	/**
	 * A list of cars and their details
	 */
	private ArrayList<Car> cars = new ArrayList<Car>();
	/**
	 * A list of rentals and their details
	 */
	private ArrayList<Rental> rental = new ArrayList<Rental>();

	public ArrayList<Customer> getCustomers() 
	{
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) 
	{
		this.customers = customers;
	}

	public ArrayList<Car> getCars() 
	{
		return cars;
	}

	public void setCars(ArrayList<Car> cars) 
	{
		this.cars = cars;
	}

	public ArrayList<Rental> getRental() 
	{
		return rental;
	}

	public void setRental(ArrayList<Rental> rental) 
	{
		this.rental = rental;
	}

	/**
	 * @param customers
	 * A list of customers and their details
	 * @param cars
	 *  A list of cars and their details
	 * @param rental
	 *  A list of rentals and their details
	 */
	public FCom_Rental_System(ArrayList<Customer> customers, ArrayList<Car> cars, ArrayList<Rental> rental) 
	{
		this.customers = customers;
		this.cars = cars;
		this.rental = rental;
	}

	//Empty Constructor
	public FCom_Rental_System()
	{

	}

	/**
	* This method adds a new customer.
	* @param customer
	* The details of the new customer
	* @return Added customer Successfully
	*/
	public String addCustomer(Customer customer)
	{
		if(customer!=null && !customers.contains(customer))
		{
			customers.add(customer);
		}
		return "Added customer Successfully";
	}

	/**
	* This method finds a customer using their ID.
	* @param customerID
	* The ID of the customer
	* @return details of the customer
	*/
	public Customer findCustomer(int customerID) 
	{
		for (Customer c : customers) 
		{
			if(c.getCustomerId()==customerID)
			{
				return c;
			}		
		}

		return null;
	}

	/**
	* This method deletes a customer.
	*  @param customerID
	* The ID of the customer
	* @return Deleted Customer Successfully
	*/
	public String deleteCustomer(int customerID) 
	{
		for (Customer c : customers) 
		{
			if(c.getCustomerId()==customerID)
				customers.remove(c);
		} // for loop Customer

		return "Deleted Customer Successfully";	
	}

	/**
	* This method adds a new car.
	*  @param tcar
	* The details of the new car
	* @return Added car successfully
	*/
	public String addCar(Car tcar) 
	{
		if(tcar!=null && !cars.contains(tcar))
		{
			cars.add(tcar);
		}
		return "Added car successfully";
	} 

	/**
	* This method finds car.
	*  @param plateNumber
	* The plate number of the car
	* @return The details of the car you are seaching for
	*/
	public Car findCar(String plateNumber) 
	{
		for(Car c :cars) 
		{
			if(c.getPlateNo().equalsIgnoreCase(plateNumber))
			{
				return c;
			}
		}
		
		return null;
	}

	/**
	* This method deletes a car.
	*  @param plateNumber
	* The plate number of the car
	* @return Deleted Car Successfully
	*/
	public String deleteCar( String plateNumber) 
	{
		for(int i=0; i<cars.size(); i++) 
		{
			if(cars.get(i).getPlateNo().equalsIgnoreCase(plateNumber))
				cars.remove(i);
		} // for loop car
		
		for (int i=0; i< rental.size(); i++) 
		{
			if(rental.get(i).getCar().getPlateNo().equalsIgnoreCase(plateNumber))
				rental.remove(i);
		} // for loop rental
		
		return "Deleted Car Successfully";
	}
	
	/**
	* This method creates a list of cars that is available.
	*  @param available
	* Shows the availability that we want
	* @return a list of the cars with the availability we want
	*/
	public ArrayList<Car> getCarByAvailability(boolean available) 
    {
		ArrayList<Car> availableCars = new ArrayList<Car>();
		
        for(Car c: cars)
        {
            if(c.getIsAvailable()== available)
                availableCars.add(c);
        }    
			
		return availableCars;	
	}
	
	/**
	* This method updates the status of the car when returned.
	* @param plateNumber
	* The plate number of the car
	* @return Invoice
	*/
	public Invoice returnCar (String plateNo)
    {
        for (Rental r: rental)
        {
            if(r.getCar().getPlateNo() == plateNo)
            {
                r.getCar().setAvailable(true);
                return r.getInvoice();
            }
        }
        
        return null;
    }

	/**
	*This method updates the status of the car when rented out.
	* @param rental
	* The details of the renting process
	*/
    public void bookCarRental (Rental rental)
    {
        for (Car c: cars)
        {
            if(rental.getCar().getPlateNo() == c.getPlateNo())
            {
                c.setAvailable(false);
            }
        }
    }

    /**
	*This method searches for the cars rented by a specific customer.
	* @param customerId
	* The ID of the customer
	* @return a list of cars that was rented by the customer. 
	*/
    public ArrayList<Car> findCarRentalByCustomerId(int customerId)
    {
        ArrayList<Car> rentedCars = new ArrayList<Car>();

        for (Rental r: rental)
        {
            if(r.getCustomer().getCustomerId() == customerId)
            {
                rentedCars.add(r.getCar());
            }
        }

        return rentedCars;
    }

    /**
	*This method searches for the cars rented by a specific customer.
	* @param customerId
	* The ID of the customer
	* @return a list of cars that was rented by the customer. 
	*/
    public void deleteCarRental (int customerId)
    {
        for (Rental r: rental)
        {
            if(r.getCustomer().getCustomerId() == customerId)
            {
                rental.remove(r);
                r.getCar().setAvailable(true);
            }
        }
    }

    
    /**
	*This method searches for the cars that would be available at a certain date.
	* @param date
	* The date which we want to use
	* @return a list of cars that would be available by that date. 
	*/
    public ArrayList<Car> getAvailableCarsByDate(LocalDate date) 
    {
		ArrayList<Car> availableCars = new ArrayList<Car>();
		
        for (Rental r: rental)
        {
            if(r.getEndDate().isEqual(date) || r.getEndDate().isBefore(date))
            {
                 availableCars.add(r.getCar());
            }
        }    
        
        for(Car c: cars)
        {
            if(c.getIsAvailable() == true)
                availableCars.add(c);
        }
			
		return availableCars;	
	}
    
    /**
	*This method saves data to files. 
	*/
    public void saveDate()
    {
    	FileOutputStream fOut;
    	ObjectOutputStream oOut;
    	try 
    	{
	    		fOut = new FileOutputStream("data/Customers.dat");
	    	    oOut = new ObjectOutputStream(fOut);
	    	    
	    	    for(Customer c: customers)
	    	    {
	    	    	oOut.writeObject(c);
	    	    }
	    	    oOut.close();
	    	    fOut.close();
	    	    
	    	    fOut = new FileOutputStream("data/Cars.dat");
	    	    oOut = new ObjectOutputStream(fOut);
	    	    
	    	    for(Car cr: cars)
	    	    {
	    	    	oOut.writeObject(cr);
	    	    }
	    	    oOut.close();
	    	    fOut.close();
	    	    
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
    		
    		
    
    /**
   	*This method reads data from files. 
   	*/
    public void loadData()
    {
    	FileInputStream fIn;
    	ObjectInputStream in;
    	
    	Customer cust = new Customer();
    	Car car = new Car();
    	Rental ren = new Rental();
    	
    	try 
    	{
    		System.out.println("loaded data of customers:");
    		in = new ObjectInputStream(new FileInputStream("data/Customers.dat"));

    		while(in != null)
    		{
    			cust = (Customer) in.readObject();
    			System.out.println(cust);
    		}
    		in.close();
    	}
    	catch (ClassNotFoundException e) 
    	{
    		e.printStackTrace();
    	}
    	catch (IOException e) 
    	{
    		System.out.println(" ");
    	}
        	
    	try
    	{
    		System.out.println("loaded data of cars:");
    		in = new ObjectInputStream(new FileInputStream("data/Cars.dat"));

    		while(in != null)
    		{
    			car = (Car) in.readObject();
    			System.out.println(car);
    		}
    		in.close();
    	}
    	catch (ClassNotFoundException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (IOException e) 
    	{
    		System.out.println(" ");
    	}
    	try
    	{ 
    		System.out.println("loaded data of Rentals:");
    		in = new ObjectInputStream(new FileInputStream("data/Rentals.dat"));

    		while(in != null)
    		{
    			ren = (Rental) in.readObject();
    			System.out.println(ren);
    		}
    		in.close();
    	}
    	
    	catch (ClassNotFoundException e) 
    	{
    	    e.printStackTrace();
    	}
    	catch (IOException e) 
    	{
    		System.out.println(" ");
    	}
    		
    }

	@Override
	public String toString() {
		return "FCom_Rental_System:\nCustomers:" + customers + "\nCars: " + cars + "\nRentals: " + rental + "\n";
	}
}
