package com.in28minutes.springboot.web.springbootfirstwebapplications.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validateUser(String userid,String password){
		return userid.equalsIgnoreCase("shreya") && password.equalsIgnoreCase("dummy");
		
	}

}
