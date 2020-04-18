package com.magrabbit.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.magrabbit.dao.IBrandDAO;
import com.magrabbit.entity.Brand;
import com.magrabbit.repository.BrandRepository;
import com.magrabbit.utility.PageModel;

@Repository("brandDAO")
@Transactional
public class BrandDAOImpl implements IBrandDAO {
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private BrandRepository brandRepository;
	public void insertOrUpdate(Brand entity) {
		// TODO Auto-generated method stub
		brandRepository.save(entity);
		
		
	}
	
	@Override
	public void delete(Brand entity) {
		// TODO Auto-generated method stub
		brandRepository.delete(entity);
		
	}
	
	@Override
	public List<String> getAllBrandName() {
		// TODO Auto-generated method stub
		return brandRepository.getAllBrandName();
	}
	
	@Override
	public List<Brand> findAll() {
		// TODO Auto-generated method stub
		return brandRepository.findAll();
	}
	
	@Override
	public Brand findBybrandName(String brandName) {
		// TODO Auto-generated method stub
		return brandRepository.findBybrandName(brandName);
	}
	
	@Override
	public PageModel<Brand> getBrandsByPageable(String brandName, Pageable pageable, int currentPage) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Brand> cq = cb.createQuery(Brand.class);
		Root<Brand> brand = cq.from(Brand.class);
		
		//sort
		Order sortById = cb.desc(brand.get("brandId"));
		
		cq.select(brand);
		cq.orderBy(sortById);
		javax.persistence.criteria.Path<String> br = brand.get("brandName");
		
		// search
		if (brandName != "") {
			Predicate name = cb.like(br, "%" + brandName + "%");
			cq.where(name);
		}
		
		

		TypedQuery<Brand> query = em.createQuery(cq);

		int totalPage = (query.getResultList().size() - 1) / pageable.getPageSize() + 1;
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		PageModel<Brand> result = new PageModel<Brand>(query.getResultList(), pageable, currentPage, totalPage);

		return result;
	}

}
