package Car_Rental_System;

import java.io.Serializable;

/**
* @author Salma Shady 202005204
* @version 1.0
* Created on: 31/03/2021
*/

public class Car implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7031540959983527847L;
	/**
	* The Plate number of the Car
	*/
	private String plateNo;
	/**
	* The model of the Car
	*/
    private String model;
    /**
	* The type of the Car
	*/
    private CarType type;
    /**
	* Is the car available to rent or not
	*/
    private boolean isAvailable;
    
	public String getPlateNo() 
	{
		return plateNo;
	}
	
	public void setPlateNo(String plateNo) 
	{
		this.plateNo = plateNo;
	}
	
	public String getModel() 
	{
		return model;
	}
	
	public void setModel(String model) 
	{
		this.model = model;
	}
	
	public CarType getType() 
	{
		return type;
	}
	
	public void setType(CarType type) 
	{
		this.type = type;
	}
	
	public boolean getIsAvailable() 
	{
		return isAvailable;
	}
	
	public void setAvailable(boolean isAvailable) 
	{
		this.isAvailable = isAvailable;
	}

	/**
	* @param plateNo
	* The Plate number of the Car
	* @param model
	* The model of the Car
	* @param type
	* The type of the Car
	* @param isAvailable
	* Is the car available to rent or not
	*/
	public Car(String plateNo, String model, CarType type, boolean isAvailable) 
	{
		this.plateNo = plateNo;
		this.model = model;
		this.type = type;
		this.isAvailable = isAvailable;
	}
	
	//empty constructor
    public Car()
    {
    }

    /**Formats how the data will be on the console when output*/
	@Override
	public String toString() {
		return "\nCar:\nPlate Number: " + plateNo + "\nModel: " + model + "\nType: " + type + "\nIs the car available? " + isAvailable + "\n";
	}
}
