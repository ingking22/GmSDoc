package com.gmission.doc.controller;

import java.util.HashMap;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {
	
		@GetMapping("/loginDTC")
		public String loginDTC() {
			return "/loginDTC";
		}
	

		@GetMapping("/TestPw") 
		@ResponseBody
		public String GetPw(@RequestParam HashMap<String,String> param) {
			
			BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
			
			return String.format("rawpw:%s , encodepw:%s",param.get("rawpw"), pw.encode(param.get("rawpw")) ); 
		}
		
}
