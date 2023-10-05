package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {

	// queryForObject(-) method
	public int showEmployeeCount();

	// queryForMap(-) method
	public Map<String, Object> fetchEmployeeByNo(int no);

	// queryForList(-) method
	public List<Map<String, Object>> fetchEmployeeByDesg(String desg1, String desg2);

	// queryForObject(-) Method
	public double fetchEmpSalaryByEmpno(int no);

	// Non-select query
	// update(-)method
	public String registerEmployee(String name, String desg, double salary);

	// update(-) method (Update query)
	public String hikeEmployeeSalaryByDesg(double percentage, String desg);

	// update(-) method (Update query)
	public String fireEmployeeSalaryRange(double start, double end);

}
