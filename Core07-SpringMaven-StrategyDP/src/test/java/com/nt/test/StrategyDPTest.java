package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Flipkart;

public class StrategyDPTest {

	public static void main(String[] args) {

		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get target spring bean class object
		Flipkart fpkt = ctx.getBean("fpkt", Flipkart.class);

		// invoke the business method
		String result = fpkt.shopping(new String[] { "shirt", "trouser", "shoe" },
				new double[] { 10000, 20000, 30000 });

		System.out.println(result);

		
		// close the IOC container
		ctx.close();

	}

}
