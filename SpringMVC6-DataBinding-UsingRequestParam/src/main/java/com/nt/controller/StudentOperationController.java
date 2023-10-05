package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentOperationController {

	/*@GetMapping("/report")
	public String showData(@RequestParam("sno") int no, @RequestParam("sname") String name) {
	
		System.out.println(no + " " + name);
		// return LVN
		return "show_result";
	}
	*/
	/*
	==========================================================================
	If the request param name and handler method param name is matching then
	there is no need of passing request param name in @RequestParam(-) annotation
	
	@GetMapping("/report")
	public String showData(@RequestParam int sno, @RequestParam String sname) {
		System.out.println(sno + " " + sname);
	
		// return LVN
		return "show_result";
	}
	*/

	/*
	 =====================================================================
	if request param specified in the handler method is no supplied along with
	the request then we get the exception...MissingServletRequestParameterException
	solution:
	
	@GetMapping("/report")
	public String showData(@RequestParam int sno, @RequestParam(required = false) String sname) {
		System.out.println(sno + " " + sname);
		// return LVN
		return "show_result";
	}
	*/

	/*
	==============================================================================================
	 We can specify the default balue for request param using "defaultValue" param of 
	 @RequestParam annotation in controller class or we can pass the more than 1 values  for 
	 request param then they will stored in @RequestParam(-) type handler method parameter as comma
	 Separated list of values	
	
	
	@GetMapping("/report")
	public String showData(@RequestParam int sno,
			@RequestParam(required = false, defaultValue = "krushna") String sname) {
		System.out.println(sno + " " + sname);
		// return LVN
		return "show_result";
	}
	*/
	/*	
		==================================================================
	    The multiple values of single request param can be stored in array or
	    List or  Set collection type param of handler method as show below
	*/

	@GetMapping("/report")
	public String showData(@RequestParam int sno,
			@RequestParam(required = false, defaultValue = "Krushna") String sname[],
			@RequestParam("sname") List<String> names, @RequestParam("sname") Set<String> names1) {

		System.out.println(sno + " " + Arrays.toString(sname) + " " + names + " " + names1);
		// return LVN
		return "show_result";
	}
}
