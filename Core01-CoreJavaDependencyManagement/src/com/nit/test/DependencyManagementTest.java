package com.nit.test;

import java.time.LocalDateTime;

import com.nit.comps.WishMessageGenerator;

public class DependencyManagementTest {
	public static void main(String[] args) {

		// create target and dependent class objects

		LocalDateTime sysDateTime = LocalDateTime.now(); // dependent class

		WishMessageGenerator generator = new WishMessageGenerator(); // target clas

		// assign dependent class object into target class object
		generator.setLdt(sysDateTime); // Dependency management

		// invoke the business method on target class
		String result = generator.generateWishMessage("raja");
		System.out.println(result

		);
	}

}
