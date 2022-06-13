package com.sp.postbox.model.vo;

public class Tracking {
//	private int trackingNumber;
	private Long trackingNumber;
	private String productName;
	private int productNo;
	private String postboxCompany;
	private int buyerNo;
	public Tracking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tracking(Long trackingNumber, String productName, int productNo, String postboxCompany, int buyerNo) {
		super();
		this.trackingNumber = trackingNumber;
		this.productName = productName;
		this.productNo = productNo;
		this.postboxCompany = postboxCompany;
		this.buyerNo = buyerNo;
	}
	
	public Tracking(Long trackingNumber, int productNo, String postboxCompany, int buyerNo) {
		super();
		this.trackingNumber = trackingNumber;
		this.productNo = productNo;
		this.postboxCompany = postboxCompany;
		this.buyerNo = buyerNo;
	}
	
	public Tracking(String productName) {
		super();
		this.productName = productName;
	}
	public Tracking(int productNo) {
		super();
		this.productNo = productNo;
	}
	public Long getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(Long trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getPostboxCompany() {
		return postboxCompany;
	}
	public void setPostboxCompany(String postboxCompany) {
		this.postboxCompany = postboxCompany;
	}
	public int getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(int buyerNo) {
		this.buyerNo = buyerNo;
	}
	@Override
	public String toString() {
		return "Tracking [trackingNumber=" + trackingNumber + ", productName=" + productName + ", productNo="
				+ productNo + ", postboxCompany=" + postboxCompany + ", buyerNo=" + buyerNo + "]";
	}
}
