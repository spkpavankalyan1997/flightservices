package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.UserTest;
import com.flightapp.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserTest> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public UserTest saveUser(UserTest u)
	{
		return userRepository.save(u);
	}
	
	public UserTest getUser(int id)
	{
		Optional<UserTest> usr= userRepository.findById(id);
		
		return usr.get();
	}
	
	public void deleteUser(int id)
	{
		userRepository.deleteById(id);
		
	}

}
