package com.magrabbit.controller;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.magrabbit.entity.Brand;
import com.magrabbit.service.IBrandService;
import com.magrabbit.utility.PageModel;
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
	@PostMapping(value = "/insert-brand")
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
	
	@GetMapping(value = "/get-brands-paginate", params = { "page", "name" })
	public PageModel<Brand> getBrandsByPageable(@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "name") String name) {
		return brandService.getBrandsByPageable(name, PageRequest.of(page, 4), page);
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	 public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file, @RequestParam(name = "logoName") String logoName){
	  
	  String originalFilename = file.getOriginalFilename();
	  File destinationFile = new File("E:\\Internship\\ngocanh-pilot\\src\\assets\\images/"+logoName);
	  try {
                 
	       file.transferTo(destinationFile);	
		   System.out.println("File path "+destinationFile.getPath());
		   System.out.println("File size "+file.getSize());
	  } catch (Exception e) {
	   
	   e.printStackTrace();
	  }
	  
	  
	  return new ResponseEntity(destinationFile.getPath(),HttpStatus.CREATED);
	 }
	
	
	
}
