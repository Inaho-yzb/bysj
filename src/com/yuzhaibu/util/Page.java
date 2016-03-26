package com.yuzhaibu.util;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private Integer count;
	private Integer pageCount;
	private Integer pageSize;
	private Integer currentPage;
	private Integer prvPage;
	private Integer nextPage;
	
	private List<Integer> pageList;
	
	public List<Integer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

	public Page(Integer count,Integer pageSize,Integer currentPage){
		this.count = count;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		
		pageCount = calPageCount(count,pageSize);
		pageList = calPageList(currentPage,pageCount);
		prvPage = calPrePage(currentPage);
		nextPage = calNtPage(currentPage, pageList);
	}
	
	private Integer calPageCount(Integer c,Integer s){
		Integer pagec=1;
		if(c/s!=0){
			if(c%s!=0){
				pagec = c/s+1;
			}else{
				pagec = c/s;
			}
		}else{
			pagec=1;
		}
		
		return pagec;
	}
	
	private List<Integer> calPageList(Integer cur,Integer pc){
		List<Integer> li = new ArrayList<Integer>();
		if(pc<=5){
			for(int i=1;i<=pc;i++){
				li.add(i);
			}
		}else{
			if(cur<=pc-5){
				int index = cur%5;
				int cou = cur/5;
				for(int i=5*cou+1;i<=5*cou+5;i++){
					li.add(i);
				}
			}else{
				int index = cur%5;
				int cou = pc%5;
				for(int i=pc-cou+1;i<=pc;i++){
					li.add(i);
				}
			}
			
			
		}
		return li;
	}
	
	private Integer calPrePage(Integer cur){
		if(cur==1){
			return null;
		}else{
			return cur-1;
		}
	}
	
	private Integer calNtPage(Integer cur,List<Integer> pageList){
		if(pageList.lastIndexOf(cur.intValue())!=pageList.size()-1){
			return cur+1;
		}else{
			return null;
		}
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
