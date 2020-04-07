package com.magrabbit.utility;

public class SearchModel {
	
	private String productName;
	private String brandName;
	private Double priceFrom;
	private Double priceTo;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Double getPriceFrom() {
		return priceFrom;
	}
	public void setPriceFrom(Double priceFrom) {
		this.priceFrom = priceFrom;
	}
	public Double getPriceTo() {
		return priceTo;
	}
	public void setPriceTo(Double priceTo) {
		this.priceTo = priceTo;
	}
	public SearchModel(String productName, String brandName, Double priceFrom, Double priceTo) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.priceFrom = priceFrom;
		this.priceTo = priceTo;
	}
	public SearchModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
