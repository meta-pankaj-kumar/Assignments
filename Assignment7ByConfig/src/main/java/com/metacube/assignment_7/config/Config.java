package com.metacube.assignment_7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.assignment_7.service.MailSender;
import com.metacube.assignment_7.service.MockMailSender;
import com.metacube.assignment_7.service.SmtpMailSender;

/**
 * 
 * @author Pankaj
 *
 */
@Configuration
public class Config {

	/**
	 * This method return object of SmtpMailSender class
	 * @return object of SmtpMailSender class
	 */
	@Bean
	//@Primary
	public MailSender smtpMailSender() {
		return new SmtpMailSender();
	}
	
	/**
	 * This method return object of MockMailSender class
	 * @return object of MockMailSender class
	 */
	@Bean
	public MailSender mockMailSender() {
		return new MockMailSender();
	}
}