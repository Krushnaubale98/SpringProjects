package com.nt.comps;

import java.util.Random;

public class Customer implements Person {
	public Customer() {
		System.out.println("Customer : 0-para constructor");
	}

	@Override
	public void doTask() {
		System.out.println("Customer is purchasing product of price: " + new Random().nextInt(1000));
	}

}
