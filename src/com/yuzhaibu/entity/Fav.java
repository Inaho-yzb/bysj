package com.yuzhaibu.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Fav {

	private int favid;
	private Item item;
	private int sellerauthen;
	private String sellernickname;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getSellerauthen() {
		return sellerauthen;
	}
	public void setSellerauthen(int sellerauthen) {
		this.sellerauthen = sellerauthen;
	}
	public String getSellernickname() {
		return sellernickname;
	}
	public void setSellernickname(String sellernickname) {
		this.sellernickname = sellernickname;
	}
	public int getFavid() {
		return favid;
	}
	public void setFavid(int favid) {
		this.favid = favid;
	}
	
	
}
