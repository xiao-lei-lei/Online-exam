package com.example.onlineexam.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.onlineexam.entity.BlankQuestion;

public interface BlankQuestionService {

	void create(BlankQuestion q);

	List<BlankQuestion> getQuestion();

	BlankQuestion getQuestionById(Long id);

	void deleteQuestion(Long id);

	Page<BlankQuestion> getQuestion(Pageable page);

}
