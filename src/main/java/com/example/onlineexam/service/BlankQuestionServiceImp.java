package com.example.onlineexam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.onlineexam.dao.BlankQuestionDAO;
import com.example.onlineexam.entity.BlankQuestion;

@Service
public class BlankQuestionServiceImp implements BlankQuestionService {

	@Autowired
	private BlankQuestionDAO blankQuestionDAO;
	
	@Override
	@Transactional
	public void create(BlankQuestion q) {
		// TODO Auto-generated method stub
		blankQuestionDAO.save(q);
	}

	@Override
	@Transactional
	public List<BlankQuestion> getQuestion() {
		// TODO Auto-generated method stub
		return blankQuestionDAO.findAll();
	}

	@Override
	@Transactional
	public BlankQuestion getQuestionById(Long id) {
		// TODO Auto-generated method stub
		return blankQuestionDAO.getOne(id);
	}

	@Override
	@Transactional
	public void deleteQuestion(Long id) {
		// TODO Auto-generated method stub
		blankQuestionDAO.deleteById(id);
	}

	@Override
	public Page<BlankQuestion> getQuestion(Pageable page) {
		// TODO Auto-generated method stub
		return blankQuestionDAO.findAll(page);
	}

	
}
