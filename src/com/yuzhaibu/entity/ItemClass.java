package com.yuzhaibu.entity;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class ItemClass {
	
	private int itemclass_id;
	private String itemclass_name;
	private int itemclass_fatherid;
	private String fatherclass;
	
	public int getItemclass_id() {
		return itemclass_id;
	}
	public void setItemclass_id(int itemclass_id) {
		this.itemclass_id = itemclass_id;
	}
	public String getItemclass_name() {
		return itemclass_name;
	}
	public void setItemclass_name(String itemclass_name) {
		this.itemclass_name = itemclass_name;
	}
	public int getItemclass_fatherid() {
		return itemclass_fatherid;
	}
	public void setItemclass_fatherid(int itemclass_fatherid) {
		this.itemclass_fatherid = itemclass_fatherid;
	}
	public String getFatherclass() {
		return fatherclass;
	}
	public void setFatherclass(String fatherclass) {
		this.fatherclass = fatherclass;
	}
	
	
}
