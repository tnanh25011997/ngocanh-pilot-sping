package com.magrabbit.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import com.magrabbit.dao.IProductDAO;
import com.magrabbit.entity.Brand;
import com.magrabbit.entity.Product;
import com.magrabbit.repository.ProductRepository;
import com.magrabbit.utility.PageModel;
import com.magrabbit.utility.SearchModel;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements IProductDAO {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void insertOrUpdate(Product entity) {
		// TODO Auto-generated method stub
		productRepository.save(entity);
	}
	
	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub
		productRepository.delete(entity);
	}
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	
	@Override
	public PageModel<Product> getProductsByPageable(SearchModel searchModel, Pageable pageable, int currentPage) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> cq = cb.createQuery(Product.class);
		Root<Brand> brand = cq.from(Brand.class);
		Join<Brand, Product> product = brand.join("productSet");
		
		//sort
		Order sortById = cb.desc(product.get("productId"));
		
		cq.select(product);
		cq.orderBy(sortById);
		
		// condition
		setConditionSearchProducts(searchModel, cb, cq, brand, product);

		TypedQuery<Product> query = em.createQuery(cq);

		// pageable
		int totalPage = (query.getResultList().size() - 1) / pageable.getPageSize() + 1;
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		PageModel<Product> pageModel = new PageModel<Product>(query.getResultList(), pageable, currentPage, totalPage);

		return pageModel;
	}
	
	
	private void setConditionSearchProducts(SearchModel searchModel, CriteriaBuilder cb, CriteriaQuery<Product> cq,
			Root<Brand> brand, Join<Brand, Product> product) {

		// List condition
		List<Predicate> predicates = new ArrayList<Predicate>();

		// sort search by price
		Order sortPrice = cb.asc(product.get("price"));
		javax.persistence.criteria.Path<String> pro = product.get("productName");
		javax.persistence.criteria.Path<String> br = brand.get("brandName");
		javax.persistence.criteria.Path<Double> pri = product.get("price");
		
		// search by product name
		if (searchModel.getProductName() != "") {
			Predicate productNameCondition = cb.like(pro,
					"%" + searchModel.getProductName() + "%");
			predicates.add(productNameCondition);
		}

		// search by brand name
		if (searchModel.getBrandName() != "") {
			Predicate brandNameCondition = cb.like(br, searchModel.getBrandName());
			predicates.add(brandNameCondition);
			cq.orderBy(sortPrice);
		}

		// search by min price
		if (searchModel.getPriceFrom() != 0 && searchModel.getPriceTo() == 0) {
			Predicate priceFromCondition = cb.ge(pri, searchModel.getPriceFrom());
			predicates.add(priceFromCondition);
			cq.orderBy(sortPrice);
		}

		// search by max price
		if (searchModel.getPriceFrom() == 0 && searchModel.getPriceTo() != 0) {
			Predicate priceToCondition = cb.le(pri, searchModel.getPriceTo());
			predicates.add(priceToCondition);
			cq.orderBy(sortPrice);
		}

		// search from min price to max price
		if (searchModel.getPriceFrom() != 0 && searchModel.getPriceTo() != 0) {
			Predicate priceCondition = cb.between(pri, searchModel.getPriceFrom(),
					searchModel.getPriceTo());
			predicates.add(priceCondition);
			cq.orderBy(sortPrice);
		}

		cq.where(predicates.toArray(new Predicate[] {}));
	}

	
	
	
	
}
