package com.nt.test;

import com.nt.comps.Person;
import com.nt.factory.PersonFactory;

public class FactoryPatternTest {
	public static void main(String[] args) {
		Person per=PersonFactory.getPerson("emp");
		per.doTask();
		
		System.out.println("===================");
		Person per1=PersonFactory.getPerson("stud");
		per1.doTask();
		
		System.out.println("===================");
		Person per2=PersonFactory.getPerson("cust");
		per2.doTask();
		
	}

}
