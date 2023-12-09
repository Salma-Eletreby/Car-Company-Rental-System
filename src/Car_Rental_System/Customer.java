package Car_Rental_System;

import java.io.Serializable;

/**
* @author Hanan Nisar 201805719
* @version 1.0
* Created on: 31/03/2021
*/

public class Customer implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2020L;
	/**
	* The ID of the customer
	*/
	private int customerId;
	/**
	* The name of the customer
	*/
	private String name;
	/**
	* The telephone number of the customer
	*/
	private String phone;
	/**
	* The address of the customer
	*/
	private String address;
	/**
	* The nationality of the customer
	*/
	private String nationality;
	/**
	* The driving license number of the customer
	*/
	private String drivingLicence;
	
	public int getCustomerId() 
	{
		return customerId;
	}
	
	public void setCustomerId(int customerId) 
	{
		this.customerId = customerId;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getPhone() 
	{
		return phone;
	}
	
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	
	public String getAddress() 
	{
		return address;
	}
	
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getNationality() 
	{
		return nationality;
	}
	
	public void setNationality(String nationality) 
	{
		this.nationality = nationality;
	}
	
	public String getDrivingLicence() {
		return drivingLicence;
	}
	
	public void setDrivingLicence(String drivingLicence) 
	{
		this.drivingLicence = drivingLicence;
	}

	/**
	* @param customerId
	* The ID of the customer
	* @param name
	* The name of the customer
	* @param phone
	* The telephone number of the customer
	* @param address
	* The address of the customer
	* @param nationality
	* The nationality of the customer
	* @param drivingLicence
	* The driving license number of the customer
	*/
	public Customer(int customerId, String name, String phone, String address, String nationality,
			String drivingLicence) 
	{
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.nationality = nationality;
		this.drivingLicence = drivingLicence;
	}
	
	//Empty Constructor 
	public Customer()
	{
		
	}

	/**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return "\nCustomer:\nCustomer Id: " + customerId + "\nName: " + name + "\nPhone Number: " + phone + "\nAddress: " + address
				+ "\nNationality: " + nationality + "\nDriving Licence: " + drivingLicence + "\n";
	}
}
