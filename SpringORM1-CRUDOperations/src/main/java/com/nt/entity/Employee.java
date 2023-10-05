package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;


@Entity
@Table(name = "Employee_Tab")
public class Employee {
	@Column(name = "ENO")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empno;

	@Column(name = "ENAME", length = 20)
	private String empname;

	@Column(name = "JOB", length = 20)
	private String desg;

	@Column(name = "SAL")
	private Double salary;

	// constructors
	public Employee(String empname, String desg, Double salary) {
		this.empname = empname;
		this.desg = desg;
		this.salary = salary;
	}

	public Employee() {
		System.out.println("Employee:0-param constructor");
	}

	// setters and getters
	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", empname=" + empname + ", desg=" + desg + ", salary=" + salary + "]";
	}

}
