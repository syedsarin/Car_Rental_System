package com.sarin.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
	private List<Car> cars;
	private List<Customer> customers;
	private List<CarRental> carRentals;
	Scanner sc = new Scanner(System.in);
	public CarRentalSystem() {
		super();
		cars = new ArrayList<Car>();
		customers = new ArrayList<Customer>();
		carRentals = new ArrayList<CarRental>();
	}
	
	public void addCar(Car car)
	{
		cars.add(car);
	}
	public void addCustomer(Customer customer)
	 {
		customers.add(customer);
	 }
	
	public void rentCar(Car car, Customer customer, int day)
	{
		if(car.isAvailable())
		{
			car.rentCar();
			carRentals.add(new CarRental(car, customer, day));
		}
		else
		{
			System.out.println("Sorry Car is Not Available For Rent. ");
		}
	}
	public void returnCar(Car car)
	{
		car.returnCar();
		CarRental rentalToRemove = null;
		for(CarRental rental : carRentals)
		{
			if(rental.getCar()==car)
			{
				rentalToRemove = rental;
				break;
			}
			
		}
			if(rentalToRemove!=null)
			{
				 carRentals.remove(rentalToRemove);
				 	//System.out.println("Car returned Successfully.");
				 
			}
			else {
				System.out.println("Car Was Not Rented.");
			}
		}
	
	
		public void menu()
		{
			Scanner sc = new Scanner(System.in);
			while(true) {
		
			System.out.println("*****Car Rental System*****");
			System.out.println("1. Rent a Car :");
			System.out.println("2. Return a Car :");
			System.out.println("3. Exit");
			
			System.out.print("Enter Your Choice :");
			int choice = sc.nextInt();
			if(choice==1)
			{
				System.out.println("\n==Rent a Car==\n");
				System.out.println("Enter Your Name: ");
				String customerName = sc.nextLine();
				customerName = sc.nextLine();
				
				
				System.out.println("\nAvailable Cars: ");
				for(Car car : cars)
				{
					if(car.isAvailable()) {
						System.out.println(car.getCarId()+" "+ car.getCarBrand()+" "+ car.getCarModel());
					}
				}
				System.out.print("Enter the Car ID you Want to Rent :");
				String carId = sc.nextLine();
				
				System.out.print("Enter thr Number of Days For Rent :");
				int rentalDays = sc.nextInt();
				sc.nextLine();
				
				Customer newCustomer = new Customer("CUS"+(customers.size()+1), customerName);
				addCustomer(newCustomer);
				
				Car selectedCar = null;
				for(Car car: cars)
				{
					if(car.getCarId().equals(carId) && car.isAvailable())
					{
						selectedCar = car;
						break;
					}
				}
				
				if(selectedCar!=null)
				{
					double totalPrice = selectedCar.calculatePrice(rentalDays);
					System.out.println("\n==Rental Information==\n");
					System.out.println("Customer ID :"+newCustomer.getCustomerId());
					System.out.println("Customer Name :"+newCustomer.getCustomerName());
					System.out.println("Car :"+ selectedCar.getCarBrand()+" "+ selectedCar.getCarBrand());
					System.out.println("Rentals Days :"+rentalDays);
					System.out.println("Total Price : $"+totalPrice);
					
					System.out.println("\nConfirm Rental (Yes/No) :");
					String confirm = sc.nextLine();
					
					
					if(confirm.equalsIgnoreCase("Yes"))
					{
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("\nCar Rented Succeffully. :");
					}
					else
					{
						System.out.println("\nRental Canceled.");
					}
					
				}
				else
				{
					System.out.println("Invalid Car Selection or Car Not Available for rent.");
				}
			}
			else if(choice==2)
			{
				System.out.println("\n==Return a Car==\n");
				System.out.println("Enter The Car ID You Want to Return :");
				String carId = sc.nextLine();
				carId = sc.nextLine();
				
				Car carToReturn = null;
				for(Car car : cars)
				{
					if(car.getCarId().equals(carId) && !car.isAvailable())
					{
						carToReturn=car;
					}
				}
				
				if(carToReturn!=null)
				{
					Customer customer = null;
					for(CarRental rental : carRentals)
					{
						if(rental.getCar()== carToReturn)
						{
						  customer = rental.getCustomer();
						  break;
						}
					}
					if(customer!=null)
					{
						returnCar(carToReturn);
						System.out.println("Car returned Successfully by :"+ customer.getCustomerName());
					}
					else {
						System.out.println("Car was Not rented or rental information is missing.");
					}
					
				}
				else {
					System.out.println("Invalid Car ID or Car is not rented.");
				}
			}
				else if(choice ==3)
				{	
					break;
				}
				else {
					System.out.println("\nThank you for using the Car Rental System!");
			}
		}
			sc.close();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
