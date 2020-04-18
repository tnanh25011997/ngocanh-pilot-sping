package com.magrabbit.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IProductDAO;
import com.magrabbit.entity.Product;
import com.magrabbit.service.IProductService;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;
import com.magrabbit.utility.SearchModel;

@Service
public class ProductServiceImpl implements IProductService {
	
	static final String INSERT_PRODUCT_SUCCESSFUL = "Insert Product Successful";
	static final String EDIT_PRODUCT_SUCCESSFUL = "Edit Product Successful";
	static final String DELETE_PRODUCT_SUCCESSFUL = "Delete Product Successful";
	static final String INSERT_PRODUCT_FAILED = "Insert Product Failed";
	static final String EDIT_PRODUCT_FAILED = "Edit Product Failed";
	static final String DELETE_PRODUCT_FAILED = "Delete Product Failed";

	@Autowired
	private IProductDAO productDAO;
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}
	
	@Override
	public ResponseModel addProduct(Product entity) {
		try {
			productDAO.insertOrUpdate(entity);
			return new ResponseModel(HttpStatus.OK, INSERT_PRODUCT_SUCCESSFUL);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseModel(HttpStatus.BAD_REQUEST, INSERT_PRODUCT_FAILED);
		}
		
	}
	
	@Override
	public ResponseModel deleteProduct(Product entity) {
		try {
			productDAO.delete(entity);
			return new ResponseModel(HttpStatus.OK, DELETE_PRODUCT_SUCCESSFUL);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseModel(HttpStatus.BAD_REQUEST, DELETE_PRODUCT_FAILED);
		}
		
	}
	
	@Override
	public ResponseModel editProduct(Product entity) {
		try {
			productDAO.insertOrUpdate(entity);
			return new ResponseModel(HttpStatus.OK, EDIT_PRODUCT_SUCCESSFUL);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseModel(HttpStatus.BAD_REQUEST, EDIT_PRODUCT_FAILED);
		}
		
	}
	
	@Override
	public PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage) {
		
		return productDAO.getProductsByPageable(searchModel, pageable, currentPage);
	}

}
