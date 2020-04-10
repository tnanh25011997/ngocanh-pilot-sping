package com.magrabbit.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

import com.magrabbit.config.CORSFilter;
import com.magrabbit.utility.Constrains;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name = "userService")
	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Authentication manager configure
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Set up the accounts in the database
	 */
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}

	/**
	 * Customizations for the protected resources
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class).authorizeRequests()
				.mvcMatchers(HttpMethod.OPTIONS, "/oauth/token").permitAll();
		http.authorizeRequests().antMatchers(Constrains.TEST).hasRole("ADMIN").and()
				.exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler()).and().anonymous().disable();
	}

	
	

	/**
	 * Password encryption by BcryptPasswordEncoder
	 */
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}