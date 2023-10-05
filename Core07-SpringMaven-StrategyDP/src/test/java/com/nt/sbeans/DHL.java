package com.nt.sbeans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
//dependent class
@Component("dhl")
@Lazy(true)
public class DHL implements Courier {

	public DHL() {
		System.out.println("DHL: o-para constructor");
	}

	public String deliver(int oid) {
		System.out.println("DHL.deliver()");
		return oid + " Order id ordeer the products are given for the delicer to DHL courier service";
	}
}
