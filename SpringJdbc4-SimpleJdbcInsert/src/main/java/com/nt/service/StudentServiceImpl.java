package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IStudentDAO;
import com.nt.model.Student;

@Service("studService")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	public IStudentDAO studDAO;

	@Override
	public String registerStudent(Student stud) {

		// use DAO
		int count = studDAO.insert(stud);
		return count == 0 ? "Student registration failed" : " Student registration successfull";
	}

}
