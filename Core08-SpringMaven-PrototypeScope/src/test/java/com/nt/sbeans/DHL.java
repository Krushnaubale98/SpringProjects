package com.nt.sbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//dependent class
@Component("dhl")
@Scope("prototype")
public class DHL implements Courier {

	public DHL() {
		System.out.println("DHL: o-para constructor");
	}

	public String deliver(int oid) {
		System.out.println("DHL.deliver()");
		return oid + " Order id ordeer the products are given for the delicer to DHL courier service";
	}
}
