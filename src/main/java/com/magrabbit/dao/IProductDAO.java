package com.magrabbit.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.magrabbit.entity.Product;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.SearchModel;

public interface IProductDAO extends GenericDAO<Product, Integer> {
	List<Product> findAll();
	
	PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage);
}
