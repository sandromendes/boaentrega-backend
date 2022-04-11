package com.boaentrega.oauthms.service;

import com.boaentrega.oauthms.domain.User;

public interface UserService {
	User findByEmail(String email);
}
