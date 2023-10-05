package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements ILoginDAO {

	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String authenticate(String username, String password) {

		// set the procedure name
		sjc.setProcedureName("Auth_Pro");

		// prepare Map object having in param nmes and values
		Map<String, Object> inParams = new HashMap();
		inParams.put("user", username);
		inParams.put("pass", password);

		// call PL/Sql procedure
		Map<String, Object> outParams = sjc.execute(inParams);

		// gather result
		String result = (String) outParams.get("RESULT");

		return result;
	}

}
