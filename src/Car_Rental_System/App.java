package Car_Rental_System;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

/**
* @author Salma Shady 202005204
* @version 1.0
* Created on: 07/04/2021
*/

public class App 
{

	public static void main(String[] args) 
	{
		//Car object
		Car c1 = new Car("SA202","2019",CarType.SEDAN,true);
		System.out.println(c1);
		
		//Customer object
		Customer cus1 = new Customer(79956,"Salma Shady","0339787","random street","Egyptian","SE58");
		System.out.println(cus1);
		
		//Resident object
		Resident res1 = new Resident (78956,"Choi san","0339787","fifth street","Korean","CS29",3018);
		System.out.println(res1);
		
		//Visitor object
		Date d1 = new Date (2016,4,13);
		Date d2 = new Date (2020,7,15);
		Visitor vis1 = new Visitor (78956,"Song Mingi","0339787","sixth street","Korean","CS29",3018,d1,d2);
		System.out.println(vis1);
		
		//Payment object
		Date d3 = new Date (2021,04,13);
		Payment p1 = new Payment("cash",208,20015,d3);
		System.out.println(p1);
		
		//Invoice object
		ArrayList<Payment> payment = new ArrayList <Payment>();
		
		Date d4 = new Date (2021,2,12);
		Payment p2 = new Payment("cash",118,3000,d4);
		Date d5 = new Date (2021,3,14);
		Payment p3 = new Payment("credit",365,2000,d5);
		Date d6 = new Date (2021,4,21);
		Payment p4 = new Payment("check",729,5000,d6);
		
		payment.add(p2);
		payment.add(p3);
		payment.add(p4);
		
		Date d7 = new Date (2021,7,5);
		Invoice inv1 = new Invoice(27,d7,payment);
		System.out.println(inv1);
		
		//TotalPayment method
		System.out.println(inv1.calculateTotalPayment());
		
		//GetPayment method
		System.out.println(inv1.getPayment(365));
		
		//AddPayment method
		Date d8 = new Date (2021,9,15);
		Payment newP = new Payment("cash",328,7000,d8);
		System.out.println(inv1.addPayment(newP));
		System.out.println(inv1);
		
		//DeletePayment method
		System.out.println(inv1.deletePayment(729));
		System.out.println(inv1);
		
		//ModifyPayment
		Date d9 = new Date (2021,10,28);
		Payment updatedp = new Payment("cash",365,1000,d9);
		System.out.println(inv1.modifyPayment(updatedp));
		System.out.println(inv1);
		
		//Rental object
		Customer cus2 = new Customer(18856,"Jean de Arch","0789787","french street","French","JA26");
		Car c2 = new Car("DE202","2006",CarType.SUV,false);
		LocalDate dat1 = LocalDate.of(2017, 2, 28);
		LocalDate dat2 = LocalDate.of(2019, 3, 2);
		
		ArrayList<Payment> payment2 = new ArrayList <Payment>();
		
		Date d10 = new Date (2021,2,12);
		Payment p5 = new Payment("cash",123,1000,d10);
		Date d11 = new Date (2021,3,14);
		Payment p6 = new Payment("credit",456,500,d11);
		Date d12 = new Date (2021,4,21);
		Payment p7 = new Payment("check",789,200,d12);
		
		payment2.add(p5);
		payment2.add(p6);
		payment2.add(p7);
		
		Date d13 = new Date (2021,7,5);
		Invoice inv2 = new Invoice(15,d13,payment2);
		
		Rental r1 = new Rental (268,cus2,c2,dat1,dat2,inv2);
		System.out.println(r1);
		
		//FCOM rental class 
		ArrayList <Customer> customer = new ArrayList <Customer>();
		
		Customer cus3 = new Customer(123456,"Archer","010234","Emiya street","Japanese","AR12");
		Customer cus4 = new Customer(789101,"Saber","010567","Arthur street","English","SA34");
		Customer cus5 = new Customer(112131,"Rider","010891","Alexandria street","Greek","RI78");
		
		customer.add(cus3);
		customer.add(cus4);
		customer.add(cus5);
		
		ArrayList <Car> car = new ArrayList <Car>();
		
		Car c3 = new Car("AB23","2007",CarType.SUV,false);
		Car c4 = new Car("CD27","2002",CarType.TRUCK,false);
		Car c5 = new Car("EF89","2020",CarType.VAN,false);
		Car c6 = new Car("GH10","1999",CarType.SEDAN,true);
		
		car.add(c3);
		car.add(c4);
		car.add(c5);
		car.add(c6);
		
		ArrayList <Rental> rental = new ArrayList <Rental>();
		
		LocalDate Ldate1 = LocalDate.of(2019, 2, 28);
		LocalDate Ldate2 = LocalDate.of(2021, 3, 2);
		
		ArrayList<Payment> payment_1 = new ArrayList <Payment>();
		
		Date date1 = new Date (2020,2,12);
		Payment pay1 = new Payment("cash",1011,1000,date1);
		Date date2 = new Date (2020,3,14);
		Payment pay2 = new Payment("credit",1213,2000,date2);
		Date date3 = new Date (2020,4,21);
		Payment pay3 = new Payment("check",1415,3000,date3);
		
		payment_1.add(pay1);
		payment_1.add(pay2);
		payment_1.add(pay3);
		
		Date invDate1 = new Date (2019,2,18);
		Invoice invoice1 = new Invoice(1,invDate1,payment_1);
		
		Rental rental_1 = new Rental (246,cus3,c3,Ldate1,Ldate2,invoice1);
		
		LocalDate Ldate3 = LocalDate.of(2018, 6, 15);
		LocalDate Ldate4 = LocalDate.of(2020, 2, 6);
		
		ArrayList<Payment> payment_2 = new ArrayList <Payment>();
		
		Date date4 = new Date (2019,5,3);
		Payment pay4 = new Payment("cash",1617,4000,date4);
		Date date5 = new Date (2019,6,18);
		Payment pay5 = new Payment("credit",1819,5000,date5);
		Date date6 = new Date (2019,7,30);
		Payment pay6 = new Payment("check",2021,6000,date6);
		
		payment_2.add(pay4);
		payment_2.add(pay5);
		payment_2.add(pay6);
		
		Date invDate2 = new Date (2018,3,28);
		Invoice invoice2 = new Invoice(2,invDate2,payment_2);
		
		Rental rental_2 = new Rental (135,cus4,c4,Ldate3,Ldate4,invoice2);
		
		Rental rental_3 = new Rental (135,cus3,c5,Ldate3,Ldate4,invoice2);
		
		rental.add(rental_1);
		rental.add(rental_2);
		rental.add(rental_3);
		
		FCom_Rental_System rent_syst = new FCom_Rental_System(customer,car,rental);
		System.out.println(rent_syst);
		
		//write to file
		rent_syst.saveDate();
		
		//Available cars by date method
		LocalDate availableDate = LocalDate.of(2021, 12, 7);
		System.out.println(rent_syst.getAvailableCarsByDate(availableDate));
		
		//Find Car rentals by customer
		System.out.println(rent_syst.findCarRentalByCustomerId(123456));
		
		//Get available cars
		System.out.println(rent_syst.getCarByAvailability(true));
		
		//Find a certain car method
		System.out.println(rent_syst.findCar("EF89"));
		
		//Find customer using ID method
		System.out.println(rent_syst.findCustomer(789101));
		
		//Add customer method
		Customer cus6 = new Customer(1415161,"Mage","010786","Roman street","Italian","MA91");
		System.out.println(rent_syst.addCustomer(cus6));
		System.out.println(rent_syst.getCustomers());
		
		//Add Car method
		Car c7 = new Car("EF98","2015",CarType.SUV,true);
		System.out.println(rent_syst.addCar(c7));
		System.out.println(rent_syst.getCars());
		
		//Booking a car rental method
		
		LocalDate Ldate5 = LocalDate.of(2019, 2, 28);
		LocalDate Ldate6 = LocalDate.of(2021, 3, 2);
		
		ArrayList<Payment> payment_3 = new ArrayList <Payment>();
		
		Date date7 = new Date (2020,2,12);
		Payment pay7 = new Payment("cash",1011,1000,date1);
		Date date8 = new Date (2020,3,14);
		Payment pay8 = new Payment("credit",1213,2000,date2);
		Date date9 = new Date (2020,4,21);
		Payment pay9 = new Payment("check",1415,3000,date3);
		
		payment_1.add(pay7);
		payment_1.add(pay8);
		payment_1.add(pay9);
		
		Date invDate3 = new Date (2019,2,18);
		Invoice invoice3 = new Invoice(101,invDate1,payment_3);
		
		Rental rental_4 = new Rental (246,cus5,c6,Ldate5,Ldate6,invoice3);
		
		rent_syst.bookCarRental(rental_4);
		System.out.println(rent_syst.getCars());
		
		//Car returned method
		rent_syst.returnCar("AB23");
		System.out.println(rent_syst.getCars());
		
		//Delete car rental method
		rent_syst.deleteCarRental(789101);
		System.out.println(rent_syst.getCars());
		
		//Deletes a customer method 
		System.out.println(rent_syst.deleteCustomer(112131));
		System.out.println(rent_syst.getCustomers());
		
		//delete car method
		System.out.println(rent_syst.deleteCar("AB23"));
		System.out.println(rent_syst.getCars());
		
		//write to file
		//rent_syst.saveDate();
		
		//load data
		rent_syst.loadData();
	}

}