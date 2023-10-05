package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeServiceMgmt {
	public List<Employee> fetchAllEmps();

	public String registerEmployee(Employee emp);

	public Employee fetchEmployeeByNo(int no);

	public String modifyEmployeeByNo(Employee emp);

	public String removeEmployeeByNO(int no);
}
