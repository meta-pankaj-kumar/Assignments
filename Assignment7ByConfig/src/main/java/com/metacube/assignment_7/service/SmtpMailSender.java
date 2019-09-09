package com.metacube.assignment_7.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Pankaj
 *
 */
public class SmtpMailSender implements MailSender{

	//This is object of logger
	private static final Logger log = LoggerFactory.getLogger(SmtpMailSender.class);
	
	/**
	 * This method send mail using smtp
	 * @return true if mail send else false
	 */
	@Override
	public boolean sendMail() {
		
		log.info("Mail send from smtp mail sender");
		return true;
	}
}