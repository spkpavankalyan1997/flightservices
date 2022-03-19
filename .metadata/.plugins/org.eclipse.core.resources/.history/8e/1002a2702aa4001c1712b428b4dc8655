package com.flightapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/home")
	public String homePage() {
		return "Home Page";
	}
	
	@GetMapping("/greet")
	public String greetUser() {
		return "Welcome User";
	}
	
	@GetMapping("/greet/{user}")
	public String greet(@PathVariable String user) {
		return "Welcome "+user;
	}
	
}
