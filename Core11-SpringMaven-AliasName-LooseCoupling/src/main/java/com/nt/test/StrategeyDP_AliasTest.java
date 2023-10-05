package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Flipkart;

public class StrategeyDP_AliasTest {

	public static void main(String[] args) {

		// create the ioc container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfg/applicationContext.xml");
		System.out.println("ioc container created....");

		// get the target bean class object
		Flipkart fpkt = ctx.getBean("fpkt", Flipkart.class);

		// invoke the business method
		String result = fpkt.shopping(new String[] { "shirt", "pant", "shoe" },
				new double[] { 10000.0, 20000.0, 30000.0 });
		System.out.println(result);
		ctx.close();

	}
}