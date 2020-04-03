package com.magrabbit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.magrabbit.dao.IProductDAO;
import com.magrabbit.entity.Product;
import com.magrabbit.repository.ProductRepository;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements IProductDAO {
	
	@Autowired
	private ProductRepository productRepository;

	public void insertOrUpdate(Product entity) {
		// TODO Auto-generated method stub
		productRepository.save(entity);
	}

	public void delete(Product entity) {
		// TODO Auto-generated method stub
		productRepository.delete(entity);
	}

	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	
	
	
	
}
