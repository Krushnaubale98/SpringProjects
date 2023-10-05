package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	public IEmployeeDAO empDAO;

	@Override
	public int fetchEmpsCountBySalaryRange(float start, float end) {
		// use DAO
		int count = empDAO.getEmpsCountBySalary(start, end);
		return count;
	}

	public List<Employee> fetchEmpsByDesg(String args1, String args2) {
		// user DAO
		List<Employee> list = empDAO.getEmpsByDesg(args1, args2);
		return list;
	}

	public String registerEmployee(Employee emp) {
		// use DAO
		int count = empDAO.insertEmployee(emp);
		return count == 0 ? "Employee not inserted" : "Employee inserted";
	}

}
