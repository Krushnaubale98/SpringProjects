package com.nt.comps;

import java.util.Arrays;
import java.util.Random;

//target class
public final class Flipkart {
	// HAS-A property of interface type
	private Courier courier;

	public Flipkart() {
		System.out.println("Flipkart: 0-param constructor");
	}

	// setter method to assign dependent class object to target class object
	public void SetCourier(Courier courier) {
		System.out.println("Flipkart.SetCourier()");
		this.courier = courier;
	}

	// business method
	public String shopping(String items[], double prices[]) {
		System.out.println("Flipkart.shopping()");

		// calculate bills
		double billAmt = 0;

		for (double price : prices) {
			billAmt = price + billAmt;

		} // end of for

		// generate orderID
		int oid = new Random().nextInt(1000);

		// set courier for delivery
		String deliveryMsg = courier.deliver(oid);

		// display shopping details
		return Arrays.toString(items) + "are purchased having bill amount: " + billAmt + "...." + deliveryMsg;
	}// method

}// class
