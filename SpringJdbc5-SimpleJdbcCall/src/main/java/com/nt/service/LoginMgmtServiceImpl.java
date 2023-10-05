package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ILoginDAO;

@Service("loginService")
public class LoginMgmtServiceImpl implements ILoginMgmtService {

	// get the Dao object
	@Autowired
	private ILoginDAO loginDAO;

	@Override
	public String singnIn(String username, String passrwrd) {

		// use DAO
		String result = loginDAO.authenticate(username, passrwrd);

		return result;
	}

}
