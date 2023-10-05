package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {

	@GetMapping("/")
	public String showHomePage() {

		return "welcome";
	}

	@GetMapping("/student")
	public String showStudentFormPage() {
		// return LVN
		return "student_form";
	}

	@PostMapping("/student")
	public String processStudentForm(@ModelAttribute("stud") Student st, Map<String, Object> map) {
		System.out.println("form data: " + st);

		String result = null;
		// write business logic
		if (st.getAvg() < 35)
			result = "fail";
		else
			result = "pass";

		// keep the result in model attribute
		map.put("ResultData", result);

		// return LVN
		return "show_result";

	}
}
