package com.example.onlineexam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.onlineexam.entity.Question;
import com.example.onlineexam.service.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("")
	public String questionList(Model model) {
		List<Question> questions= questionService.getQuestion();
		model.addAttribute("questions",questions);
		return "question/questions-list";
	}
	
	@GetMapping("/new")
	public String createQuestion(Model model) {
		Question q = new Question();
		model.addAttribute("questions",q);
		return "question/index";
	}
	
	@PostMapping("")
	public String showQuestion(@ModelAttribute("questions")Question q) {
		questionService.create(q);
		return "redirect:/questions";
	}
	
	@GetMapping("/edit")
	public String editQuestion(@RequestParam("id")Long id,Model model) {
		Question question = questionService.getQuestionById(id);
		model.addAttribute("questions",question);
		return "question/update";
	}
	
	@GetMapping("/delete")
	public String deleteQuestion(@RequestParam("id")Long id, Model model) {
		questionService.deleteQuestion(id);
		return "redirect:/questions";
	}
	
}
