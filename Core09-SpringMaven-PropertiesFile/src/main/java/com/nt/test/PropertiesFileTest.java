package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.PersonsInfo;

public class PropertiesFileTest {

	public static void main(String args[]) {
		// create IOC container

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get spring bean class object
		PersonsInfo info = ctx.getBean("per", PersonsInfo.class);

		// display spring bean object data

		System.out.println(info);
		
		//close the ioc container 
		ctx.close();
	}
}
