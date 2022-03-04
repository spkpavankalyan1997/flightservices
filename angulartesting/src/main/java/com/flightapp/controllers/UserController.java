package com.flightapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.entities.UserTest;
import com.flightapp.services.UserService;

@RestController
@CrossOrigin
public class UserController {


	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<UserTest> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public UserTest saveUser(@RequestBody UserTest u) {
		return userService.saveUser(u);
	}

	@GetMapping("/users/{id}")
	public UserTest getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		 userService.deleteUser(id);
	}
}
