package com.magrabbit.dao;

import java.util.List;

import com.magrabbit.entity.Brand;

public interface IBrandDAO extends GenericDAO<Brand, Integer> {
	List<String> getAllBrandName();
	List<Brand> findAll();
	
	Brand findBybrandName(String brandName);
	
}
