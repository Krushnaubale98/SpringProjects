package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {
	@SuppressWarnings("resource")
	public static void main(String args[]) {

		// create the IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get serviceImp class object
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);

		// invoke the business method
		int empsCount = service.fetchEmpsCountBySalaryRange(1000.0f, 10000.0f);
		System.out.println("Employee count: " + empsCount);

		System.out.println("===================================");
		List<Employee> list = service.fetchEmpsByDesg("CLERK", "MANAGER");
		list.forEach(emp -> {
			System.out.println(emp);
		});
		System.out.println("===================================");
		Employee emp = new Employee();
		emp.setEmpno(1111);
		emp.setEname("Monika");
		emp.setJob("CLERK");
		emp.setSal(15000.0f);
		String resultMsg = service.registerEmployee(emp);
		System.out.println(resultMsg);
		ctx.close();
	}
}