package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fpkt")
@Scope("singleton")
public final class Flipkart {

	// Has-A property type
	@Autowired
	@Qualifier("supplier")
	private Courier courier;

	public Flipkart() {
		System.out.println("Flipkart:0-para construcotr");
	}

	// business method
	public String shopping(String items[], double prices[]) {

		System.out.println("Flipkart.shopping()");

		// calculate the bill
		double billAmt = 0.0;

		for (double price : prices) {

			billAmt = billAmt + price;
		} // end of for

		// generate the order id
		int oid = new Random().nextInt(10000);

		// set the courier for the delivery
		String deliveryMsg = courier.deliver(oid);

		// display shopping details
		return Arrays.toString(items) + " are purchased having bill amt: " + billAmt + "  " + deliveryMsg;
	}

}
