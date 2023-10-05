package com.nt.sbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("voter")
public class VotingElgibilityCheckService {

	// spring bean properties

	@Value("${per.name}")
	private String name;

	@Value("${per.age}")
	private int age;

	@Value("${per.addrs}")
	private String addrs;

	private Date dov;

	// business method
	public String checkVotingElgibility() {
		System.out.println("VotingElgibilityCheckService.checkVotingElgibility()(business method)");

		if (age >= 18)
			return "Mr/Miss/Mrs " + name + " you are Elgible to vote on date " + dov;
		else
			return "Mr/Miss/Mrs " + name + " you are not Elgible to vote on date " + dov;

	}

	// custom init method
	@PostConstruct
	public void init() {
		dov = new Date();// initializing the left over property
		// verifying the whether important properties are injected properly are not
		System.out.println("VotingElgibilityCheckService.init()(init life cycle method)");
		if (name == null || age <= 0) {
			throw new IllegalArgumentException("Invalid input");
		}
	}

	// custom destory method
	@PreDestroy
	public void destroy() {
		System.out.println("VotingElgibilityCheckService.destroy()(custome destroy() method)");
		name = null;
		age = 0;
		addrs = null;
		dov = null;
	}
}
