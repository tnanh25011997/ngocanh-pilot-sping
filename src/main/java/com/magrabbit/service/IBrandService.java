package com.magrabbit.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Brand;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;



public interface IBrandService {
	List<String> getAllBrandName();
	List<Brand> findAll();
	ResponseModel addBrand(Brand entity);
	ResponseModel deleteBrand(Brand entity);
	ResponseModel editBrand(Brand entity);
	Brand findBybrandName(String brandName);
	
	PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage);
	
} 
