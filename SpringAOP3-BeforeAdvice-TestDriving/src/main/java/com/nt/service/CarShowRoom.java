package com.nt.service;

import org.springframework.stereotype.Service;

@Service("showRoom")
public class CarShowRoom {

	public String purchase(String carModel, double price, double discountPercentage) {
		double finalPrice = price - (price * discountPercentage / 100);
		return carModel + " Car is purchased :: price: " + price + " price after discount:: " + finalPrice;
	}
}
