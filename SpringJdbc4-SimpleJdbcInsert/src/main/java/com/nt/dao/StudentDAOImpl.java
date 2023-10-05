package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.model.Student;

@Repository("studDAO")
public class StudentDAOImpl implements IStudentDAO {

	@Autowired
	private SimpleJdbcInsert sji;

	@SuppressWarnings("unchecked")

	/* ======using Map(String,object)=============
	@Override
	public int insert(Student stud) {
	
		// set db table name"
		sji.setTableName("Students");
	
		// prepare Map collection having col name and col values
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("sno", stud.getSno());
		paramMap.put("sname", stud.getSname());
		paramMap.put("sadd", stud.getSadd());
		paramMap.put("avg", stud.getAvg());
		// generate and execute the Insert SQL query dynamically
		int count = sji.execute(paramMap);
	
		return count;
	
	}*/

	/*// =========using MapSqlParameterSource()===========
	public int insert(Student stud) {
		// set db table name
	
		sji.setTableName("Students");
	
		// prepare MapSqlParameterSource having column names and values
		MapSqlParameterSource source = new MapSqlParameterSource();
		source.addValue("sno", stud.getSno());
		source.addValue("sname", stud.getSname());
		source.addValue("sadd", stud.getSadd());
		source.addValue("avg", stud.getAvg());
	
		// generate and execute the INSERT SQL query dynamically
		int count = sji.execute(source);
		return count;
	}
	*/
	// ==========using BeanPropertySqlParameterSource(-)==========
	public int insert(Student stud) {
		// set the table name
		sji.setTableName("Students");

		// Prepare BeanPropertySqlParameterSource(-) having model class object
		BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(stud);
		// generate and execute the Insert sql query dynamically
		int count = sji.execute(source);
		return count;
	}
}
