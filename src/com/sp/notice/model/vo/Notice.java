package com.sp.notice.model.vo;

import java.util.Date;

public class Notice {

	private int noticeNo;			
	private String noticeTitle;
	private String noticeContent;
	private String userNo; 
	private Date noticeEnter;
	private int noticeView;			
	private String status;
	public Notice() {
		super();
	
	}
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String userNo, Date noticeEnter,
			int noticeView, String status) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userNo = userNo;
		this.noticeEnter = noticeEnter;
		this.noticeView = noticeView;
		this.status = status;
	}
	
	
	
	public Notice(int noticeNo, String noticeTitle, String userNo, Date noticeEnter, int noticeView) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.userNo = userNo;
		this.noticeEnter = noticeEnter;
		this.noticeView = noticeView;
	}
	
	public Notice(String noticeTitle, String noticeContent, String userNo) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userNo = userNo;
	}
	
	
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String userNo, Date noticeEnter) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userNo = userNo;
		this.noticeEnter = noticeEnter;
	}
	
	public Notice(int noticeNo, String noticeTitle, String noticeContent, String userNo, int noticeView, Date noticeEnter) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userNo = userNo;
		this.noticeView = noticeView;
		this.noticeEnter = noticeEnter;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Date getNoticeEnter() {
		return noticeEnter;
	}
	public void setNoticeEnter(Date noticeEnter) {
		this.noticeEnter = noticeEnter;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", userNo=" + userNo + ", noticeEnter=" + noticeEnter + ", noticeView=" + noticeView + ", status="
				+ status + "]";
	}
	

	
	
	
	
	
	
}
