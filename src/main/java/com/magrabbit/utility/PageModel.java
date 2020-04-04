package com.magrabbit.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;

public class PageModel<T> {
	private List<T> responseData;
	private Pageable pageable;
	private int currentPage;
	private int totalPage;
	private List<Integer> pageNumbersList;
	public PageModel(List<T> responseData, Pageable pageable, int currentPage, int totalPage) {
		super();
		this.responseData = responseData;
		this.pageable = pageable;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.pageNumbersList = getPageNumbersList(currentPage, totalPage, 3);
	}
	public PageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static List<Integer> getPageNumbersList(int currentPage, int totalPage, int maxPageDisplay) {

		List<Integer> pageNumberList = new ArrayList<Integer>();

		int pageMin;
		int pageMax;
		pageMin = currentPage - (maxPageDisplay - 1) / 2;
		pageMax = currentPage + (maxPageDisplay - 1) / 2;

		if (pageMin <= 0) {
			pageMin = 1;
			pageMax = maxPageDisplay;
		}

		if (pageMax > totalPage) {
			pageMax = totalPage;
			pageMin = totalPage - maxPageDisplay + 1;
		}

		for (int i = pageMin; i <= pageMax; i++) {
			if (i > 0) {
				pageNumberList.add(i);
			}
		}

		return pageNumberList;
	}
	public List<T> getResponseData() {
		return responseData;
	}
	public void setResponseData(List<T> responseData) {
		this.responseData = responseData;
	}
	public Pageable getPageable() {
		return pageable;
	}
	public void setPageable(Pageable pageable) {
		this.pageable = pageable;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<Integer> getPageNumbersList() {
		return pageNumbersList;
	}
	public void setPageNumbersList(List<Integer> pageNumbersList) {
		this.pageNumbersList = pageNumbersList;
	}
	
	
	
	
}
