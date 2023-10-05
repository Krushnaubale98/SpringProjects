package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {

	// queryForObject(-) method
	public int getEmpsCount();

	// queryForMap(-) method
	public Map<String, Object> getEmployeeByNo(int no);

	// queryForList(-) method
	public List<Map<String, Object>> getEmployeeByDesg(String desg1, String desg2);

	// queryForObject(-) method
	public double getEmpSalaryByEmpno(int no);

	// Non-Select queries
	// update(-)method (insert query)
	public int insertEmployee(String name, String desg, double salary);

	// update(-) method (Update query)
	public int updateEmployeeSalaryByDesg(double percentage, String desg);

	public int deleteEmployeeSalaryRange(double startSalary, double endSalary);
}
