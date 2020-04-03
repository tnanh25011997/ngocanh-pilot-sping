package com.magrabbit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.magrabbit.entity.Brand;

@Repository("brandRepository")
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
	Brand findBybrandName(String name);
	
	@Query("SELECT b.brandName  FROM Brand b")
	List<String> getAllBrandName();
}
