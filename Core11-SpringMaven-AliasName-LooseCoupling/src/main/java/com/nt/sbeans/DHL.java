package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dhl")
@Lazy(true)
public class DHL implements Courier {

	public DHL() {
		System.out.println("DHL:: 0-para constructor...");
	}

	@Override
	public String deliver(int oid) {
		System.out.println("DHL.deliver()");

		return oid + " order id order the product  are given for delivery to DHL courier sevice ";
	}

}
