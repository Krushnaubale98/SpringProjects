package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public Employee showEmpDetailsByNo(int no);

	public List<Employee> FetchEmployeeDetailsByDesg(String desg);
}
