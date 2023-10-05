package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeControllerr {

	@RequestMapping("/home")
	public String showHomePage(Map<String, Object> map) {
		System.out.println("map is refering to " + map.getClass());

		// put the data in model attributes
		map.put("sysDate", new Date());
		map.put("attr1", "val1");
		map.put("page", new Random().nextInt(1000));
		// return LVN
		return "welcome";
	}
}
