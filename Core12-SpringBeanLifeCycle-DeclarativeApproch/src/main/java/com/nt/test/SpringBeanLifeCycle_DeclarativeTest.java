package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.VotingEligibilityCheckService;

public class SpringBeanLifeCycle_DeclarativeTest {

	public static void main(String[] args) {
		//create IOC container
		 ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 // get Spring Bean class object from IOC container
		 VotingEligibilityCheckService service=ctx.getBean("voter",VotingEligibilityCheckService.class);
		 //invoke the b.method
		 String result=service.checkVotingEligibility();
		 System.out.println(result);
		 
		 //close container
		 ctx.close();

	}

}
