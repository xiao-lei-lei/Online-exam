package com.example.onlineexam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.onlineexam.dao.QuestionDAO;
import com.example.onlineexam.entity.Question;

@Service
public class QuestionServiceImp implements QuestionService {
	
	@Autowired
	private QuestionDAO questionDAO;

	@Override
	@Transactional
	public void create(Question q) {
		questionDAO.save(q);
	}

	@Override
	@Transactional
	public Page<Question> getQuestion(Pageable page) {
		// TODO Auto-generated method stub
		return questionDAO.findAll(page);
	}

	@Override
	@Transactional
	public Question getQuestionById(Long id) {
		// TODO Auto-generated method stub
		return questionDAO.getOne(id);
	}

	@Override
	@Transactional
	public List<Question> getQuestion() {
		// TODO Auto-generated method stub
		return questionDAO.findAll();
	}

	@Override
	@Transactional
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		questionDAO.deleteById(id);
	}


}
