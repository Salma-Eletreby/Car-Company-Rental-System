package Car_Rental_System;

/**
* @author Hanan Nisar 201805719
* @version 1.0
* Created on: 31/03/2021
*/

public class Resident extends Customer
{
	/**
	* The Qatar ID of the customer
	*/
	private int qatarId;

	public int getQatarId() 
	{
		return qatarId;
	}

	public void setQatarId(int qatarId) 
	{
		this.qatarId = qatarId;
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
	* @param qatarId
	* The Qatar ID of the customer
	*/
	public Resident(int customerId, String name, String phone, String address, String nationality,
			String drivingLicence, int qatarId) 
	{
		super(customerId, name, phone, address, nationality, drivingLicence);
		this.qatarId = qatarId;
	}
	
	//Empty Constructor
	public Resident()
	{
		
	}

	/**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return super.toString()+ "Resident.\nQatar Id:" + qatarId + "\n";
	}
	
	
}
