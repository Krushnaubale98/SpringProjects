package com.nt.sbeans;


import org.springframework.stereotype.Component;

//dependent class
@Component("fFlight")
public class FirstFlight implements Courier {

	public FirstFlight() {
		System.out.println("FirstFlight: 0-para constructor");
	}

	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");
		return oid + " order id order the products are given for delivery to FirstFlight courier service";
	}

}
