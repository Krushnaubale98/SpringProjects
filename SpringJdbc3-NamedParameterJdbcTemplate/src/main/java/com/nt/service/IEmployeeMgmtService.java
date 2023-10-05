package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public int fetchEmpsCountBySalaryRange(float start, float end);

	public List<Employee> fetchEmpsByDesg(String desg1, String Desg2);

	public String registerEmployee(Employee emp);
}
