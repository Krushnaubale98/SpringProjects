//ThrowsAdviceTest.java
package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Proxy class object
		ShoppingStore proxy = ctx.getBean("store", ShoppingStore.class);
		// invoke the b.method
		try {
			double billAmt = proxy.generateBill(new String[] { "shirt", "trouser", "hat", "sofa" },
					new double[] { 4000.0, 6000.0, 3000.0, 40000.0 });
			System.out.println("final bill amount is ::" + billAmt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("_____________________");

		try {
			double billAmt = proxy.generateBill(new String[] {}, new double[] { 4000.0, 6000.0, 3000.0, 40000.0 });
			System.out.println("final bill amount is ::" + billAmt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// close the containr
		ctx.close();

	}
	

}
