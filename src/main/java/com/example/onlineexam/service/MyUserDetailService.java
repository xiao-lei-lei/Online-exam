package com.example.onlineexam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.onlineexam.dao.AppUserDAO;
import com.example.onlineexam.entity.AppUser;
import com.example.onlineexam.entity.Role;


@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private AppUserDAO appUserDAO;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		AppUser appUser= appUserDAO.findByUsername(username);
		List<Role> roles = appUser.getRoles();
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
		}
		
		try {
			
			User user = new User(appUser.getUsername(),appUser.getPassword(),authorities);
			return user;
		}catch(NoSuchElementException e) {
			throw new UsernameNotFoundException("User not found");
		}
		

	}

}
