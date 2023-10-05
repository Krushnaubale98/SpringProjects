package com.nt.sbeans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SessionFinder {

	@Autowired
	private Calendar cal;

	// constructor
	public SessionFinder() {
		System.out.println("SessionFinder:0-para constructor");
	}

	// business method
	public String findSession(String user) {

		// get current method
		int month = cal.get(Calendar.MONTH);

		// generate session name

		if (month >= 2 && month <= 5)
			return "Welcome to Summer session :" + user;
		else if (month >= 6 & month <= 9)
			return "Welcome to Rainy session :" + user;
		else
			return "Welcome to Winter session :" + user;
	}

}
