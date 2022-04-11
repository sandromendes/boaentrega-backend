package com.boaentrega.apigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = {
			"/api/oauth-ms/v1/oauth/token",
			"/cliente-ms/v2/api-docs",
			"/pedido-ms/v2/api-docs",
			"/user-ms/v2/api-docs",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
			};
	
	private static final String[] OPERATOR = {"/api/cliente-ms/v1/**"};
	
	private static final String[] ADMIN = {
			"/api/pedido-ms/v1/**", 
			"/api/user-ms/v1/**"}; 
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(PUBLIC).permitAll()
			.antMatchers(OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
			.antMatchers(ADMIN).hasRole("ADMIN")
			.anyRequest().authenticated();
	}
}
