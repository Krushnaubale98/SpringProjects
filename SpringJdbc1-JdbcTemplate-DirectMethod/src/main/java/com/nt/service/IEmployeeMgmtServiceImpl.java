package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;

@Service("empService")
public class IEmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeDAO empDAO;

	// queryForObject(-) method
	@Override
	public int showEmployeeCount() {

		// use DAO
		int count = empDAO.getEmpsCount();

		return count;
	}

	// queryForMap(-) method
	@Override
	public Map<String, Object> fetchEmployeeByNo(int no) {
		// user DAO

		return empDAO.getEmployeeByNo(no);
	}

	// queryForList(-) method
	@Override
	public List<Map<String, Object>> fetchEmployeeByDesg(String desg1, String desg2) {

		return empDAO.getEmployeeByDesg(desg1, desg2);
	}

	// queryForObject(-)method
	@Override
	public double fetchEmpSalaryByEmpno(int no) {
		return empDAO.getEmpSalaryByEmpno(no);

	}

	// Non-Select query

	// update(-) method
	public String registerEmployee(String name, String desg, double salary) {

		int count = empDAO.insertEmployee(name, desg, salary);

		return count == 0 ? "Employee not registerd " : "Employee registred";
	}

	// update(-)method
	public String hikeEmployeeSalaryByDesg(double percentage, String desg) {
		int count = empDAO.updateEmployeeSalaryByDesg(percentage, desg);
		return count == 0 ? "employee not found for salary updataion " : count + " no of employee salary hiked...";
	}

	// update(-) method (Update query)
	public String fireEmployeeSalaryRange(double start, double end) {

		int count = empDAO.deleteEmployeeSalaryRange(start, end);

		return count == 0 ? "Employees no found for deletaion " : count + " no of employees are fount and deletion...";
	}

}
