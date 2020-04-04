package com.magrabbit.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IProductDAO;
import com.magrabbit.entity.Product;
import com.magrabbit.service.IProductService;
import com.magrabbit.utility.ResponseModel;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDAO productDAO;
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}
	public ResponseModel addProduct(Product entity) {
		// TODO Auto-generated method stub
		productDAO.insertOrUpdate(entity);
		return new ResponseModel(HttpStatus.OK, "Insert Product successful");
	}
	public ResponseModel deleteProduct(Product entity) {
		productDAO.delete(entity);
		return new ResponseModel(HttpStatus.OK, "Delete Product successful");
	}
	public ResponseModel editProduct(Product entity) {
		productDAO.insertOrUpdate(entity);
		return new ResponseModel(HttpStatus.OK, "Edit Product successful");
	}

}
