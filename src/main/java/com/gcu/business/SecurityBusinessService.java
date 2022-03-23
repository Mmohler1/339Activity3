package com.gcu.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class SecurityBusinessService 
{

	//For the logger
	private static final Logger logger = LoggerFactory.getLogger(SecurityBusinessService.class);
	
	public boolean authenticate(String username, String password)
	{
		System.out.print("Hello from the SecurityBusinessService\n");
		
		logger.info("Authentication returns true regardless of what is entered");
		
		return true;
		
	}

}
