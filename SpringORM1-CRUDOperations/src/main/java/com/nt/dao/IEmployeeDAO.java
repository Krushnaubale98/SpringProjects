package com.nt.dao;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeDAO {
	public int insert(Employee emp);

	public Employee getEmployeeById(int id);

	public String updateEmployee(Employee emp);

	public String deleteEmployeeById(int id);

	public List<?> getAllEmployees();
}
