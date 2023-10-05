package com.nt.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class AspectAOPAroundAdviceTest {

	public static void main(String[] args) {

		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get proxy class object
		BankService proxy = ctx.getBean("bankService", BankService.class);

		// invoke the business method
		System.out.println("Simple interst amount : " + proxy.calcSimpleIntrestAmount(10000, 2, 12));
		System.out.println("Compound intrest amount: " + proxy.calcCompoundIntrestAmount(100000, 2, 12));
		ctx.close();
	}

}
