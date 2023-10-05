package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Target class
@Component("fpkt")
public class Flipkart {

	// HAS-A property of interface type

	@Autowired
	@Qualifier("fFlight")
	private Courier courier;

	public Flipkart() {
		System.out.println("Flipkart:0-para constructor");
	}

	// business method

	public String shopping(String items[], double prices[]) {

		// Calculate bill amount

		double billAmt = 0.0; // local variable
		for (double price : prices) {
			billAmt = billAmt + price;
		} // end of for

		// generate the order id
		int oid = new Random().nextInt(1000);

		// Set the courier for delivery
		String deliveryMsg = courier.deliver(oid);

		// displaying shopping detials

		return Arrays.toString(items) + "are purchased having bill amount :  " + billAmt + "..." + deliveryMsg;

	}
}
