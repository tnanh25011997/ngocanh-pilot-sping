package com.magrabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magrabbit.entity.Brand;
import com.magrabbit.service.IBrandService;
import com.magrabbit.utility.ResponseModel;



@CrossOrigin
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	IBrandService brandService;
	@GetMapping(value ="/get-all-name")
	public List<String> getAllBrandName(){
		return brandService.getAllBrandName();
	}
	
	@GetMapping(value ="/get-all-brand")
	public List<Brand> getAllBrand(){
		return brandService.findAll();
	}
	@PostMapping(value = "/add-brand")
	public ResponseModel addBrand(@RequestBody Brand brand) {
		return brandService.addBrand(brand);
	}
	
	@PostMapping(value = "/delete-brand")
	public ResponseModel deleteBrand(@RequestBody Brand brand) {
		return brandService.deleteBrand(brand);
	}
	
	@PutMapping(value = "/edit-brand")
	public ResponseModel editBrand(@RequestBody Brand brand) {
		return brandService.editBrand(brand);
	}
	
	@GetMapping(value = "/get-brand/{brandName}")
	public Brand getAllBrandName(@PathVariable String brandName) {
		return brandService.findBybrandName(brandName);
	}
	
	
	
}
