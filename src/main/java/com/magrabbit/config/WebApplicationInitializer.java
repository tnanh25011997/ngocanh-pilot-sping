package com.magrabbit.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.magrabbit.config.WebMvcConfig;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	private static final String LOCATION = "E:/internship/images"; // Temporary location where files will be stored

	private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
	                                                   // Beyond that size spring will throw exception.
	private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
	private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
	private MultipartConfigElement getMultipartConfigElement() {

	MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
	            LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
	    return multipartConfigElement;
	}
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	    registration.setMultipartConfig(getMultipartConfigElement());
	}
}
