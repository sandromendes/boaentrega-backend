package com.boaentrega.oauthms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boaentrega.oauthms.domain.User;
import com.boaentrega.oauthms.feignclients.UserFeignClients;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserFeignClients userFeignClients;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClients.findByEmail(username).getBody();
		
		if(user == null) {
			logger.error("E-mail não encontrado: " + username);
			throw new UsernameNotFoundException("E-mail não encontrado: " + username);
		}
		
		logger.info("E-mail encontrado: " + username);
		
		return user;
	}
	
}
