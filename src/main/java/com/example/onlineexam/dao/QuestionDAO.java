package com.example.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlineexam.entity.Question;

public interface QuestionDAO extends JpaRepository<Question, Long>{

}
