package com.magrabbit.service;

import java.util.List;

import com.magrabbit.entity.Brand;
import com.magrabbit.utility.ResponseModel;



public interface IBrandService {
	List<String> getAllBrandName();
	List<Brand> findAll();
	ResponseModel addBrand(Brand entity);
	ResponseModel deleteBrand(Brand entity);
	ResponseModel editBrand(Brand entity);
	Brand findBybrandName(String brandName);
	
} 
