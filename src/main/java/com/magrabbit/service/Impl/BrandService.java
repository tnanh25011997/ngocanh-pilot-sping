package com.magrabbit.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.magrabbit.dao.IBrandDAO;
import com.magrabbit.entity.Brand;
import com.magrabbit.service.IBrandService;
import com.magrabbit.utility.ResponseModel;



@Service
public class BrandService implements IBrandService {
	@Autowired
	private IBrandDAO brandDAO;
	public List<String> getAllBrandName() {
		// TODO Auto-generated method stub
		return brandDAO.getAllBrandName();
	}
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandDAO.findAll();
	}
	public ResponseModel addBrand(Brand entity) {
		brandDAO.insertOrUpdate(entity);
		return new ResponseModel(HttpStatus.OK, "Insert Brand successful");
	}
	public ResponseModel deleteBrand(Brand entity) {
		brandDAO.delete(entity);
		return new ResponseModel(HttpStatus.OK, "Delete Brand successful");
	}
	public ResponseModel editBrand(Brand entity) {
		brandDAO.insertOrUpdate(entity);
		return new ResponseModel(HttpStatus.OK, "Edit Brand successful");
	}
	public Brand findBybrandName(String brandName) {
		// TODO Auto-generated method stub
		return brandDAO.findBybrandName(brandName);
	}
	
}
