/**
 * 14-4-2021
 * @author Sarah Al-Qersh and Salma Eletreby
 * @version 1
 * Created on 14/4/2021
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

public class CarRepositery {
	/**gets data of cars from files*/
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
	
	/**saves data of cars to files*/
	static void saveDate(ObservableList<Car> car)
	{
		FileOutputStream fOut;
    	ObjectOutputStream oOut;
    	
    	try
    	{
    		fOut = new FileOutputStream("data/Cars.dat");
    	    oOut = new ObjectOutputStream(fOut);
    	    
    	    for(Car c: car)
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
