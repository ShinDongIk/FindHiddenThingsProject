package com.sp.product.model.vo;

import java.util.Date;

public class ProductDetail {

	private int productNo;
	private String productTitle;
	private int productPrice;
	private int productPick;
	private String userNickName;
	private int userNo;
	private String userName;
	private String userPhone;
	private String productStatus;
	private String sellStatus;
	private String category;
	private int productView;
	private String productTransaction; //거래방법
	private String productNego;
	private String productContent;
	private Date productEnterDate;
	
	public ProductDetail() {
		super();
	}

	
	public ProductDetail(int productNo, String productTitle, int productPrice, int productPick, int userNo, String userNickName,
			String userName, String category, int productView, String productTransaction,
			String productNego, String productContent) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNickName = userNickName;
		this.userNo = userNo;
		this.userName = userName;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
	}


	public ProductDetail(int productNo, String productTitle, int productPrice, int productPick, String userNickName,
			int userNo, String userName, String userPhone, String productStatus, String sellStatus, String category,
			int productView, String productTransaction, String productNego, String productContent,
			Date productEnterDate) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNickName = userNickName;
		this.userNo = userNo;
		this.userName = userName;
		this.userPhone = userPhone;
		this.productStatus = productStatus;
		this.sellStatus = sellStatus;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productEnterDate = productEnterDate;
	}


	public ProductDetail(int productNo, String productTitle, int productPrice, int productPick, String userNickName,
			String userName, String userPhone, String productStatus, String sellStatus, String category,
			int productView, String productTransaction, String productNego, String productContent,
			Date productEnterDate) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNickName = userNickName;
		this.userName = userName;
		this.userPhone = userPhone;
		this.productStatus = productStatus;
		this.sellStatus = sellStatus;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productEnterDate = productEnterDate;
	}

	public ProductDetail(int productNo, String productTitle, int productPrice, String productContent, String userName,String userPhone, int productPick,String userNickName, int productView, String productNego , String category, String productTransaction) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userName = userName;
		this.productView = productView;
		this.productNego = productNego;
		this.productContent = productContent;
		this.userNickName = userNickName;
		this.userPhone = userPhone;
		this.category = category;
		this.productTransaction = productTransaction;
	}

	public ProductDetail(int productNo, String productTitle, int productPrice, String category,
			String productTransaction, String productContent) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.category = category;
		this.productTransaction = productTransaction;
		this.productContent = productContent;
	}


	public int getProductNo() {
		return productNo;
	}


	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}


	public String getProductTitle() {
		return productTitle;
	}


	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}


	public int getProductPick() {
		return productPick;
	}


	public void setProductPick(int productPick) {
		this.productPick = productPick;
	}


	public String getUserNickName() {
		return userNickName;
	}


	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getProductStatus() {
		return productStatus;
	}


	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}


	public String getSellStatus() {
		return sellStatus;
	}


	public void setSellStatus(String sellStatus) {
		this.sellStatus = sellStatus;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getProductView() {
		return productView;
	}


	public void setProductView(int productView) {
		this.productView = productView;
	}


	public String getProductTransaction() {
		return productTransaction;
	}


	public void setProductTransaction(String productTransaction) {
		this.productTransaction = productTransaction;
	}


	public String getProductNego() {
		return productNego;
	}


	public void setProductNego(String productNego) {
		this.productNego = productNego;
	}


	public String getProductContent() {
		return productContent;
	}


	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}


	public Date getProductEnterDate() {
		return productEnterDate;
	}


	public void setProductEnterDate(Date productEnterDate) {
		this.productEnterDate = productEnterDate;
	}


	@Override
	public String toString() {
		return "ProductDetail [productNo=" + productNo + ", productTitle=" + productTitle + ", productPrice="
				+ productPrice + ", productPick=" + productPick + ", userNickName=" + userNickName + ", userNo="
				+ userNo + ", userName=" + userName + ", userPhone=" + userPhone + ", productStatus=" + productStatus
				+ ", sellStatus=" + sellStatus + ", category=" + category + ", productView=" + productView
				+ ", productTransaction=" + productTransaction + ", productNego=" + productNego + ", productContent="
				+ productContent + ", productEnterDate=" + productEnterDate + "]";
	}

}
