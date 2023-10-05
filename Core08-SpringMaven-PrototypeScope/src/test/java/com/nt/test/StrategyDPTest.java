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

		System.out.println("\n============prototype scope=======");

		// IOC container creation
		ClassPathXmlApplicationContext ctx1 = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("ioc container created...");

		// get target spring bean classs object
		Flipkart fpkt1 = ctx1.getBean("fpkt", Flipkart.class);
		Flipkart fpkt2 = ctx1.getBean("fpkt", Flipkart.class);

		System.out.println("fpkt1==fpkt2 " + (fpkt1 == fpkt2)); // false
		
		System.out.println(fpkt1.hashCode() +"...."+fpkt2.hashCode());

		// close the IOC container
		ctx.close();

	}

}
