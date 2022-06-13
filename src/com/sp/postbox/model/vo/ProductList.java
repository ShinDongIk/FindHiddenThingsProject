package com.sp.postbox.model.vo;

import java.sql.Date;

public class ProductList {
	private int productNo;	//	PRODUCT_NO	NUMBER
	private String productTitle;	//	PRODUCT_TITLE	VARCHAR2(100 BYTE)
	private int productPrice;	//	PRODUCT_PRICE	NUMBER
	private int productPick;	//	PRODUCT_PICK	NUMBER
	private int userNo;	//	USER_NO	NUMBER
	private String userName;
	private char productStatus;	//	PRODUCT_STATUS	VARCHAR2(1 BYTE)
	private char productSellStatus;	//	PRODUCT_SELL_STATUS	VARCHAR2(1 BYTE)
	private String productCategory;	//	PRODUCT_CATEGORY	VARCHAR2(100 BYTE)
	private int productViews;	//	PRODUCT_VIEWS	NUMBER
	private String productTransaction;	//	PRODUCT_TRANSACTION	VARCHAR2(100 BYTE)
	private String productNego;	//	PRODUCT_NEGO	VARCHAR2(100 BYTE)
	private String productContent;	//	PRODUCT_CONTENT	VARCHAR2(4000 BYTE)
	private Date productDate;	//	PRODUCT_ENTER_DATE	DATE
	private String titleImg;
	private Long postboxNumber;
	private String postboxCompanyName;
	public ProductList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProductList(int productNo, String productTitle, int productPrice, int productPick, int userNo,
			String userName, char productStatus, char productSellStatus, String productCategory, int productViews,
			String productTransaction, String productNego, String productContent, Date productDate, String titleImg) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNo = userNo;
		this.userName = userName;
		this.productStatus = productStatus;
		this.productSellStatus = productSellStatus;
		this.productCategory = productCategory;
		this.productViews = productViews;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productDate = productDate;
		this.titleImg = titleImg;
	}

	public ProductList(int productNo, String productTitle, int productPrice, int productPick, int userNo,
			String userName, char productStatus, char productSellStatus, String productCategory, int productViews,
			String productTransaction, String productNego, String productContent, Date productDate) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNo = userNo;
		this.userName = userName;
		this.productStatus = productStatus;
		this.productSellStatus = productSellStatus;
		this.productCategory = productCategory;
		this.productViews = productViews;
		this.productTransaction = productTransaction;
		this.productNego = productNego;
		this.productContent = productContent;
		this.productDate = productDate;
	}
	public ProductList(int productNo, String productTitle,  String productContent, int productPrice, Date productDate, String userName,
			int productPick, int productViews, String titleImg) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userName = userName;
		this.productViews = productViews;
		this.productContent = productContent;
		this.productDate = productDate;
		this.titleImg = titleImg;
	}
	
	public ProductList(int productNo, String productTitle,  String productContent, int productPrice, Date productDate, int userNo, String userName,
			int productPick, int productViews, String titleImg) {
		super();
		this.productNo = productNo;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productPick = productPick;
		this.userNo = userNo;
		this.userName = userName;
		this.productViews = productViews;
		this.productContent = productContent;
		this.productDate = productDate;
		this.titleImg = titleImg;
	}
	
	public ProductList(int productNo, String titleImg) {
		super();
		this.productNo = productNo;
		this.titleImg = titleImg;
	}
	
	public ProductList(int productNo, int userNo) {
		super();
		this.productNo = productNo;
		this.userNo = userNo;
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

	public char getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(char productStatus) {
		this.productStatus = productStatus;
	}

	public char getProductSellStatus() {
		return productSellStatus;
	}

	public void setProductSellStatus(char productSellStatus) {
		this.productSellStatus = productSellStatus;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductViews() {
		return productViews;
	}

	public void setProductViews(int productViews) {
		this.productViews = productViews;
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

	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public Long getPostboxNumber() {
		return postboxNumber;
	}

	public void setPostboxNumber(Long postboxNumber) {
		this.postboxNumber = postboxNumber;
	}

	public String getPostboxCompanyName() {
		return postboxCompanyName;
	}

	public void setPostboxCompanyName(String postboxCompanyName) {
		this.postboxCompanyName = postboxCompanyName;
	}

	@Override
	public String toString() {
		return "ProductList [productNo=" + productNo + ", productTitle=" + productTitle + ", productPrice="
				+ productPrice + ", productPick=" + productPick + ", userNo=" + userNo + ", userName=" + userName
				+ ", productStatus=" + productStatus + ", productSellStatus=" + productSellStatus + ", productCategory="
				+ productCategory + ", productViews=" + productViews + ", productTransaction=" + productTransaction
				+ ", productNego=" + productNego + ", productContent=" + productContent + ", productDate=" + productDate
				+ ", titleImg=" + titleImg + ", postboxNumber=" + postboxNumber + ", postboxCompanyName="
				+ postboxCompanyName + "]";
	}

	
}
