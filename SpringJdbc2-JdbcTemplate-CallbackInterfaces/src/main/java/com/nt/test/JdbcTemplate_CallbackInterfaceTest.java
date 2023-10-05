
package com.nt.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

public class JdbcTemplate_CallbackInterfaceTest {

	public static void main(String[] args) {

		// Create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// create service Class object
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);

		// invoke the business method
		Employee emp = service.showEmpDetailsByNo(7499);
		System.out.println("details of 7499 NO: \n" + emp);

		System.out.println("=============================================");
		// invoke the business method
		List<Employee> empList = service.FetchEmployeeDetailsByDesg("CLERK");
		empList.forEach(e -> {
			System.out.println(e);
		});
		ctx.close();
	}

}
