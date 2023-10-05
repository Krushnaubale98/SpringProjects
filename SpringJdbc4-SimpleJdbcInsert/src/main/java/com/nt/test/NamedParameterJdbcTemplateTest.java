package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.model.Student;
import com.nt.service.IStudentService;

public class NamedParameterJdbcTemplateTest {
	@SuppressWarnings("resource")
	public static void main(String args[]) {

		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get serviceImp class object
		IStudentService service = ctx.getBean("studService", IStudentService.class);

		// invoke the business method
		Student st = new Student();
		st.setSno(101);
		st.setSname("Mohini");
		st.setSadd("secBad");
		st.setAvg(65.01f);
		String msg = service.registerStudent(st);
		System.out.println(msg);

	}
}