package com.example.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineexam.entity.AppUser;

public interface AppUserDAO extends JpaRepository<AppUser, Long>{
	
	AppUser findByUsername(String username);

}
