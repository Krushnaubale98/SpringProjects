package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.VotingElgibilityCheckService;

public class SpringBeanLifeCycle_AnnotationTest {

	public static void main(String[] args) {

		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get spring bean class object from the ioc container
		VotingElgibilityCheckService service = ctx.getBean("voter", VotingElgibilityCheckService.class);

		// invoke the business method
		String result = service.checkVotingElgibility();
		System.out.println(result);
		ctx.close();
	}

}
