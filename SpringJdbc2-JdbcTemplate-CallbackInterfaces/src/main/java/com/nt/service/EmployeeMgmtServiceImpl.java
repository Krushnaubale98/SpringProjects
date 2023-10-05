package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;

	public Employee showEmpDetailsByNo(int no) {

		// use DAO
		Employee emp = empDAO.getEmployeeByNo(no);

		return emp;
	}

	@Override
	public List<Employee> FetchEmployeeDetailsByDesg(String desg) {
		// user DAO
		/*
		 List<Employee> emp1 = empDAO.getEmployeeByDesg(desg);
		return  emp1;
		==============OR=========
		*/
		return empDAO.getEmployeeByDesg(desg);
	}

}
