package com.dts.etender.model;

public class TenderPost {
	
	private String tenderid;
	private String postingdate;
	private String tendername;
	private double costofdoc;
	private double tendervalue;
	private int quantity;
	private String duedate;
	private String ordrreplaceddate;
	private String spicification;
	private int itemid;
	
	
	
	public String getTenderid() {
		return tenderid;
	}
	public void setTenderid(String tenderid) {
		this.tenderid = tenderid;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	public String getTendername() {
		return tendername;
	}
	public void setTendername(String tendername) {
		this.tendername = tendername;
	}
	public double getCostofdoc() {
		return costofdoc;
	}
	public void setCostofdoc(double costofdoc) {
		this.costofdoc = costofdoc;
	}
	public double getTendervalue() {
		return tendervalue;
	}
	public void setTendervalue(double tendervalue) {
		this.tendervalue = tendervalue;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	public String getOrdrreplaceddate() {
		return ordrreplaceddate;
	}
	public void setOrdrreplaceddate(String ordrreplaceddate) {
		this.ordrreplaceddate = ordrreplaceddate;
	}
	public String getSpicification() {
		return spicification;
	}
	public void setSpicification(String spicification) {
		this.spicification = spicification;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	

}
