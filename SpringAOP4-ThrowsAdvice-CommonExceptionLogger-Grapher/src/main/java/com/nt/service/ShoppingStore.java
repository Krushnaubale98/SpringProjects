//ShoppingStore.java (target class)
package com.nt.service;

import org.springframework.stereotype.Component;

@Component("store")
public class ShoppingStore {

	public double generateBill(String items[], double prices[]) throws Exception {

		if (items == null || items.length == 0 || prices == null || prices.length == 0)
			throw new IllegalAccessException("Invalid inputs");

		// caculate the bill amount
		double billAmt = 0.0f;
		for (double p : prices) {
			billAmt += p;
		}
		return billAmt;
	}

}
