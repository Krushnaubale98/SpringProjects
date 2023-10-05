package com.nt.comps;

public class Student implements Person {

	public Student() {
		System.out.println("Student : 0-para constructor");
	}

	@Override
	public void doTask() {
		System.out.println("Student is studying the engineering");

	}

}
