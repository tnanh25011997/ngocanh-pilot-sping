package com.magrabbit.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableAuthorizationServer
@Order(2)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private static final String CLIEN_ID = "ngocanh";
	private static final String CLIENT_SECRET = "$2a$04$dgmN3EBtIhny3Mr4fqTTkO6PbD/is4XcrqFQ1xRFl8zjr7y7pNPpC";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	/**
	 * Method help translating OAuth authentication information (in both directions)
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("ngocanh");
		return converter;
	}

	/**
	 * Jwt token store
	 */
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	/**
	 * Configure that defines the client details service
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer.inMemory().withClient(CLIEN_ID).secret(CLIENT_SECRET)
				.authorizedGrantTypes("password", "refresh_token")
				.scopes("read", "write", "trust")
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				.refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}

	/**
	 * Method used to service requests for access tokens
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

		Map<String, CorsConfiguration> corsConfigMap = new HashMap<String, CorsConfiguration>();
		CorsConfiguration config = new CorsConfiguration();
		config.applyPermitDefaultValues();
		corsConfigMap.put("/oauth/token", config);
		endpoints.getFrameworkEndpointHandlerMapping().setCorsConfigurations(corsConfigMap);

		endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager)
				.accessTokenConverter(accessTokenConverter());
	}
}