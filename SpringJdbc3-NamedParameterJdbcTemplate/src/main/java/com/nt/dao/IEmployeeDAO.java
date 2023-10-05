package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {

	public abstract int getEmpsCountBySalary(float start, float end);

	public List<Employee> getEmpsByDesg(String desg1, String desg2);

	public int insertEmployee(Employee emp);
}
