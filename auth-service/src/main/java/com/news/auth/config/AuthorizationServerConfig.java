package com.news.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import com.news.auth.UserService;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService;
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(passwordEncoder);
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("client")
		.authorizedGrantTypes("password", "refresh_token")
		.scopes("read", "write")
		.secret(passwordEncoder.encode("secret"))
		.accessTokenValiditySeconds(10*60)
		.refreshTokenValiditySeconds(6 * 10 * 60);
	}
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
		.userDetailsService(userService)
		.tokenStore(tokenStore);
	}
}
