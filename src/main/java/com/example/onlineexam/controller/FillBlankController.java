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

import com.example.onlineexam.entity.BlankQuestion;
import com.example.onlineexam.service.BlankQuestionService;

@Controller
@RequestMapping("bquestions")
public class FillBlankController {
	
	@Autowired
	private BlankQuestionService questionService;
	
	@GetMapping("")
	public String questionList(Model model) {
		List<BlankQuestion> questions= questionService.getQuestion();
		model.addAttribute("questions",questions);
		return "blankQuestion/questions-list";
	}
	
	@GetMapping("/new")
	public String showAddForm(Model model) {
		BlankQuestion q = new BlankQuestion();
		model.addAttribute("questions",q);
		return "blankQuestion/index";
		
	}
	
	@PostMapping("")
	public String addQuestion(@ModelAttribute("questions")BlankQuestion q) {
		questionService.create(q);
		return "redirect:/bquestions";
	}
	
	@GetMapping("/edit")
	public String editQuestion(@RequestParam("id")Long id,Model model) {
		BlankQuestion question = questionService.getQuestionById(id);
		model.addAttribute("questions",question);
		return "blankQuestion/update";
	}
	
	@GetMapping("/delete")
	public String deleteQuestion(@RequestParam("id")Long id, Model model) {
		questionService.deleteQuestion(id);
		return "redirect:/bquestions";
	}

}
