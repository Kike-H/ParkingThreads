package com.app;

import java.util.Scanner;

class App {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		Count count = new Count();

		System.out.print("Introduce the amount of cars: ");
		int amount_cars = scan.nextInt();
		Thread[] cars = new Thread[amount_cars];
		
		System.out.print("Introduce the amount of motorcycles: ");
		int amount_motorcycles = scan.nextInt();
		Thread[] motorcycles = new Thread[amount_motorcycles];

		System.out.println();

		scan.close();

		for (int i = 0; i < amount_cars; i++) {
			ThreadVehicle tc = new ThreadVehicle(count);
			tc.setName("Car "+(i+1));
			cars[i] = tc;
		}
		
		for (int i = 0; i < amount_motorcycles; i++) {
			ThreadVehicle tm = new ThreadVehicle(count);
			tm.setName("Motorcycle "+(i+1));
			motorcycles[i] = tm;
		}

		for (Thread car : cars) {
			car.start();
			Thread.sleep(200);
		}

		for (Thread motorcycle : motorcycles) {
			motorcycle.start();
			Thread.sleep(200);
		}

		System.out.println("The total amount is of: "+count.getCount());
	} 
}
