package com.magrabbit.dao;

import java.util.List;

import com.magrabbit.entity.Product;

public interface IProductDAO extends GenericDAO<Product, Integer> {
	List<Product> findAll();
}
