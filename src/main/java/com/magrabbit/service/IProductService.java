package com.magrabbit.service;

import java.util.List;

import com.magrabbit.entity.Product;
import com.magrabbit.utility.ResponseModel;

public interface IProductService {
	List<Product> findAll();
	ResponseModel addProduct(Product entity);
}
