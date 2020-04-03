package com.magrabbit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.magrabbit.dao.IBrandDAO;
import com.magrabbit.entity.Brand;
import com.magrabbit.repository.BrandRepository;

@Repository("brandDAO")
@Transactional
public class BrandDAOImpl implements IBrandDAO {
	
	@Autowired
	private BrandRepository brandRepository;
	public void insertOrUpdate(Brand entity) {
		// TODO Auto-generated method stub
		brandRepository.save(entity);
		
		
	}

	public void delete(Brand entity) {
		// TODO Auto-generated method stub
		brandRepository.delete(entity);
		
	}

	public List<String> getAllBrandName() {
		// TODO Auto-generated method stub
		return brandRepository.getAllBrandName();
	}

	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}

	public Brand findBybrandName(String brandName) {
		// TODO Auto-generated method stub
		return brandRepository.findBybrandName(brandName);
	}

	
	

	

}
