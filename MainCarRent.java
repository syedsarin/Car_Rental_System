package com.sarin.car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCarRent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CarRentalSystem rentalSystem = new CarRentalSystem();
		Car car1 = new Car("\nC001", "BMW", "X7\n", 3000.0);
		Car car2 = new Car("C002", "BMW", "X1\n", 1500.0);
		Car car3 = new Car("C003", "Audi", "Q3\n", 1800);
		Car car4 = new Car("C004", "Lamborgini", " Urus\n", 10000);
		Car car5 = new Car("C005", "Mercedes", "EQ\n", 1050);
		Car car6 = new Car("C006", "Hyundai", "Creta\n", 700);
		Car car7 = new Car("C007", "Toyota", "Innova\n", 950);
		Car car8 = new Car("C008", "Mercedes", "benz\n", 2500);
		
		rentalSystem.addCar(car1);
		rentalSystem.addCar(car2);
		rentalSystem.addCar(car3);
		rentalSystem.addCar(car4);
		rentalSystem.addCar(car5);
		rentalSystem.addCar(car6);
		rentalSystem.addCar(car7);
		rentalSystem.addCar(car8);
		
		rentalSystem.menu();
		
		
	}
}
