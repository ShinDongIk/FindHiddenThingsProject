package com.sp.product.model.vo;

import java.util.Date;

public class Product {

	private int productNo;
	private String productTitle;
	private int productPrice;
	private int productPick;
	private int userNo;
	private String userNickName;
	private String userName;
	private String productStatus;
	private String sellStatus;
	private String category;
	private int productView;
	private String productTransaction; // 거래방법
	private String productNego;
	private String productContent;
	private Date productEnterDate;
	private String changeFileName;
	private Date payDate;

	public Product() {
		super();
	}

	
	public Product(int productNo, String productTitle, int productPrice, int productPick, int userNo,
			String userNickName, String userName, String category, int productView, String productTransaction,
			String productNego, String productContent) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNo = userNo;
		this.userNickName = userNickName;
		this.userName = userName;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
	}


	// purchase 매개변수 생성자
	public Product(int productNo, String productTitle, int productPrice, String userNickName, Date payDate) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.userNickName = userNickName;
		this.payDate = payDate;
	}

	// purchasefile 매개변수 생성자
	public Product(int productNo, String changeFileName) {
		super();
		this.productNo = productNo;
		this.changeFileName = changeFileName;
	}

	// pickSelectList 매개변수 생성자
	public Product(int productNo, String productTitle, int productPrice, String userNickName, String changeFileName) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.userNickName = userNickName;
		this.changeFileName = changeFileName;
	}

	public Product(int productNo, String productTitle, int productPrice, int productPick, String userName,
			String productStatus, String sellStatus, String category, int productView, String productTransaction,
			String productNego, String productContent, Date productEnterDate, String changeFileName) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userName = userName;
		this.productStatus = productStatus;
		this.sellStatus = sellStatus;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productEnterDate = productEnterDate;
		this.changeFileName = changeFileName;
	}

	public Product(int productNo, String productTitle, int productPrice, int productPick, int userNo, String userName,
			String productStatus, String sellStatus, String category, int productView, String productTransaction,
			String productNego, String productContent, Date productEnterDate) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNo = userNo;
		this.userName = userName;
		this.productStatus = productStatus;
		this.sellStatus = sellStatus;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productEnterDate = productEnterDate;
	}

	public Product(int productNo, String productTitle, int productPrice, int productPick, String userName,
			String productStatus, String sellStatus, String category, int productView, String productTransaction,
			String productNego, String productContent, Date productEnterDate) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userName = userName;
		this.productStatus = productStatus;
		this.sellStatus = sellStatus;
		this.category = category;
		this.productView = productView;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productEnterDate = productEnterDate;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getChangeFileName() {
		return changeFileName;
	}

	public void setChangeFileName(String changeFileName) {
		this.changeFileName = changeFileName;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", productTitle=" + productTitle + ", productPrice=" + productPrice
				+ ", productPick=" + productPick + ", userNo=" + userNo + ", userNickName=" + userNickName
				+ ", userName=" + userName + ", productStatus=" + productStatus + ", sellStatus=" + sellStatus
				+ ", category=" + category + ", productView=" + productView + ", productTransaction="
				+ productTransaction + ", productNego=" + productNego + ", productContent=" + productContent
				+ ", productEnterDate=" + productEnterDate + ", changeFileName=" + changeFileName + ", payDate="
				+ payDate + "]";
	}
}
