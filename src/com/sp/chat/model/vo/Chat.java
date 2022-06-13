package com.sp.chat.model.vo;

import java.sql.Date;

public class Chat {
	private int chatNo;
	private String firstUserName; //판매자
	private String secondUserName; //구매자
	private String productName;
	private String chatContent;
	private Date chatDate;
	private String chatStatus;
	
	public Chat() {
	
	}

	public Chat(int chatNo, String firstUserName, String secondUserName, String productName, String chatContent,
			Date chatDate) {
		super();
		this.chatNo = chatNo;
		this.firstUserName = firstUserName;
		this.secondUserName = secondUserName;
		this.productName = productName;
		this.chatContent = chatContent;
		this.chatDate = chatDate;
	}
	
	public Chat(int chatNo, String firstUserName, String secondUserName, String productName, Date chatDate) {
		super();
		this.chatNo = chatNo;
		this.firstUserName = firstUserName;
		this.secondUserName = secondUserName;
		this.productName = productName;
		this.chatDate = chatDate;
	}

	public Chat(int chatNo, String firstUserName, String secondUserName, String productName, Date chatDate,
			String chatStatus) {
		super();
		this.chatNo = chatNo;
		this.firstUserName = firstUserName;
		this.secondUserName = secondUserName;
		this.productName = productName;
		this.chatDate = chatDate;
		this.chatStatus = chatStatus;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getFirstUserName() {
		return firstUserName;
	}

	public void setFirstUserName(String firstUserName) {
		this.firstUserName = firstUserName;
	}

	public String getSecondUserName() {
		return secondUserName;
	}

	public void setSecondUserName(String secondUserName) {
		this.secondUserName = secondUserName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
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

	public Chat(int chatNo, String firstUserName, String secondUserName, String productName, String chatContent,
			Date chatDate, String chatStatus) {
		super();
		this.chatNo = chatNo;
		this.firstUserName = firstUserName;
		this.secondUserName = secondUserName;
		this.productName = productName;
		this.chatContent = chatContent;
		this.chatDate = chatDate;
		this.chatStatus = chatStatus;
	}
}
