package com.nt.text;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

public class ORMModuleTest {
	public static void main(String[] args) {

		// create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");

		// get the service class object
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);

		// invoke the business method
		/*Employee emp = new Employee("mahesh", "CLERK", 90000.0);
		try {
			System.out.println(service.registerEmployee(emp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		System.out.println("========Search EmpData by Id=================");
		try {

			System.out.println("1 emp Details: " + service.searchEmployeeById(22));

		} catch (Exception e) {
			e.printStackTrace();
		}

		// =======Update EmpData by ID==========
		try {
			Employee emp1 = new Employee("raja", "MANAGER", 140000.0);
			emp1.setEmpno(1);
			System.out.println(service.modifyEmployee(emp1));
		} catch (Exception e) {
			e.printStackTrace();
		}

		// =========delete emp by id=========
		try {
			System.out.println(service.removeEmployeeById(23));

		} catch (Exception e) {
			e.printStackTrace();
		}
		// =========fetch all employee objects
		System.out.println("All Employee objects: ");
		List<?> list = service.fetchAllEmployees();
		list.forEach(emp -> {
			System.out.println(emp);
		});
	}
}
