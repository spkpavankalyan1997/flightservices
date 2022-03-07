package com.flightapp.services;

import java.util.List;

import com.flightapp.entities.User;

public interface UserService {

	List<User> getAllUsers();

	int saveUser(User user);

	User getUser(int id);

}
