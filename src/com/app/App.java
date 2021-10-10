package com.app;

import java.util.Scanner;

class App {
	public static void main(String[] args) throws InterruptedException {
		// Variables
		Scanner scan = new Scanner(System.in);
		Count count = new Count();

		// Get the cars 
		System.out.print("Introduce the amount of cars: ");
		int amount_cars = scan.nextInt();
		Thread[] cars = new Thread[amount_cars];
		
		// Get the motorcycles
		System.out.print("Introduce the amount of motorcycles: ");
		int amount_motorcycles = scan.nextInt();
		Thread[] motorcycles = new Thread[amount_motorcycles];

		System.out.println();

		scan.close();

		// Make the threads for each vehicle
		for (int i = 0; i < amount_cars; i++) {
			ThreadVehicle tc = new ThreadVehicle(count);
			tc.setName("Car "+(i+1));
			cars[i] = tc;
			cars[i].start(); // Execute the thread for car
		}
		
		for (int i = 0; i < amount_motorcycles; i++) {
			ThreadVehicle tm = new ThreadVehicle(count);
			tm.setName("Motorcycle "+(i+1));
			motorcycles[i] = tm;
			motorcycles[i].start(); // Execute the thread for motorcycle
		}

		for (Thread car : cars) {
			car.join();
			Thread.sleep(200);
		}

		for (Thread motorcycle : motorcycles) {
			motorcycle.join();
			Thread.sleep(200);
		}

		System.out.println("The total amount for "+( amount_motorcycles + amount_cars )+" vehicles is : "+count.getCount());
	} 
}
