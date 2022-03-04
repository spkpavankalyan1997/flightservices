package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightapp.entities.UserTest;

public interface UserRepository extends JpaRepository<UserTest, Integer>{

}
