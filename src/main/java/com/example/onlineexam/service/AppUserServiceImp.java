package com.example.onlineexam.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.onlineexam.dao.AppUserDAO;
import com.example.onlineexam.entity.AppUser;
import com.example.onlineexam.entity.Role;

@Service
public class AppUserServiceImp implements AppUserService {

	@Autowired
	private AppUserDAO appUserDAO;
	
//	@Autowired
//	private RoleDAO roleDAO;
//	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public void createUser(AppUser user) {
		String password = user.getPassword();
		String encodedPassword = passwordEncoder.encode(password);
		
		//Role role = roleDAO.getOne(id);
		Role role = new Role(2L,"STUDENT");
		user.setPassword(encodedPassword);
		user.createRole(role);
		appUserDAO.save(user);
	}


}
