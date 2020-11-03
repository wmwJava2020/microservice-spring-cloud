package com.addis.accountmicorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	Environment env;
	
	@GetMapping("/balance/saving")
	public String accounts() {
		System.out.println("---------------  For Account Microservices  -----------------------");
		return "Account controller is working PORT Number :" + env.getProperty("local.server.port"); 
	}

}
