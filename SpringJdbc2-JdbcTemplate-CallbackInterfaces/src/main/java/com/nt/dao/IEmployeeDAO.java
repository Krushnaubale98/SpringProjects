package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {

	public Employee getEmployeeByNo(int no);

	public List<Employee> getEmployeeByDesg(String desg);
}
