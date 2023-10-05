package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ILoginMgmtService;

public class SimpleJdbcCallTest {
	public static void main(String[] args) {

		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get the service class object
		ILoginMgmtService service = ctx.getBean("loginService", ILoginMgmtService.class);

		// invoke the business method
		String result = service.singnIn("raj1a", "rani");
		System.out.println(result);

		ctx.close();
	}
}
