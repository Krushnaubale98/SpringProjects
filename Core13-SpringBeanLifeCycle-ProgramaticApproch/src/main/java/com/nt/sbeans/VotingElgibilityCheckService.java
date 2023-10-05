package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//sbean
@Component("voter")
public class VotingElgibilityCheckService implements InitializingBean, DisposableBean {

	// Spring bean properties
	@Value("${per.name}")
	private String name;

	@Value("${per.age}")
	private int age;

	@Value("${per.addrs}")
	private String addrs;

	private Date dov;

	// business method
	public String checkVotingElgiblity() {

		System.out.println("VotingCheckElgibilityCheckService.checkVotingElgiblity()(Business methods)");

		if (age >= 18)
			return "Mr/Miss/Mrs " + name + " you are Elgible to the vote on date " + dov;
		else
			return "Mr/Miss/Mrs " + name + " you are not Elgible to the vote on date " + dov;

	}// end of b.method

	// equalent to custom init method
	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("VotingCheckElgibilityCheckService.afterPropertiesSet()(init life cycle method)");

		dov = new Date();// initializing the left over property
		// verifying whether important properties are injected properly or not

		if (age <= 0 || name == null)
			throw new IllegalArgumentException("Invalid input");
	}

	// equalent to custom destroy method
	@Override
	public void destroy() throws Exception {
		System.out.println("VotingCheckElgibilityCheckService.destroy()(custome destroy() method)");
		name = null;
		age = 0;
		addrs = null;
		dov = null;

	}

}
