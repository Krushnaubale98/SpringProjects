package com.nit.comps;

import java.time.LocalDateTime;

public class WishMessageGenerator {

	// has-A property

	private LocalDateTime ldt;

	// constructor
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator: 0-para constructor");
	}

	// setter method in support of Dependency Management
	public void setLdt(LocalDateTime ldt) {
		System.out.println("WishMessageGenerator: setLdt()");
		this.ldt = ldt;
	}

	// business method the injected/assigned dependent class object
	public String generateWishMessage(String user) {

		// get current hour of the day
		int hour = ldt.getHour();

		// generate wish message

		if (hour < 12) {
			return "Good Morning " + user;
		} else if (hour < 16) {
			return "Good Afternood " + user;
		} else if (hour < 20) {
			return "Good Evening " + user;
		} else {
			return "Good Night " + user;
		}
	}

}
