package com.example.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineexam.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Long> {

}
