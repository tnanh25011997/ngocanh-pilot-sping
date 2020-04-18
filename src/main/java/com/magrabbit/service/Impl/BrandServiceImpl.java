package com.magrabbit.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IBrandDAO;
import com.magrabbit.entity.Brand;
import com.magrabbit.service.IBrandService;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;



@Service
public class BrandServiceImpl implements IBrandService {
	
	static final String INSERT_BRAND_SUCCESSFUL = "Insert Brand Successful";
	static final String EDIT_BRAND_SUCCESSFUL = "Edit Brand Successful";
	static final String DELETE_BRAND_SUCCESSFUL = "Delete Brand Successful";
	static final String INSERT_BRAND_FAILED = "Insert Brand Failed";
	static final String EDIT_BRAND_FAILED = "Edit Brand Failed";
	static final String DELETE_BRAND_FAILED = "Delete Brand Failed";
	
	@Autowired
	private IBrandDAO brandDAO;
	
	@Override
	public List<String> getAllBrandName() {
		// TODO Auto-generated method stub
		return brandDAO.getAllBrandName();
	}
	
	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandDAO.findAll();
	}
	
	@Override
	public ResponseModel addBrand(Brand entity) {
		try {
			brandDAO.insertOrUpdate(entity);
			return new ResponseModel(HttpStatus.OK, INSERT_BRAND_SUCCESSFUL);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseModel(HttpStatus.BAD_REQUEST, INSERT_BRAND_FAILED);
		}
		
	}
	
	@Override
	public ResponseModel deleteBrand(Brand entity) {
		try {
			brandDAO.delete(entity);
			return new ResponseModel(HttpStatus.OK, DELETE_BRAND_SUCCESSFUL);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseModel(HttpStatus.BAD_REQUEST, DELETE_BRAND_FAILED);
		}
		
	}
	
	@Override
	public ResponseModel editBrand(Brand entity) {
		try {
			brandDAO.insertOrUpdate(entity);
			return new ResponseModel(HttpStatus.OK, EDIT_BRAND_SUCCESSFUL);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseModel(HttpStatus.BAD_REQUEST, EDIT_BRAND_FAILED);
		}
		
	}
	
	@Override
	public Brand findBybrandName(String brandName) {
		// TODO Auto-generated method stub
		return brandDAO.findBybrandName(brandName);
	}
	
	@Override
	public PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage) {
		// TODO Auto-generated method stub
		return brandDAO.getBrandsByPageable(brandName, pageable, currentPage);
	}
	
}
