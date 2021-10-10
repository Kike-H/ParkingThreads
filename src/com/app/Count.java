package com.app;

public class Count {
	private int count = 0;

	public int getCount() {
		return this.count;
	}

	public void increaseCount(int amount) {
		this.count+=amount;
	}
}
