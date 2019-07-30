package com.example.onlineexam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlineexam.dao.RoleDAO;
import com.example.onlineexam.entity.Role;

@Service
public class RoleServiceImp implements RoleService{
	@Autowired
	private RoleDAO roleDAO;

	@Override
	@Transactional
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return roleDAO.findAll();
	}

}
