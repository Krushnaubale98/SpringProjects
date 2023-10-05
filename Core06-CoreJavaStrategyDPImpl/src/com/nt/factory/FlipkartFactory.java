package com.nt.factory;

import com.nt.comps.BlueDart;
import com.nt.comps.Courier;
import com.nt.comps.DHL;
import com.nt.comps.FirstFlight;
import com.nt.comps.Flipkart;

public class FlipkartFactory {
	//public static flipkart method
	public static Flipkart getInstance(String courierType) {
		System.out.println("FlipkartFactory.getInstance()");
		
		//dependent class obj
		
		Courier courier=null;
		if(courierType.equalsIgnoreCase("dhl")) {
			courier=new DHL();
			
		}else if(courierType.equalsIgnoreCase("bDart")) {
			courier=new BlueDart();
		}else if(courierType.equalsIgnoreCase("fFlight")) {
			courier=new FirstFlight();
		}else {
			throw new IllegalArgumentException("invalid courier type...");
		}
		
		//create target class object
		Flipkart fpkt=new Flipkart();
		
		//set dependent class object to target class object
		fpkt.SetCourier(courier);
		return fpkt;
		
		
		
		
		
	}

}
