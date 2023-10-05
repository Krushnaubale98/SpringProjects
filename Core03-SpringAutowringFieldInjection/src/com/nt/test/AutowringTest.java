package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.SessionFinder;

public class AutowringTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// Create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get target spring bean class object from IOC container

		SessionFinder finder = (SessionFinder) ctx.getBean("sf");

		// invoke the business method
		String result = finder.findSession("raja");
		System.out.println(result

		);
	}
}
