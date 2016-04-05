package com.yuzhaibu.entity;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class Item {
	
	private Integer itemid;
	private String itemname;
	private Double sellprice;
	private Double originprice;
	private String color;
	private String tradeposition;
	private Integer sellerid;
	private Integer bargain;
	private String discreption;
	private Timestamp itemcreatime;
	private Integer viewtime;
	private String itemmainimg;
	private Integer sellstatus;
	private Integer itemclassid;
	private User_normal usernormal;
	private ItemClass itemClass;
	private Integer favcount;
	private Integer mescount;
	private Integer userid;
	private String username;
	private Integer index;
	private Integer pagesize;
	private Integer headimg;
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public Double getSellprice() {
		return sellprice;
	}
	public void setSellprice(Double sellprice) {
		this.sellprice = sellprice;
	}
	public Double getOriginprice() {
		return originprice;
	}
	public void setOriginprice(Double originprice) {
		this.originprice = originprice;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTradeposition() {
		return tradeposition;
	}
	public void setTradeposition(String tradeposition) {
		this.tradeposition = tradeposition;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getBargain() {
		return bargain;
	}
	public void setBargain(Integer bargain) {
		this.bargain = bargain;
	}
	public String getDiscreption() {
		return discreption;
	}
	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}
	public Timestamp getItemcreatime() {
		return itemcreatime;
	}
	public void setItemcreatime(Timestamp itemcreatime) {
		this.itemcreatime = itemcreatime;
	}
	public Integer getViewtime() {
		return viewtime;
	}
	public void setViewtime(Integer viewtime) {
		this.viewtime = viewtime;
	}
	public String getItemmainimg() {
		return itemmainimg;
	}
	public void setItemmainimg(String itemmainimg) {
		this.itemmainimg = itemmainimg;
	}
	public Integer getSellstatus() {
		return sellstatus;
	}
	public void setSellstatus(Integer sellstatus) {
		this.sellstatus = sellstatus;
	}
	public Integer getItemclassid() {
		return itemclassid;
	}
	public void setItemclassid(Integer itemclassid) {
		this.itemclassid = itemclassid;
	}
	public User_normal getUsernormal() {
		return usernormal;
	}
	public void setUsernormal(User_normal usernormal) {
		this.usernormal = usernormal;
	}
	public ItemClass getItemClass() {
		return itemClass;
	}
	public void setItemClass(ItemClass itemClass) {
		this.itemClass = itemClass;
	}
	public Integer getFavcount() {
		return favcount;
	}
	public void setFavcount(Integer favcount) {
		this.favcount = favcount;
	}
	public Integer getMescount() {
		return mescount;
	}
	public void setMescount(Integer mescount) {
		this.mescount = mescount;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getHeadimg() {
		return headimg;
	}
	public void setHeadimg(Integer headimg) {
		this.headimg = headimg;
	}
	
	
	
	
}
