package com.nit.sbeans;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;

@Component("wmg") // to cfg java class as spring bean
public class WishMessageGenerator {

	// Has-A property
	private LocalDateTime ldt;

	// constructor
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator: 0-para constructor");
	}

	@Autowired
	public void setLdt(LocalDateTime ldt) {
		System.out.println("WishMessageGenerator.setLdt()");
		this.ldt = ldt;
	}

	// business method

	public String generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage()");

		// get current hour of the day
		int hour = ldt.getHour();

		// generate WishMessage
		if (hour < 12)
			return "Good Morning " + user;
		else if (hour < 16)
			return "Good AfterNoon " + user;
		else if (hour < 20)
			return "Good Evening " + user;
		else
			return "Good Night " + user;

	}
}
