package com.sp.PastSalesHistory.model.vo;

import java.sql.Date;

public class PastSalesHistoryList {
	
//PRODUCT_NO, FILE_LEVEL, PRODUCT_PRICE, PRODUCT_ENTERDATE, 
// CHAT_NO, PRODUCT_PICK, PRODUCT_VIEWS, PRODUCT_STATUS


private int productNo;				//	등록번호 // 사용은 안할듯 PRODUCT_NO	NUMBER
									// 상품정보 // 이미지 영상 본후 추가하기 
private String productTitle;		//	상품제목 // 혹시몰라서 놓음 PRODUCT_TITLE	VARCHAR2(100 BYTE)
private int productPrice;			// 판매금액   //     PRODUCT_PRICE	NUMBER
private Date productEnterDate;		//	등록일 // PRODUCT_ENTER_DATE	DATE
private int chatCount;				// 채팅수 // CHAT_LIST (COUNT) NUMBER
private int productPick;			//	받은찜 //  PRODUCT_PICK	NUMBER
private int productViews;			//	조회수 // PRODUCT_VIEWS	NUMBER
private String productSellStatus;		//	상태 // PRODUCT_Sell_STATUS	VARCHAR2(1 BYTE)


/*
private String sellStatus;			//	PRODUCT_SELL_STATUS	VARCHAR2(1 BYTE)
private String productCategory;		//	PRODUCT_CATEGORY	VARCHAR2(100 BYTE)
private String productTransaction;	//	PRODUCT_TRANSACTION	VARCHAR2(100 BYTE)
private String productNego;			//	PRODUCT_NEGO	VARCHAR2(100 BYTE)
private String productContent;		//	PRODUCT_CONTENT	VARCHAR2(4000 BYTE)
*/



public PastSalesHistoryList() {
	super();
}

public PastSalesHistoryList(int productNo, String productTitle, int productPrice, Date productEnterDate, int chatCount,
		int productPick, int productViews, String productSellStatus) {
	super();
	this.productNo = productNo;
	this.productTitle = productTitle;
	this.productPrice = productPrice;
	this.productEnterDate = productEnterDate;
	this.chatCount = chatCount;
	this.productPick = productPick;
	this.productViews = productViews;
	this.productSellStatus = productSellStatus;
}

public PastSalesHistoryList(String productTitle, int productPrice, Date productEnterDate, int chatCount,
		int productPick, int productViews, String productSellStatus) {
	super();
	this.productTitle = productTitle;
	this.productPrice = productPrice;
	this.productEnterDate = productEnterDate;
	this.chatCount = chatCount;
	this.productPick = productPick;
	this.productViews = productViews;
	this.productSellStatus = productSellStatus;
}

public PastSalesHistoryList(String productTitle, int productPrice, Date productEnterDate, int productPick,
		int productViews, String productSellStatus) {
	super();
	this.productTitle = productTitle;
	this.productPrice = productPrice;
	this.productEnterDate = productEnterDate;
	this.productPick = productPick;
	this.productViews = productViews;
	this.productSellStatus = productSellStatus;
}

public PastSalesHistoryList(int productNo, String productTitle, int productPrice, Date productEnterDate,
		int productPick, int productViews, String productSellStatus) {
	super();
	this.productNo = productNo;
	this.productTitle = productTitle;
	this.productPrice = productPrice;
	this.productEnterDate = productEnterDate;
	this.productPick = productPick;
	this.productViews = productViews;
	this.productSellStatus = productSellStatus;
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

public Date getProductEnterDate() {
	return productEnterDate;
}

public void setProductEnterDate(Date productEnterDate) {
	this.productEnterDate = productEnterDate;
}

public int getChatCount() {
	return chatCount;
}

public void setChatCount(int chatCount) {
	this.chatCount = chatCount;
}

public int getProductPick() {
	return productPick;
}

public void setProductPick(int productPick) {
	this.productPick = productPick;
}

public int getProductViews() {
	return productViews;
}

public void setProductViews(int productViews) {
	this.productViews = productViews;
}

public String getProductSellStatus() {
	return productSellStatus;
}

public void setProductSellStatus(String productSellStatus) {
	this.productSellStatus = productSellStatus;
}

@Override
public String toString() {
	return "PastSalesHistoryList [productNo=" + productNo + ", productTitle=" + productTitle + ", productPrice="
			+ productPrice + ", productEnterDate=" + productEnterDate + ", chatCount=" + chatCount + ", productPick="
			+ productPick + ", productViews=" + productViews + ", productSellStatus=" + productSellStatus + "]";
}


}



