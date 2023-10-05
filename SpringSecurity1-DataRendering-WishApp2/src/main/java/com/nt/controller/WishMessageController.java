package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessageService;

@Controller
public class WishMessageController {

	@Autowired
	public IWishMessageService service;

	@RequestMapping("/")
	public String showHomePage() {
		// return LVN
		return "welcome";
	}

	@RequestMapping("/wish")
	public String showWishMessage(Map<String, Object> map) {
		// user service
		String msg = service.generateWishMessage();

		// put the result in the Map
		map.put("wmsg", msg);

		// return LVN
		return "show_result";

	}

	@GetMapping("/contact")
	public String showContactUsPage() {
		// return LVN
		return "contact_us";
	}
}
