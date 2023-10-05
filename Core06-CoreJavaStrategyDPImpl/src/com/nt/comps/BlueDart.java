package com.nt.comps;

public class BlueDart implements Courier {

	// constructor
	public BlueDart() {
		System.out.println("BlueDart: o-prara constructor");
	}

	public String deliver(int oid) {
		System.out.println("BlueDart.deliver()");
		return oid + " Order id order products are given for delivery to FirstFlight courier service";
	}

}
