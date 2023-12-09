package Car_Rental_System;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
* @author Sarah Al-Qershi 201803194
* @version 1.0
* Created on: 04/04/2021
*/
public class Invoice implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6508572424686996974L;
	/**
	* The number of the invoice
	*/
	private int invoiceNo;
	/**
	* The date of the invoice
	*/
	private Date invoiceDate;
	/**
	* A list of all the payments
	*/
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	
	public int getInvoiceNo() 
	{
		return invoiceNo;
	}
	
	public void setInvoiceNo(int invoiceNo) 
	{
		this.invoiceNo = invoiceNo;
	}
	
	public Date getInvoiceDate() 
	{
		return invoiceDate;
	}
	
	public void setInvoiceDate(Date invoiceDate) 
	{
		this.invoiceDate = invoiceDate;
	}
	
	public ArrayList<Payment> getPayments() 
	{
		return payments;
	}
	
	public void setPayments(ArrayList<Payment> payments) 
	{
		this.payments = payments;
	}

	/**
	* @param invoiceNo
	* The number of the invoice
	* @param invoiceDate
	* The date of the invoice
	* @param payments
	* A list of all the payments
	*/
	public Invoice(int invoiceNo, Date invoiceDate, ArrayList<Payment> payments) 
	{
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.payments = payments;
	}
	
	//Empty Constructor
	public Invoice()
	{
		
	}
	
	/**
	* This method updates payment information.
	* @param payment
	* The new payment information we want
	* @return updated payment successfully
	*/
	public String modifyPayment(Payment payment)
	{
		for(Payment p:payments)
		{
			if(p.getPaymentld() == payment.getPaymentld())
			{
				p.setPaymentDate(payment.getPaymentDate());
				p.setPaymentDescription(payment.getPaymentDescription());
				p.setPrice(payment.getPrice());
			}
		}
		return "Updated payment successfully";
	}
	
	/**
	* This method deletes a payment.
	* @param paymentId
	* The ID of the payment we want removed
	* @return delete payment successfully
	*/
	public String deletePayment(int paymentId)
	{
		for(Payment p:payments)
		{
			if(p.getPaymentld() == paymentId)
			{
				payments.remove(p);
			}
		}
		return "delete payment successfully";
	}
	
	/**
	* This method adds a payment.
	* @param payment
	* The information of the new payment we want to add
	* @return add payment successfully
	*/
	public String addPayment(Payment payment)
	{
		payments.add(payment);
		return "add payment successfully";
	}
	
	/**
	* This method searches for a payment and retrieves it.
	*@param paymentId
	* The ID of the payment we want removed
	* @return the payment we searched for
	*/
	public Payment getPayment(int paymentId)
	{
		for(Payment p:payments)
		{
			if(p.getPaymentld() == paymentId)
			{
				return p;
			}
		}
		
		return null;
	}
	
	/**
	* This method finds the total amount in the invoice
	* @return total payment of the invoice
	*/
	public double calculateTotalPayment()
	{
		double total=0;
		
		for(Payment p:payments)
		{
			total=total+p.getPrice();
		}
		return total;
	}

	/**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return "Invoice:\nInvoice Number: " + invoiceNo + "\nInvoice Date: " + invoiceDate + payments + "\n";
	}
	
	
}
