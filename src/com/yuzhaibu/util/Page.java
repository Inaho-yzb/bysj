package com.yuzhaibu.util;

import java.util.List;

public class Page {
	private Integer count;
	private Integer pageCount;
	private Integer pageSize;
	private Integer currentPage;
	private Integer prvPage;
	private Integer nextPage;
	
	private List<Integer> pageList;
	
	Page(Integer count,Integer pageSize,Integer currentPage){
		this.count = count;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}
	
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPrvPage() {
		return prvPage;
	}
	public void setPrvPage(Integer prvPage) {
		this.prvPage = prvPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	
	
	
}
