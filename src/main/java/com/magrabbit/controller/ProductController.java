package com.magrabbit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magrabbit.entity.Product;
import com.magrabbit.service.IProductService;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;
import com.magrabbit.utility.SearchModel;

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
	@PostMapping(value = "/delete-product")
	public ResponseModel deleteProduct(@RequestBody Product product) {
		return productService.deleteProduct(product);
	}
	@PutMapping(value = "/edit-product")
	public ResponseModel editProduct(@RequestBody Product product) {
		return productService.editProduct(product);
	}
	
	@PostMapping(value = "/get-products-paginate", params = { "page" })
	public PageModel<Product> getProductsByPageable(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestBody SearchModel searchModel) {
		return productService.getProductsByPageable(searchModel, PageRequest.of(page, 4), page);
	}
}
