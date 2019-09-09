package com.metacube.assignment_7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.assignment_7.service.MailSender;

/**
 * 
 * @author Pankaj
 *
 */
@RestController
public class MailController {

	//This is reference of MailSender Interface
	private MailSender mailSender;
	
	/**
	 * This is constructor dependency injection using primary annotation
	 * @param mailSender object of MailSender interface implementation class
	 */
	@Autowired
	public MailController(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	/**
	 * This is constructor dependency injection using name
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public MailController(MailSender smtpMailSender) {
	//	this.mailSender = smtpMailSender;
	//}
	
	/**
	 * This is constructor dependency injection using name
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public MailController(MailSender mockMailSender) {
	//	this.mailSender = mockMailSender;
	//}
	
	/**
	 * This is constructor dependency injection using qualifier
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public MailController(@Qualifier("mockMailSender") MailSender mailSender) {
	//	this.mailSender = mailSender;
	//}
	
	/**
	 * This is constructor dependency injection using qualifier
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public MailController(@Qualifier("smtpMailSender") MailSender mailSender) {
	//	this.mailSender = mailSender;
	//}
	
	/**
	 * This is setter dependency injection using primary annotation
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public void setMailSender(MailSender mailSender) {
	//	this.mailSender = mailSender;
	//}
	
	/**
	 * This is setter dependency injection using name
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public void setMailSender(MailSender mockMailSender) {
	//	this.mailSender = mockMailSender;
	//}
	
	/**
	 * This is setter dependency injection using name
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public void setMailSender(MailSender smtpMailSender) {
	//	this.mailSender = smtpMailSender;
	//}
	
	/**
	 * This is setter dependency injection using qualifier
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public void setMailSender(@Qualifier("mockMailSender")  MailSender mailSender) {
	//	this.mailSender = mailSender;
	//}
	
	/**
	 * This is setter dependency injection using qualifier
	 * @param mailSender object of MailSender interface implementation class
	 */
	//@Autowired
	//public void setMailSender(@Qualifier("smtpMailSender")  MailSender mailSender) {
	//	this.mailSender = mailSender;
	//}
	
	/**
	 * This method send mail
	 * @return success message or failed message
	 */
	@GetMapping("/sendMail")
	/**
	 * 
	 * @return String Result
	 */
	public String sendMail() {
		
		System.out.println("in controller");
		boolean result = mailSender.sendMail();
		if(result) {
			return "Send Successful";
		}else {
			return "Send Failed";
		}
	}
}
