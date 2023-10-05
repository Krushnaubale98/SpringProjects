package com.nt.sbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fFlight")
@Scope("prototype")
public class FirstFlight implements Courier {

	public FirstFlight() {
		System.out.println("FirstFlight:: 0-para constructor...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");

		return oid + " order id order the product  are given for delivery to FirstFlight courier sevice ";
	}

}
