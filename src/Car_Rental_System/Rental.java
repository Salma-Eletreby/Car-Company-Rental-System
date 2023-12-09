package Car_Rental_System;
import java.io.Serializable;
import java.time.*;

/**
* @author Sarah Al-Qershi 201803194
* @version 1.0
* Created on: 02/04/2021
*/

public class Rental implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5981819441523356469L;
	/**
	* The number of the rental
	*/
	private int rentalNo;
	/**
	* The details of the customer
	*/
	private Customer customer;
	/**
	* The details of the car
	*/
	private Car car;
	/**
	* The date which the rental starts
	*/
	private LocalDate StartDate;
	/**
	* The date which the rental ends
	*/
	private LocalDate EndDate;
	/**
	* The amount paid as a deposit
	*/
	private static double deposit;
	/**
	* The details of the invoice
	*/
	private Invoice invoice;
	
	public int getRentalNo() 
	{
		return rentalNo;
	}
	
	public void setRentalNo(int rentalNo) 
	{
		this.rentalNo = rentalNo;
	}
	
	public Customer getCustomer() 
	{
		return customer;
	}
	
	public void setCustomer(Customer customer) 
	{
		this.customer = customer;
	}
	
	public Car getCar() 
	{
		return car;
	}
	
	public void setCar(Car car) 
	{
		this.car = car;
	}
	
	public LocalDate getStartDate() 
	{
		return StartDate;
	}
	
	public void setStartDate(LocalDate startDate) 
	{
		StartDate = startDate;
	}
	
	public LocalDate getEndDate() 
	{
		return EndDate;
	}
	
	public void setEndDate(LocalDate endDate) 
	{
		EndDate = endDate;
	}
	
	public double getDeposit() 
	{
		return deposit;
	}
	
	public static void setDeposit() 
	{
		deposit = 2000;
	}
	
	public Invoice getInvoice() 
	{
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) 
	{
		this.invoice = invoice;
	}

	/**
	* @param rentalNo
	* The number of the rental
	* @param customer
	* The details of the customer
	* @param car
	* The details of the car
	* @param startDate
	* The date which the rental starts
	* @param endDate
	* The date which the rental ends
	* @param deposit
	* The amount paid as a deposit
	* @param invoice 
	* The details of the invoice
	*/
	public Rental(int rentalNo, Customer customer, Car car, LocalDate startDate, LocalDate endDate,
			Invoice invoice) 
	{
		this.rentalNo = rentalNo;
		this.customer = customer;
		this.car = car;
		StartDate = startDate;
		EndDate = endDate;
		deposit = 2000;
		this.invoice = invoice;
	}
	
	//Empty constructor
	public Rental()
	{
		
	}

	/**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return "Rental:\nRental Number: " + rentalNo + customer + car + "\nStart Date: " + StartDate
				+ "\nEnd Date: " + EndDate + "\nDeposit:" + deposit + "\nInvoice:" + invoice + "\n";
	}
}
