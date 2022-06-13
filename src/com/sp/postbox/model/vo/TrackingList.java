package com.sp.postbox.model.vo;

public class TrackingList {
	private int postboxNumberNo;	//	POSTBOX_NUMBER_NO	NUMBER
	private int postboxNumber;	//	POSTBOX_NUMBER	NUMBER
	private int productNo;	//	PRODUCT_NO	NUMBER
	private int userNo;	//	USER_NO	NUMBER
	private String postboxCompanyName;	//	POSTBOX_COMPANY_NAME	VARCHAR2(100 BYTE)
	private String titleImg;
	public TrackingList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrackingList(int postboxNumberNo, int postboxNumber, int productNo, int userNo, String postboxCompanyName,
			String titleImg) {
		super();
		this.postboxNumberNo = postboxNumberNo;
		this.postboxNumber = postboxNumber;
		this.productNo = productNo;
		this.userNo = userNo;
		this.postboxCompanyName = postboxCompanyName;
		this.titleImg = titleImg;
	}
	
	public TrackingList(int postboxNumberNo, int postboxNumber, int productNo, int userNo, String postboxCompanyName) {
		super();
		this.postboxNumberNo = postboxNumberNo;
		this.postboxNumber = postboxNumber;
		this.productNo = productNo;
		this.userNo = userNo;
		this.postboxCompanyName = postboxCompanyName;
	}
	
	public TrackingList(int productNo, String titleImg) {
		super();
		this.productNo = productNo;
		this.titleImg = titleImg;
	}
	public int getPostboxNumberNo() {
		return postboxNumberNo;
	}
	public void setPostboxNumberNo(int postboxNumberNo) {
		this.postboxNumberNo = postboxNumberNo;
	}
	public int getPostboxNumber() {
		return postboxNumber;
	}
	public void setPostboxNumber(int postboxNumber) {
		this.postboxNumber = postboxNumber;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getPostboxCompanyName() {
		return postboxCompanyName;
	}
	public void setPostboxCompanyName(String postboxCompanyName) {
		this.postboxCompanyName = postboxCompanyName;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	@Override
	public String toString() {
		return "TrackingList [postboxNumberNo=" + postboxNumberNo + ", postboxNumber=" + postboxNumber + ", productNo="
				+ productNo + ", userNo=" + userNo + ", postboxCompanyName=" + postboxCompanyName + ", titleImg="
				+ titleImg + "]";
	}
	

}
