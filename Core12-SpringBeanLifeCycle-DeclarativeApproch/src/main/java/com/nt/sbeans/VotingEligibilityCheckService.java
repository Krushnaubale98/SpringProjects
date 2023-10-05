//VotingElgibilityCheckService.java
package com.nt.sbeans;

import java.util.*;

public class VotingEligibilityCheckService {
	// spring bean properties
	private String name;
	private String addrs;
	private int age;
	private Date dov;

	// setter methods for setter Injection
	public void setName(String name) {
		System.out.println("VotingElgibilityCheckService.setName()");
		this.name = name;
	}

	public void setAge(int age) {
		System.out.println("VotingElgibilityCheckService.setAge()");
		this.age = age;
	}

	public void setAddrs(String addrs) {
		System.out.println("VotingEligibilityCheckService.setAddrs()");
		this.addrs = addrs;
	}

	// b.method
	public String checkVotingEligibility() {
		System.out.println("VotingEligibilityCheckService.checkVotingElgibility()(B.method)");
		if (age >= 18)
			return "Mr/Miss/Mrs." + name + " u r elgible to vote  on date::" + dov;
		else
			return "Mr/Miss/Mrs." + name + " u r not elgible to vote on date::" + dov;

	}// method

	// Custom init method
	public void myInit() {
		System.out.println("VotingEligibilityCheckService.myInit() (init life cyle method)");
		dov = new Date(); // initiazing the left over property
		// verifying whether important properties are injected properly or not
		if (name == null || age <= 0)
			throw new IllegalArgumentException("Invalid inputs");

	}

	// custom destory method
	public void myDestroy() {
		System.out.println("VotingEligibilityCheckService.myDestroy()(custom destroy() method)");
		name = null;
		age = 0;
		addrs = null;
		dov = null;
	}

}// class
