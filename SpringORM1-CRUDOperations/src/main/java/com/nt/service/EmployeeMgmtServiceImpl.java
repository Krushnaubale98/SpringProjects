package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IEmployeeDAO;
import com.nt.entity.Employee;

@Service("empService")
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	public IEmployeeDAO empDAO;

	@Override
	public String registerEmployee(Employee emp) {
		int idVal = empDAO.insert(emp);
		return "Employee is registered with the id value: " + idVal;
	}

	@Override
	public String searchEmployeeById(int id) {
		Employee emp = empDAO.getEmployeeById(id);
		return emp == null ? " Employee not found " : "Employee found :" + emp;

	}

	@Override
	public String modifyEmployee(Employee emp) {
		String msg = empDAO.updateEmployee(emp);
		return msg;
	}

	@Override
	public String removeEmployeeById(int id) {
		String msg = empDAO.deleteEmployeeById(id);
		return msg;
	}

	@Override
	public List<?> fetchAllEmployees() {
		return empDAO.getAllEmployees();

	}
}
