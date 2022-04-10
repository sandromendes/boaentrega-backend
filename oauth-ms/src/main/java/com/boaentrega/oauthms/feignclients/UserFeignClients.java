package com.boaentrega.oauthms.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.boaentrega.oauthms.domain.User;

@Component
@FeignClient(name = "user-ms", path = "/users")
public interface UserFeignClients {
	@GetMapping(value = "/search")
	ResponseEntity<User> findByEmail(@RequestParam String email);
}
