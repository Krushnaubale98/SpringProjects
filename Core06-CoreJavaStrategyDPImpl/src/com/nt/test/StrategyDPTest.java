package com.nt.test;

import com.nt.comps.Flipkart;
import com.nt.factory.FlipkartFactory;

public class StrategyDPTest {
	public static void main(String[] args) {

		// get target class object
		Flipkart fpkt = FlipkartFactory.getInstance("bDart");

		// invoke the business method
		String msg = fpkt.shopping(new String[] { "shirt", "shoe", "dhoti" },
				new double[] { 3000.0, 45000.0, 65400.0 });
		System.out.println(msg);
	}
}
