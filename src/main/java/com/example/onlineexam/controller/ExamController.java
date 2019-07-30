package com.example.onlineexam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.onlineexam.entity.Question;
import com.example.onlineexam.service.QuestionService;

@Controller
@RequestMapping("/exam")
public class ExamController{
	
	@Autowired
	private QuestionService questionService;
	private int mark;
	
	@GetMapping("/question")
	public String examList(HttpSession session, Model model) {
		Pageable page = PageRequest.of(0, 1);
		Page<Question> questions = questionService.getQuestion(page);
		Long expiredTime = (Long)session.getAttribute("expiredTime");
		if(expiredTime==null) {
			Long time = System.currentTimeMillis()+(1000*60);
			session.setAttribute("expiredTime",time);
			model.addAttribute("time", time);
		}else {
			model.addAttribute("time", expiredTime);
		}
		model.addAttribute("questions",questions);
		return "exam/index";
	} 
	
	@PostMapping("/question")
	public String showMark(HttpSession session,@RequestParam("page")int index,@RequestParam("id")Long id,@RequestParam("answer")String answer, Model model)
	{
		Question question = questionService.getQuestionById(id);
		if(question.getCorrect().equals(answer)) {
			mark += 1;
		}
		Pageable page = PageRequest.of(index+1, 1);
		Page<Question> questions = questionService.getQuestion(page);
		if(questions.getTotalPages()==index+1) {
			model.addAttribute("mark",mark);
			mark=0;
			session.removeAttribute("expiredTime");
			return "result";
		}
		model.addAttribute("questions",questions);
		return "exam/index";
	}
	
	@GetMapping("/finished")
	public String showMarks(HttpSession session, Model model)
	{
			model.addAttribute("mark",mark);
			mark=0;
			session.removeAttribute("expiredTime");
			return "result";
	}
}
