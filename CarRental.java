package com.sarin.car;

public class CarRental {
	private Car car;
	private Customer customer;
	private int daysForRent;
	
	public CarRental(Car car, Customer customer, int daysForRent) {
		super();
		this.car = car;
		this.customer = customer;
		this.daysForRent = daysForRent;
	}

	public Car getCar() {
		return car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getDaysForRent() {
		return daysForRent;
	}
	
	
}
