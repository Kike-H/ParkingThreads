package com.app;

import java.util.Random;

public class ThreadVehicle extends Thread {
	private Count count;

	public ThreadVehicle(Count count) {
		this.count = count;
	}

	@Override
	public void run() {
		Random random = new Random();
		try {
			Thread.sleep(random.nextInt(2000));
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Going out "+Thread.currentThread().getName());
		this.count.increaseCount(10);
	}
}
