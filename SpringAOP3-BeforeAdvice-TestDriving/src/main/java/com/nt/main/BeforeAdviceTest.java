package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class BeforeAdviceTest {
	public static void main(String[] args) {

		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get the proxy class object
		CarShowRoom proxy = ctx.getBean("showRoom", CarShowRoom.class);

		// invoke the business method
		try {
			String result = proxy.purchase("TATA Nexon-EV", 1900000, 15.0);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ctx.close();
	}
}
