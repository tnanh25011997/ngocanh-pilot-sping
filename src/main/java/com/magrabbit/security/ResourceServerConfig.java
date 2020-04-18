package com.magrabbit.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.magrabbit.config.CORSFilter;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("resource_id").stateless(false);
	}

	/**
	 * Customizations for the protected resources
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class).authorizeRequests()
				.mvcMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll();
		http.authorizeRequests().antMatchers("/brand/**").hasRole("admin")
		.antMatchers("/product/**").hasRole("admin").and()
				.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler()).and().anonymous().disable();
	}
}