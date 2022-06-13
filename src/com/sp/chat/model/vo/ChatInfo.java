package com.sp.chat.model.vo;

import java.sql.Date;

public class ChatInfo {
	private int chatNo;
	private String sellerNickName;
	private String buyerNickName;
	private String productTitle;
	private Date chatDate;
	private String chatStatus;
	
	public ChatInfo() {
		super();
	}

	public ChatInfo(int chatNo, String sellerNickName, String buyerNickName, String productTitle, Date chatDate,
			String chatStatus) {
		super();
		this.chatNo = chatNo;
		this.sellerNickName = sellerNickName;
		this.buyerNickName = buyerNickName;
		this.productTitle = productTitle;
		this.chatDate = chatDate;
		this.chatStatus = chatStatus;
	}

	public ChatInfo(String sellerNickName, String buyerNickName, String productTitle, Date chatDate,
			String chatStatus) {
		super();
		this.sellerNickName = sellerNickName;
		this.buyerNickName = buyerNickName;
		this.productTitle = productTitle;
		this.chatDate = chatDate;
		this.chatStatus = chatStatus;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getSellerNickName() {
		return sellerNickName;
	}

	public void setSellerNickName(String sellerNickName) {
		this.sellerNickName = sellerNickName;
	}

	public String getBuyerNickName() {
		return buyerNickName;
	}

	public void setBuyerNickName(String buyerNickName) {
		this.buyerNickName = buyerNickName;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public Date getChatDate() {
		return chatDate;
	}

	public void setChatDate(Date chatDate) {
		this.chatDate = chatDate;
	}

	public String getChatStatus() {
		return chatStatus;
	}

	public void setChatStatus(String chatStatus) {
		this.chatStatus = chatStatus;
	}

	@Override
	public String toString() {
		return "ChatInfo [chatNo=" + chatNo + ", sellerNickName=" + sellerNickName + ", buyerNickName=" + buyerNickName
				+ ", productTitle=" + productTitle + ", chatDate=" + chatDate + ", chatStatus=" + chatStatus + "]";
	}
}
