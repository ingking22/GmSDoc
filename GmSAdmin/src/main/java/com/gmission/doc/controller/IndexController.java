package com.gmission.doc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dtc")
public class IndexController {

	@GetMapping("/indexDTC")
	public String dtcIndex() {
		return "/indexDTC";
	}
	
	
	
	
}
