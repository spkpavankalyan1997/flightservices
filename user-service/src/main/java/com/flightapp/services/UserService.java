package com.flightapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.entities.User;
import com.flightapp.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers()
	{
		return userRepository.findAll();
	}
	
	public User saveUser(User u)
	{
		return userRepository.save(u);
	}
	
	public User getUser(int id)
	{
		Optional<User> usr= userRepository.findById(id);
		
		return usr.get();
	}

}
