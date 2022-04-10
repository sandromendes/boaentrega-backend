package com.boaentrega.oauthms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boaentrega.oauthms.domain.User;
import com.boaentrega.oauthms.feignclients.UserFeignClients;

@Service
public class UserService {

	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClients userFeignClients;
	
	public User findByEmail(String email) {
		User user = userFeignClients.findByEmail(email).getBody();
		
		if(user == null) {
			logger.error("E-mail não encontrado: " + email);
			throw new IllegalArgumentException("E-mail não encontrado: " + email);
		}
		
		logger.info("E-mail encontrado: " + email);
		
		return user;
	}
	
}
