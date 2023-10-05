package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EcommerceStore;

public class AfterReturningAdviceTest {
	public static void main(String[] args) {

		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get proxy class object
		EcommerceStore proxy = ctx.getBean("ecommerceService", EcommerceStore.class);

		// invoke the business method
		double billAmt = proxy.shopping(new String[] { "shirt", "trouser" }, new double[] { 5000, 10000 });
		System.out.println("Bill amount is:: " + billAmt);

		ctx.close();
	}
}
