package com.example.onlineexam.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.onlineexam.entity.Question;

public interface QuestionService {
	
	public Page<Question> getQuestion(Pageable page);
	void create(Question q);
	public Question getQuestionById(Long id);
	public List<Question> getQuestion();
	//public Question getQuestion(Long id);
	public void deleteQuestion(Long id);
}
