package com.nt.comps;

public class FirstFlight implements Courier {

	// constructor
	public FirstFlight() {
		System.out.println("FirstFlight: 0-param constructor");
	}

	public String deliver(int oid) {
		System.out.println("FirstFlight.deliver()");
		return oid + " Order id order products are given for delivery to FirstFlight courier service";
	}

}
