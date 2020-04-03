package com.magrabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magrabbit.entity.Product;
import com.magrabbit.service.IProductService;
import com.magrabbit.utility.ResponseModel;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping(value ="/get-all-product")
	public List<Product> getAllBrand(){
		return productService.findAll();
	}
	
	@PostMapping(value = "/add-new-product")
	public ResponseModel addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
}
