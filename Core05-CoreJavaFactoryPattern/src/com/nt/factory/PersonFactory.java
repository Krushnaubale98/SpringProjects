package com.nt.factory;

import com.nt.comps.Customer;
import com.nt.comps.Employee;
import com.nt.comps.Person;
import com.nt.comps.Student;

public class PersonFactory {
//static factory method having factory pattern logic(creating and returning  one of the 
//	several related class object)

	

	public static Person getPerson(String type) {
		// factory pattern logic
		Person per = null;
		if (type.equalsIgnoreCase("stud"))
			per = new Student();
		else if (type.equalsIgnoreCase("emp"))
			per = new Employee();
		else if (type.equalsIgnoreCase("cust"))
			per = new Customer();
		else
			throw new IllegalArgumentException("Invalid person type");
		return per;
	}
}
