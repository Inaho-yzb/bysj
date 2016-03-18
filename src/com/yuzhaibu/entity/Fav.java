package com.yuzhaibu.entity;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class Fav {
	
	private Integer favid;
	private Item item;
	private Integer itemid;
	private Integer sellerauthen;
	private String nickname;
	private Integer favUserId;
	private String itemname;
	private Double sellprice;
	private Double originprice;
	private String color;
	private String tradeposition;
	private Integer sellerid;
	private String discreption;
	private String itemmainimg;
	private Timestamp itemcreatime;
	private Integer viewtime;
	private Integer sellstatus;
	
	
	public Integer getFavid() {
		return favid;
	}
	public void setFavid(Integer favid) {
		this.favid = favid;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getSellerauthen() {
		return sellerauthen;
	}
	public void setSellerauthen(Integer sellerauthen) {
		this.sellerauthen = sellerauthen;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getFavUserId() {
		return favUserId;
	}
	public void setFavUserId(Integer favUserId) {
		this.favUserId = favUserId;
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
	public Integer getSellstatus() {
		return sellstatus;
	}
	public void setSellstatus(Integer sellstatus) {
		this.sellstatus = sellstatus;
	}
	
	
	
	
}
