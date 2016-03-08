package com.yuzhaibu.entity;

import org.springframework.stereotype.Repository;

@Repository
public class ItemImg {
	
	private Integer id;
	private String imgpath;
	private Integer itemid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	
	
	
}
