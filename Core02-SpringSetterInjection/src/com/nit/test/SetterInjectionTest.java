package com.nit.test;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nit.sbeans.WishMessageGenerator;

public class SetterInjectionTest {
	public static void main(String[] args) {

		// create IOC container
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(
				"F:/NIT/eclipse-spring-workspace/Proj2-SpringSetterInjection/src/com/nit/cfgs/applicationContext.xml");
		// get target spring bean class object
		Object obj = ctx.getBean("wmg");

		// TypeCasting
		WishMessageGenerator generator = (WishMessageGenerator) obj;

		// or
		// WishMessageGenerator ob = (WishMessageGenerator) ctx.getBean("wmg");

		// invoke the business method
		String result = generator.generateWishMessage("Raja");
		System.out.println(result);
		
		//close IOC container
		ctx.close();
	}

}
