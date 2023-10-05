package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {

	public String registerEmployee(Employee emp);

	public String searchEmployeeById(int id);

	public String modifyEmployee(Employee emp);

	public String removeEmployeeById(int id);

	public List<?> fetchAllEmployees();
}
