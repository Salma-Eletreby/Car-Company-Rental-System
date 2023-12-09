package Car_Rental_System;
import java.io.Serializable;
import java.util.Date;

/**
* @author Sarah Al-Qershi 201803194
* @version 1.0
* Created on: 02/04/2021
*/

public class Payment implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3904662989983243673L;
	/**
	* Description of the payment the customer provided
	*/
	private String paymentDescription;
	/**
	* ID of the payment of the customer
	*/
	private int paymentld;
	/**
	* The price of the renting
	*/
	private double price;
	/**
	* The date which the payment happened
	*/
	private Date paymentDate;
	
	public String getPaymentDescription() 
	{
		return paymentDescription;
	}
	
	public void setPaymentDescription(String paymentDescription) 
	{
		this.paymentDescription = paymentDescription;
	}
	
	public int getPaymentld() 
	{
		return paymentld;
	}
	public void setPaymentld(int paymentld) 
	{
		this.paymentld = paymentld;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public Date getPaymentDate() 
	{
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) 
	{
		this.paymentDate = paymentDate;
	}

	/**
	* @param paymentDescription
	* Description of the payment the customer provided
	* @param paymentld
	* ID of the payment of the customer
	* @param price
	* The price of the renting
	* @param paymentDate
	* The date which the payment happened
	*/
	public Payment(String paymentDescription, int paymentld, double price, Date paymentDate) 
	{
		this.paymentDescription = paymentDescription;
		this.paymentld = paymentld;
		this.price = price;
		this.paymentDate = paymentDate;
	}
	
	//Empty Constructor
	public Payment()
	{
		
	}

	/**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return "\nPayment:\nPayment Description: " + paymentDescription + "\nPayment Id: " + paymentld + "\nPrice: " + price
				+ "\nPayment Date=" + paymentDate + "\n";
	}
}
