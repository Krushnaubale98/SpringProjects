package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {

	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public List<Employee> fetchAllEmps() {
		// use DAO
		List<Employee> list = empDAO.getAllEmployees();
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) {

		// use DAO
		int count = empDAO.insertEmployee(emp);
		return count == 0 ? "Employee not registered " : "Employee registered";
	}

	@Override
	public Employee fetchEmployeeByNo(int no) {
		// use DAO
		Employee emp = empDAO.getEmployeeByNo(no);
		return emp;

	}

	@Override
	public String modifyEmployeeByNo(Employee emp) {

		// use DAO
		int count = empDAO.updateEmployeeByNo(emp);
		return count == 0 ? "employee not found for updation " : "employee found and updated";
	}

	@Override
	public String removeEmployeeByNO(int no) {
		// use DAO
		int count = empDAO.deleteEmployeeByNo(no);
		return count == 0 ? " employee not fount for Deletion" : "employee fount and deleted" ;
	}
}
