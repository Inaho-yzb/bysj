package com.yuzhaibu.entity;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class Item {
	private int itemid;
	private String itemname;
	private int sellprice;
	private int originprice;
	private String color;
	private String tradeposition;
	private int sellerid;
	private int bargain;
	private String discreption;
	private Timestamp itemcreatime;
	private int viewtime;
	private String itemmainimg;
	private int sellstatus;
	private int itemclassid;
	private User_normal usernormal;
	private ItemClass itemClass;
	private int favcount;
	private int mescount;
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getSellprice() {
		return sellprice;
	}
	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}
	public int getOriginprice() {
		return originprice;
	}
	public void setOriginprice(int originprice) {
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
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public int getBargain() {
		return bargain;
	}
	public void setBargain(int bargain) {
		this.bargain = bargain;
	}
	public String getDiscreption() {
		return discreption;
	}
	public void setDiscreption(String discreption) {
		this.discreption = discreption;
	}
	
	public String getItemmainimg() {
		return itemmainimg;
	}
	public void setItemmainimg(String itemmainimg) {
		this.itemmainimg = itemmainimg;
	}
	public int getViewtime() {
		return viewtime;
	}
	public void setViewtime(int viewtime) {
		this.viewtime = viewtime;
	}
	public int getSellstatus() {
		return sellstatus;
	}
	public void setSellstatus(int sellstatus) {
		this.sellstatus = sellstatus;
	}
	public Timestamp getItemcreatime() {
		return itemcreatime;
	}
	public void setItemcreatime(Timestamp itemcreatime) {
		this.itemcreatime = itemcreatime;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getItemclassid() {
		return itemclassid;
	}
	public void setItemclassid(int itemclassid) {
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
	public int getFavcount() {
		return favcount;
	}
	public void setFavcount(int favcount) {
		this.favcount = favcount;
	}
	public int getMescount() {
		return mescount;
	}
	public void setMescount(int mescount) {
		this.mescount = mescount;
	}
	
}
