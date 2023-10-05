package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("empDAO")
public class IEmployeeDAOImpl implements IEmployeeDAO {

	public static final String GET_EMPS_COUNT = "Select count(*) from emp";
	public static final String GET_EMP_BY_NO = "select empno,ename,job,sal from emp where empno=?";
	public static final String GET_EMP_BY_DESG = "Select empno,ename,job,sal from emp where job IN(?,?)";
	public static final String GET_EMP_SAL_BY_EMPNO = "Select sal from emp where empno=?";
	// non-select query
	public static final String EMP_INSERT_QUERY = "insert into emp(empno,ename,job,sal)values(ENO_SEQ.NEXTVAL,?,?,?)";
	public static final String EMP_UPDATE_QUERY = "update emp set SAL=sal+sal*? where job=?";
	public static final String EMP_DELETE_QUERY = " delete from emp where sal>=? and sal<=?";

	@Autowired
	private JdbcTemplate jt;

	// queryForObject(-) method
	@Override
	public int getEmpsCount() {
		int count = jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}

	// queryForMap(-) method
	public Map<String, Object> getEmployeeByNo(int no) {

		Map<String, Object> map = jt.queryForMap(GET_EMP_BY_NO, no);
		return map;
	}

	// queryForList(-) method
	@Override
	public List<Map<String, Object>> getEmployeeByDesg(String desg1, String desg2) {

		List<Map<String, Object>> list = jt.queryForList(GET_EMP_BY_DESG, desg1, desg2);
		return list;
	}

	// queryForObject(-)method
	@Override
	public double getEmpSalaryByEmpno(int no) {

		double salary = jt.queryForObject(GET_EMP_SAL_BY_EMPNO, Double.class, no);
		return salary;

	}

	/// non-select query
	// Update(-) method

	@Override
	public int insertEmployee(String name, String desg, double salary) {

		int count = jt.update(EMP_INSERT_QUERY, name, desg, salary);
		return count;

	}

	// Update(-) method (Update query)
	@Override
	public int updateEmployeeSalaryByDesg(double percentage, String desg) {
		double percentValue = percentage / 100.0;
		int count = jt.update(EMP_UPDATE_QUERY, percentValue, desg);
		return count;
	}

	// update(-) method (Update query)
	@Override
	public int deleteEmployeeSalaryRange(double startSalary, double endSalary) {
		int count = jt.update(EMP_DELETE_QUERY, startSalary, endSalary);
		return count;
	}

}
