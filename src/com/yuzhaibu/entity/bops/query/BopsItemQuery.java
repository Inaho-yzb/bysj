package com.yuzhaibu.entity.bops.query;

import java.util.Date;

import com.yuzhaibu.entity.Item;
import com.yuzhaibu.util.Pagination;

public class BopsItemQuery extends Pagination<Item> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5422644174939016306L;
	private String ItemName;
	private Double StartSell;
	private Double EndSell;
	private Double StartOrigin;
	private String EndOrigin;
	private String Tradeposition;
	private Integer Bargain;
	private String SellerNickName;
	private String StartCreateTime;
	private String EndCreateTime;
	private Integer SellStatus;
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Double getStartSell() {
		return StartSell;
	}
	public void setStartSell(Double startSell) {
		StartSell = startSell;
	}
	public Double getEndSell() {
		return EndSell;
	}
	public void setEndSell(Double endSell) {
		EndSell = endSell;
	}
	public Double getStartOrigin() {
		return StartOrigin;
	}
	public void setStartOrigin(Double startOrigin) {
		StartOrigin = startOrigin;
	}
	public String getEndOrigin() {
		return EndOrigin;
	}
	public void setEndOrigin(String endOrigin) {
		EndOrigin = endOrigin;
	}
	public String getTradeposition() {
		return Tradeposition;
	}
	public void setTradeposition(String tradeposition) {
		Tradeposition = tradeposition;
	}
	public Integer getBargain() {
		return Bargain;
	}
	public void setBargain(Integer bargain) {
		Bargain = bargain;
	}
	public String getSellerNickName() {
		return SellerNickName;
	}
	public void setSellerNickName(String sellerNickName) {
		SellerNickName = sellerNickName;
	}
	public String getStartCreateTime() {
		return StartCreateTime;
	}
	public void setStartCreateTime(String startCreateTime) {
		StartCreateTime = startCreateTime;
	}
	public String getEndCreateTime() {
		return EndCreateTime;
	}
	public void setEndCreateTime(String endCreateTime) {
		EndCreateTime = endCreateTime;
	}
	public Integer getSellStatus() {
		return SellStatus;
	}
	public void setSellStatus(Integer sellStatus) {
		SellStatus = sellStatus;
	}
	
}
