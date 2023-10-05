package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.sbeans.WishMessageGenerator;

public class JavaConfigAppTest {
	public static void main(String[] args) {

		// create IOC container

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// loads config class

		//get the Target class objects
		WishMessageGenerator generator=ctx.getBean("wmg" ,WishMessageGenerator.class);
		
		//invoke the business method
		String result=generator.generateMessge("Krushna");
		System.out.println(result);
		ctx.close();
	}
}
