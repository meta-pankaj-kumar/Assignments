package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sms.dto.Student;
import com.sms.service.SMSService;

/**
 * 
 * @author Pankaj
 *
 */
@Controller
public class SMSController {
	
	//This contain welcome message 
	@Value("${welcome.message}")
	private String welcomeMessage;

	/**
	 * This method redirect to index page
	 * @param model object of Model class
	 * @return String name of page
	 */
	@GetMapping("/index")
	public String goToIndexPage(Model model) {
		model.addAttribute("welcomeMessage",welcomeMessage);
		return "index";
	}
	
	/**
	 * This method redirect to add student page
	 * @param model object of Model class
	 * @return String name of page
	 */
	@GetMapping("/add")
	public String goToAddPage(Model model) {
		
		Student student = new Student();
		model.addAttribute(student);
		return "add";
	}
	
	/**
	 * This method show all student
	 * @param model object of Model class
	 * @return String name of page
	 */
	@GetMapping("/showall")
	public String goToShowAllStudentPage(Model model) {
		
		SMSService smsService = SMSService.getInstance();
		model.addAttribute("studentList",smsService.getAllStudent());
		return "showallstudent";
	}
	
	/**
	 * This method add student 
	 * @param student object of Student class
	 * @param bindingResult object of BindingResult class
	 * @return String name of page
	 */
	@PostMapping("/addStudent")
	public String addStudent(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "add";
		}else {
			SMSService smsService = SMSService.getInstance();
			smsService.addStudent(student);
			return "redirect:showall";
		}
	}
}
