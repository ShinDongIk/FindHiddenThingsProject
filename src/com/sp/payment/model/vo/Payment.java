package com.sp.payment.model.vo;

import java.sql.Date;

public class Payment {
	private String impUid;
	private Date payDate;
	private String applyNo;
	private int productNo;
	private int buyerNo;
	private String merchantUid; 
	private String buyerName;
	private String productTitle;
	private int productPrice;
	
	public Payment() {
		super();
	}
	
	public String getMerchantUid() {
		return merchantUid;
	}

	public void setMerchantUid(String merchantUid) {
		this.merchantUid = merchantUid;
	}
	
	

	public Payment(int productNo,String productTitle,String buyerName,int buyerNo,String impUid, String merchantUid, Date payDate, String applyNo,int productPrice) {
		super();
		this.impUid = impUid;
		this.payDate = payDate;
		this.applyNo = applyNo;
		this.productNo = productNo;
		this.buyerNo = buyerNo;
		this.merchantUid = merchantUid;
		this.buyerName = buyerName;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
	}

	public Payment(String impUid, Date payDate, String applyNo, int productNo, int buyerNo, String merchantUid) {
		super();
		this.impUid = impUid;
		this.payDate = payDate;
		this.applyNo = applyNo;
		this.productNo = productNo;
		this.buyerNo = buyerNo;
		this.merchantUid = merchantUid;
	}
	
	

	public String getImpUid() {
		return impUid;
	}
	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public int getBuyerNo() {
		return buyerNo;
	}
	public void setBuyerNo(int buyerNo) {
		this.buyerNo = buyerNo;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
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

	@Override
	public String toString() {
		return "Payment [impUid=" + impUid + ", payDate=" + payDate + ", applyNo=" + applyNo + ", productNo="
				+ productNo + ", buyerNo=" + buyerNo + ", merchantUid=" + merchantUid + ", buyerName=" + buyerName
				+ ", productTitle=" + productTitle + ", productPrice=" + productPrice + "]";
	}

	
	
	
	
	
	
	
}
