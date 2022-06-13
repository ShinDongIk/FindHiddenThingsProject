package com.sp.notice.model.vo;

import java.sql.Date;

public class Questions {
	private int questionNo;	//	QUESTION_NO	NUMBER
	private int questionReplyNo;	//	QUESTION_NO	NUMBER
	private String questionTitle;	//	QUESTION_TITLE	VARCHAR2(100 BYTE)
	private String questionContent;	//	QUESTION_CONTENT	VARCHAR2(4000 BYTE)
	private int userNo;	//	USER_NO	NUMBER
	private String userName;
	private Date questionEnter;	//	QUESTION_ENTER	DATE
	private int questionView;	//	QUESTION_VIEW	NUMBER
	private String questionStatus;	//	QUESTION_STATUS	VARCHAR2(1 BYTE)
	
	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Questions(int questionNo, String questionTitle, String questionContent, int userNo, String userName,
			Date questionEnter, int questionView, String questionStatus) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.userNo = userNo;
		this.userName = userName;
		this.questionEnter = questionEnter;
		this.questionView = questionView;
		this.questionStatus = questionStatus;
	}

	public Questions(int questionNo, String questionTitle, String questionContent, int userNo, Date questionEnter,
			int questionView, String questionStatus) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.userNo = userNo;
		this.questionEnter = questionEnter;
		this.questionView = questionView;
		this.questionStatus = questionStatus;
	}
	
	public Questions(int questionNo, String questionTitle, String questionContent, String userName,
			Date questionEnter) {
		super();
		this.questionNo = questionNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.userName = userName;
		this.questionEnter = questionEnter;
	}
	
	
	
	public Questions(int questionNo, String questionTitle,  int questionReplyNo, String questionContent, String userName,
			Date questionEnter) {
		super();
		this.questionNo = questionNo;
		this.questionReplyNo = questionReplyNo;
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.userName = userName;
		this.questionEnter = questionEnter;
	}

	public Questions(String questionTitle, String questionContent, int userNo) {
		super();
		this.questionTitle = questionTitle;
		this.questionContent = questionContent;
		this.userNo = userNo;
	}

	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Date getQuestionEnter() {
		return questionEnter;
	}
	public void setQuestionEnter(Date questionEnter) {
		this.questionEnter = questionEnter;
	}
	public int getQuestionView() {
		return questionView;
	}
	public void setQuestionView(int questionView) {
		this.questionView = questionView;
	}
	public String getQuestionStatus() {
		return questionStatus;
	}
	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public int getQuestionReplyNo() {
		return questionReplyNo;
	}

	public void setQuestionReplyNo(int questionReplyNo) {
		this.questionReplyNo = questionReplyNo;
	}

	@Override
	public String toString() {
		return "Questions [questionNo=" + questionNo + ", questionReplyNo=" + questionReplyNo + ", questionTitle="
				+ questionTitle + ", questionContent=" + questionContent + ", userNo=" + userNo + ", userName="
				+ userName + ", questionEnter=" + questionEnter + ", questionView=" + questionView + ", questionStatus="
				+ questionStatus + "]";
	}



}
