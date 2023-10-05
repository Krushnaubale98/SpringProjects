package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	public static final String GET_EMPS_COUNT_BY_SAL_RANGE = "Select count(*)from emp where SAL>=:min and SAL<=:max";
	public static final String GET_EMPS_BY_DESG = "select empno,ename,job,sal from EMP where job IN(:des1,:des2)ORDER by job";
	public static final String INSERT_EMP_QUERY = "Insert into EMP(empno,ename,job,sal)values(:empno,:ename,:job,:sal)";

	@Autowired
	public NamedParameterJdbcTemplate njt;

	// 1)Using Map<String,Object>
	@SuppressWarnings("unchecked")
	public int getEmpsCountBySalary(float start, float end) {

		// create the Map object having the names and values of named params
		Map<String, Object> paramsMap = new HashMap();
		paramsMap.put("min", start);
		paramsMap.put("max", end);

		int count = njt.queryForObject(GET_EMPS_COUNT_BY_SAL_RANGE, paramsMap, Integer.class);
		return count;

	}

	/*Using SqlParameterSource(I) impl class object
	 
	 i)MapSqlParameterSource Object
	 	 
	 */

	@Override
	public List<Employee> getEmpsByDesg(String desg1, String desg2) {
		// bind values to named params using MapSqlParameterSource object
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("des1", desg1);
		source.addValue("des2", desg2);

		// executer the SQL query
		List<Employee> list = njt.query(GET_EMPS_BY_DESG, source, rs -> {
			// copy ResultSet obj records to list Collection
			List<Employee> empList = new ArrayList();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				// add each element into List Collection
				empList.add(emp);
			} // end of while
			return empList;
		});
		return list;

	}

	/*
	 String values to the named params using BeanPropertySqlParameterSource object...
	  =>this allows to set given bean/model class object data as the values of the
	  name Params... for this the names of Named params must match with names of
	  Model class property names     
	 
	 */
	@Override
	public int insertEmployee(Employee emp) {
		// create BeanPropertySqlParameterSource object having Model class object name
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(emp);
		int count = njt.update(INSERT_EMP_QUERY, bpsps);
		return count;

	}
}
