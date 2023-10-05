package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeServiceMgmt;

@Controller
public class EmployeeOperationController {

	@Autowired
	private IEmployeeServiceMgmt service;

	@GetMapping("/")
	public String showHomePage() {
		// return LVN
		return "home";
	}

	@GetMapping("/employee_report")
	public String showEmployeeReport(Map<String, Object> map) {
		System.out.println("EmployeeOperationsController.showEmployeeReport()");
		// use service
		List<Employee> list = service.fetchAllEmps();

		// add model attributes to map collection
		map.put("listEmps", list);

		// return LVN
		return "show_emp_report";
	}

	@GetMapping("/add_employee")
	public String showAddEmployeeFormPage(@ModelAttribute("emp") Employee emp) {

		// return LVN return
		return "register_employee_form";

	}

	/*
		@PostMapping("/add_employee")
		public String processAddEmployeeFromSubmission(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
			// user service
			String msg = service.registerEmployee(emp);
	
			List<Employee> list = service.fetchAllEmps();
	
			// keep result is model attribute
			map.put("resultMsg", msg);
	
			// keep the all employee report into model attribute
			map.put("listEmps", list);
	
			// return \LVN
			return "show_emp_report";
		}
		 ========================OR========================
		*/
	@PostMapping("add_employee")
	public String processAddEmployeeForSubmission(@ModelAttribute("emp") Employee emp, RedirectAttributes attrs) {

		// use service
		String msg = service.registerEmployee(emp);

		// keeps result is model attribute
		attrs.addFlashAttribute("resultMsg", msg);
		// return LVN
		return "redirect:employee_report";
	}

	@GetMapping("/edit_employee")
	public String showEditEmployeeFormPage(@RequestParam("no") int no, @ModelAttribute("emp") Employee emp) {
		// user service
		Employee emp1 = service.fetchEmployeeByNo(no);
		// copy emp1 object data into emp
		BeanUtils.copyProperties(emp1, emp);
		// BeanUtils is spring supplied class and its copy(-,-)
		// is use full to copy java bean class obj to another java bean class obj

		// return LVN
		return "edit_employee_form";
	}

	@PostMapping("/edit_employee")
	public String processUpdateEmployeeFormSubmission(@ModelAttribute("emp") Employee emp, Map<String, Object> map) {
		// user service

		String msg = service.modifyEmployeeByNo(emp);

		List<Employee> list = service.fetchAllEmps();// fetch all records
		// keep the results in Model attribute
		map.put("resultMsg", msg);
		map.put("listEmps", list);

		// return LVN
		return "show_emp_report";
	}

	@GetMapping("/delete_employee")
	public String fireEmployee(@RequestParam("no") int no, Map<String, Object> map) {

		// use service
		String msg = service.removeEmployeeByNO(no);

		// display all employees
		List<Employee> list = service.fetchAllEmps();
		// keep the result in model attribute
		map.put("resultMsg", msg);

		map.put("listEmps", list);
		return "show_emp_report";
	}

}
