package com.nt.comps;

public class DHL implements Courier {

	// constructor
	public DHL() {
		System.out.println("DHL: o-prara constructor");
	}

	public String deliver(int oid) {
		System.out.println("DHL.deliver()");
		return oid + " Order id order products are given for delivery to FirstFlight courier service";
	}

}
