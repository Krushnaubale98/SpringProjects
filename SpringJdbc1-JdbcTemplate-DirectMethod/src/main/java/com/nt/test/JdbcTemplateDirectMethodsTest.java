package com.nt.test;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.IEmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {
	public static void main(String[] args) {

		// Create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get the service class object
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);
		/*OR
		 * 
		  get the service class object
		  IEmployeeMgmtServiceImpl service = ctx.getBean("empService", IEmployeeMgmtServiceImpl.class);
		*/
		// invoke the business method
		int count = service.showEmployeeCount();
		System.out.println("EmplpoyeeSCount : " + count);

		System.out.println("==========================");
		Map<String, Object> map = service.fetchEmployeeByNo(7499);
		System.out.println("7499 EmployeeDetails: " + map);

		System.out.println("===========================");
		List<Map<String, Object>> list = service.fetchEmployeeByDesg("CLERK", "MANAGER");
		System.out.println(" Clerk and manager emp data..");
		list.forEach(m -> {
			System.out.println(m);
		});
		System.out.println("============================");
		double sal = service.fetchEmpSalaryByEmpno(7499);
		System.out.println("7499 emp Salary: " + sal);

		System.out.println("========non-select insert query=====");
		String msg = service.registerEmployee("SUREKHA", "MANAGER", 10000.0F);
		System.out.println(msg);

		System.out.println("====== non-select update query=======");
		String msg1 = service.hikeEmployeeSalaryByDesg(1.0f, "CLERK");
		System.out.println(msg1);

		System.out.println("======non-select delete query==========");
		String msg2 = service.fireEmployeeSalaryRange(5000.0, 16000.0);
		System.out.println(msg2);
		ctx.close();

	}
}
