package com.magrabbit.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Brand;
import com.magrabbit.utility.PageModel;

public interface IBrandDAO extends GenericDAO<Brand, Integer> {
	List<String> getAllBrandName();
	List<Brand> findAll();
	
	Brand findBybrandName(String brandName);
	
	PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage);
	
}
