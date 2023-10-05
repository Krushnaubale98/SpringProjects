package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("bDart")
//@Lazy(true)
public class BlueDart implements Courier {

	public BlueDart() {
		System.out.println("BlueDart:: 0-para constructor...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");

		return oid + " order id order the product  are given for delivery to BlueDart courier sevice ";
	}

}
