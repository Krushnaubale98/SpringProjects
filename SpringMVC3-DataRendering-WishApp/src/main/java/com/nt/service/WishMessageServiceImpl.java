package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMessageServiceImpl implements IWishMessageService {

	@Override
	public String generateWishMessage() {

		// get the System date and time
		LocalDateTime ldt = LocalDateTime.now();

		// get the current hour hour of the day

		int hour = ldt.getHour();

		// generate the wishMessage
		if (hour < 12)
			return "Good Morning";
		else if (hour < 16)
			return "Good AfterNoon";
		else if (hour < 20)
			return "Good Evening";
		else
			return "Good Night";
	}

}
