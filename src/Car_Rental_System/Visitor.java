package Car_Rental_System;
import java.util.Date;

/**
* @author Hanan Nisar 201805719
* @version 1.0
* Created on: 31/03/2021
*/

public class Visitor extends Customer
{
	/**
	* The passport number of the customer
	*/
	private int passportNo;
	/**
	* The date which the customer entered Qatar
	*/
	private Date entryDate;
	/**
	* The date which the visa of the customer expires
	*/
	private Date visaExpiryDate;
	
	public int getPassportNo() 
	{
		return passportNo;
	}
	
	public void setPassportNo(int passportNo) 
	{
		this.passportNo = passportNo;
	}
	
	public Date getEntryDate() 
	{
		return entryDate;
	}
	
	public void setEntryDate(Date entryDate) 
	{
		this.entryDate = entryDate;
	}
	
	public Date getVisaExpiryDate() 
	{
		return visaExpiryDate;
	}
	
	public void setVisaExpiryDate(Date visaExpiryDate) 
	{
		this.visaExpiryDate = visaExpiryDate;
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
	* @param passportNo
	* The passport number of the customer
	* @param entryDate
	* The date which the customer entered Qatar
	* @param visaExpiryDate
	* The date which the visa of the customer expires
	*/
	public Visitor(int customerId, String name, String phone, String address, String nationality, String drivingLicence,
			int passportNo, Date entryDate, Date visaExpiryDate) 
	{
		super(customerId, name, phone, address, nationality, drivingLicence);
		this.passportNo = passportNo;
		this.entryDate = entryDate;
		this.visaExpiryDate = visaExpiryDate;
	}
	
	//Empty constructor
	public Visitor()
	{
		
	}

	 /**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return super.toString() +"Visitor.\nPassport Number: " + passportNo + "\nEntry Date: " + entryDate + "\nVisa Expiry Date: " + visaExpiryDate
				+ "\n";
	}
	
	
}
