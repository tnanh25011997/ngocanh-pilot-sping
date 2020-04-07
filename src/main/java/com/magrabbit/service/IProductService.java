package com.magrabbit.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Product;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.ResponseModel;
import com.magrabbit.utility.SearchModel;

public interface IProductService {
	List<Product> findAll();
	ResponseModel addProduct(Product entity);
	ResponseModel editProduct(Product entity);
	ResponseModel deleteProduct(Product entity);
	PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage);
}
