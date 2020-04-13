package com.magrabbit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.magrabbit.*")
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		System.out.println("addResourceHandlers");
		// Configure the resource handler to serve files uploaded with CKFinder.
		registry.addResourceHandler("/images/**").addResourceLocations("file:/opt/pilot/images/");
	}
  
}
