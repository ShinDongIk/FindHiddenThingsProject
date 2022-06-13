package com.sp.notice.model.vo;

import java.sql.Date;

public class Faq {
	private int faqNo;	//	FAQ_NO	NUMBER
	private String faqTitle;	//	FAQ_TITLE	VARCHAR2(100 BYTE)
	private String faqContent;	//	FAQ_CONTENT	VARCHAR2(4000 BYTE)
	private int userNo;	//	USER_NO	NUMBER
	private String userName;
	private Date faqEnter;	//	FAQ_ENTER	DATE
	private int faqView;	//	FAQ_VIEW	NUMBER
	private String faqStatus;	//	FAQ_STATUS	VARCHAR2(1 BYTE)
	public Faq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Faq(int faqNo, String faqTitle, String faqContent, int userNo, String userName, Date faqEnter, int faqView,
			String faqStatus) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.userNo = userNo;
		this.userName = userName;
		this.faqEnter = faqEnter;
		this.faqView = faqView;
		this.faqStatus = faqStatus;
	}
	
	public Faq(int faqNo, String faqTitle, String faqContent, String userName, Date faqEnter) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.userName = userName;
		this.faqEnter = faqEnter;
	}
	
	
	public Faq(int faqNo, String faqTitle, String faqContent, int userNo, Date faqEnter) {
		super();
		this.faqNo = faqNo;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.userNo = userNo;
		this.faqEnter = faqEnter;
	}
	public Faq(String faqTitle, String faqContent, int userNo) {
		super();
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.userNo = userNo;
	}
	
	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
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
	public Date getFaqEnter() {
		return faqEnter;
	}
	public void setFaqEnter(Date faqEnter) {
		this.faqEnter = faqEnter;
	}
	public int getFaqView() {
		return faqView;
	}
	public void setFaqView(int faqView) {
		this.faqView = faqView;
	}
	public String getFaqStatus() {
		return faqStatus;
	}
	public void setFaqStatus(String faqStatus) {
		this.faqStatus = faqStatus;
	}
	@Override
	public String toString() {
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", userNo=" + userNo
				+ ", userName=" + userName + ", faqEnter=" + faqEnter + ", faqView=" + faqView + ", faqStatus="
				+ faqStatus + "]";
	}
	
}
