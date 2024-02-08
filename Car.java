package com.sarin.car;

public class Car {
	private String carId;
	private String carBrand;
	private String carModel;
	private double carPricePerDay;
	private boolean isAvailable;
	
	
	public Car(String carId, String carBrand, String carModel, double carPricePerDay) {
		super();
		this.carId = carId;
		this.carBrand = carBrand;
		this.carModel = carModel;
		this.carPricePerDay = carPricePerDay;
		this.isAvailable=true;
	
	}




	public String getCarId() {
		return carId;
	}


	public String getCarBrand() {
		return carBrand;
	}


	public String getCarModel() {
		return carModel;
	}


	public double getCarPricePerDay() {
		return carPricePerDay;
	}


	public boolean isAvailable() {
		return isAvailable;
	}
	
	public double calculatePrice(int days)
	{
		return this.carPricePerDay*days;
	}
	
	
	public void rentCar() {
		isAvailable = false;
	}
	
	public void returnCar()
	{
		isAvailable = true;
	}
	
	
}
