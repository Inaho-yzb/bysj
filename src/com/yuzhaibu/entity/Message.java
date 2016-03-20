package com.yuzhaibu.entity;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

@Repository
public class Message {

	private int mes_id;
	private int mes_itemid;
	private String mes_itemname;
	private String mes_itemmainimg;
	private int mes_levuserid;
	private String mes_levusername;
	private String mes_levuserheadpic;
	private int mes_touserid;
	private int mes_tousername;
	private String mes_content;
	private int mes_status;
	
	private Timestamp createtime;
	private Timestamp audittime;
	
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getAudittime() {
		return audittime;
	}
	public void setAudittime(Timestamp audittime) {
		this.audittime = audittime;
	}
	public int getMes_id() {
		return mes_id;
	}
	public void setMes_id(int mes_id) {
		this.mes_id = mes_id;
	}
	public int getMes_itemid() {
		return mes_itemid;
	}
	public void setMes_itemid(int mes_itemid) {
		this.mes_itemid = mes_itemid;
	}
	public int getMes_levuserid() {
		return mes_levuserid;
	}
	public void setMes_levuserid(int mes_levuserid) {
		this.mes_levuserid = mes_levuserid;
	}
	public int getMes_touserid() {
		return mes_touserid;
	}
	public void setMes_touserid(int mes_touserid) {
		this.mes_touserid = mes_touserid;
	}
	
	public int getMes_status() {
		return mes_status;
	}
	public void setMes_status(int mes_status) {
		this.mes_status = mes_status;
	}
	public String getMes_itemname() {
		return mes_itemname;
	}
	public void setMes_itemname(String mes_itemname) {
		this.mes_itemname = mes_itemname;
	}
	public String getMes_itemmainimg() {
		return mes_itemmainimg;
	}
	public void setMes_itemmainimg(String mes_itemmainimg) {
		this.mes_itemmainimg = mes_itemmainimg;
	}
	public String getMes_levusername() {
		return mes_levusername;
	}
	public void setMes_levusername(String mes_levusername) {
		this.mes_levusername = mes_levusername;
	}
	public int getMes_tousername() {
		return mes_tousername;
	}
	public void setMes_tousername(int mes_tousername) {
		this.mes_tousername = mes_tousername;
	}
	public String getMes_content() {
		return mes_content;
	}
	public void setMes_content(String mes_content) {
		this.mes_content = mes_content;
	}
	public String getMes_levuserheadpic() {
		return mes_levuserheadpic;
	}
	public void setMes_levuserheadpic(String mes_levuserheadpic) {
		this.mes_levuserheadpic = mes_levuserheadpic;
	}
}
