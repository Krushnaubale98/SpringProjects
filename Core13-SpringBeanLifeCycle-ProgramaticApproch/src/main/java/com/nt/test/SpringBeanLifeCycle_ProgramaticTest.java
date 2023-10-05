package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.VotingElgibilityCheckService;

public class SpringBeanLifeCycle_ProgramaticTest {

	public static void main(String[] args) {

		// create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get the spring bean object from the container
		VotingElgibilityCheckService service = ctx.getBean("voter", VotingElgibilityCheckService.class);

		// invoke the business method
		String result = service.checkVotingElgiblity();
		System.out.println(result);
		ctx.close();

	}

}
