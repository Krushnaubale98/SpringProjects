package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMP_BY_NO = "Select empno,ename,job,sal from emp where empno=?";
	private static final String GET_EMPS_BY_DESG = "Select empno,ename,job,sal from emp where job=?";

	@Autowired
	private JdbcTemplate jt;
//=====================================RowMapper Interface======================================
	/*
		@Override
		public Employee getEmployeeByNo(int no) {
	
			Employee emp = jt.queryForObject(GET_EMP_BY_NO, new EmployeeRowMapper(), no);
	
			return emp;
		}
	
		// static innerClass (nested inner class)
		public static class EmployeeRowMapper implements RowMapper<Employee> {
	
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	
				// copy the resultSet object record to Employee class object
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getFloat(4));
				return emp;
			}// predefined method
	
		}// end of inner class
	
	*/

	/* =========OR===============
	 * DAOImpl class calling jt.queryForObject(-,-,-)having  RowMapper(I) implementation
	 * class object as the anonymous inner class
	
	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO, new RowMapper<Employee>() {
	
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				// Copy RS object record to Employee
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getFloat(4));
	
				return emp;
			}
		}, no);
	
		return emp;
	}
	   */

	/*===========OR============
	 *  RowMapper(I) is spring jdbc App is function interface because its having 
	 *      single mapRow(-,-) method as abstract method...... so for that we can user 
	 *      their LAMBDA  expression 
	 * 
	
	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO, (rs, rownum) -> {
			// copy RS object to Employee class object
			Employee e = new Employee();
			e.setEmpno(rs.getInt(1));
			e.setEname(rs.getString(2));
			e.setJob(rs.getString(3));
			e.setSalary(rs.getFloat(4));
	
			return e;
		}, no);
	
		return emp;
	}
	*/

	/*============OR============
	 public class BeanPropertyRowMapper<T> extends object implements RowMapper<T>
	 	 
	*/

	@Override
	public Employee getEmployeeByNo(int no) {
		Employee emp = jt.queryForObject(GET_EMP_BY_NO, new BeanPropertyRowMapper<Employee>(Employee.class), no);
		return emp;
	}

//=====================================ResultSetExtractor Interface======================================
	/* arg2 (anonymous inner class having object implementing ResultSetExtractor(I)
	
	@Override
	public List<Employee> getEmployeeByDesg(String desg) {
		List<Employee> empList = jt.query(GET_EMPS_BY_DESG, new ResultSetExtractor<List<Employee>>() {
			@SuppressWarnings("rawtypes")
			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException {
				@SuppressWarnings("unchecked")
				List<Employee> empList = new ArrayList();
	
				// copy the RS object records to List Collection
				while (rs.next()) {
					// copy each records of RS to Employee class
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getFloat(4));
					// add each Employee class object to List Collection
					empList.add(emp);
	
				} // end of while
				return empList;
	
			}// end of method
		}, desg);
		return empList;
	}
	*/
	/*================or================
	 Since the ResultSetExtractor(I) is functional interface ,we can writer LAMBDA
	 expression based anonymous class
	
	
	public List<Employee>getEmployeeByDesg(String desg){
		@SuppressWarnings("rawtypes")
		List<Employee> empList=jt.query(GET_EMPS_BY_DESG,rs->{
			@SuppressWarnings("unchecked")
			List<Employee> listEmps=new ArrayList();
			
			//copy the RS object into List Collection
			while(rs.next()) {
				//copy each elements into a Employee class object
				Employee emp=new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSalary(rs.getFloat(4));
				//adding each elements into a List Collection
				listEmps.add(emp);
			}//end of while
			return listEmps;
		},desg);
		return empList;
	
	}
	
	*/

	/*
	  RowMapperResultSetExtractor is predefined class implementing by 
	  ResultSetExtractor(I) which is internally uses BeanPropertyRwoMapper to copy
	  each record of RS to Employee class object and all the Employee class object
	  will be added to List Collection
	 */

	public List<Employee> getEmployeeByDesg(String desg) {
		List<Employee> empList = jt.query(GET_EMPS_BY_DESG,
				new RowMapperResultSetExtractor<Employee>(new BeanPropertyRowMapper<Employee>(Employee.class)), desg);
		return empList;
	}

}// end of outer class
