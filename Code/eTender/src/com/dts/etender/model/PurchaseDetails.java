package com.dts.etender.model;

public class PurchaseDetails {

	private int tenderid;
	private int itemid;
	private String companyname;
	private String postingdate;
	private String recepdate;
	private double pricebid;
	private String itemname;
	private String itemtype;
	
	
	
	public int getTenderid() {
		return tenderid;
	}
	public void setTenderid(int tenderid) {
		this.tenderid = tenderid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	public String getRecepdate() {
		return recepdate;
	}
	public void setRecepdate(String recepdate) {
		this.recepdate = recepdate;
	}
	public double getPricebid() {
		return pricebid;
	}
	public void setPricebid(double pricebid) {
		this.pricebid = pricebid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getItemtype() {
		return itemtype;
	}
	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	
}
