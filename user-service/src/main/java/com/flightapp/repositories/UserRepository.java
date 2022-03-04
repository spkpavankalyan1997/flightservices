package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
