package com.nt.sbeans;

import org.springframework.stereotype.Component;

//Dependent class
@Component("bDart")
public class BlueDart implements Courier {

	public BlueDart() {

		System.out.println("BlueDart: 0-para constructor)");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");

		return oid + "Order  id order products are given for delivery to BlueDart courier service";
	}

}
