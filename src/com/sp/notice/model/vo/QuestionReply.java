package com.sp.notice.model.vo;

import java.sql.Date;

public class QuestionReply {
	private int questionReplyNo;	//	QUESTION_REPLY_NO	NUMBER
	private int questionNo;	//	QUESTION_NO	NUMBER
	private String questionReplyContent;	//	QUESTION_REPLY_CONTENT	VARCHAR2(4000 BYTE)
	private int userNo;	//	USER_NO	NUMBER
	private String userId;
	private Date questionReplyEnter;	//	QUESTION_REPLY_ENTER	DATE
	private String questionReplyStatus;	//	QUESTION_REPLY_STATUS	VARCHAR2(1 BYTE)
	public QuestionReply() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QuestionReply(int questionReplyNo, int questionNo, String questionReplyContent, int userNo, String userId,
			Date questionReplyEnter, String questionReplyStatus) {
		super();
		this.questionReplyNo = questionReplyNo;
		this.questionNo = questionNo;
		this.questionReplyContent = questionReplyContent;
		this.userNo = userNo;
		this.userId = userId;
		this.questionReplyEnter = questionReplyEnter;
		this.questionReplyStatus = questionReplyStatus;
	}

	public QuestionReply(int questionReplyNo, int questionNo, String questionReplyContent, int userNo,
			Date questionReplyEnter, String questionReplyStatus) {
		super();
		this.questionReplyNo = questionReplyNo;
		this.questionNo = questionNo;
		this.questionReplyContent = questionReplyContent;
		this.userNo = userNo;
		this.questionReplyEnter = questionReplyEnter;
		this.questionReplyStatus = questionReplyStatus;
	}
	
	public QuestionReply(int questionNo, int questionReplyNo, int userNo, String userId, String questionReplyContent, 
			Date questionReplyEnter, String questionReplyStatus) {
		super();
		this.questionReplyNo = questionReplyNo;
		this.questionNo = questionNo;
		this.questionReplyContent = questionReplyContent;
		this.userNo = userNo;
		this.userId = userId;
		this.questionReplyEnter = questionReplyEnter;
		this.questionReplyStatus = questionReplyStatus;
	}

	public QuestionReply(int questionReplyNo, int questionNo, String questionReplyContent, String userId,
			Date questionReplyEnter) {
		super();
		this.questionReplyNo = questionReplyNo;
		this.questionNo = questionNo;
		this.questionReplyContent = questionReplyContent;
		this.userId = userId;
		this.questionReplyEnter = questionReplyEnter;
	}

	public QuestionReply(String questionReplyContent, int questionNo, int userNo) {
		super();
		this.questionNo = questionNo;
		this.questionReplyContent = questionReplyContent;
		this.userNo = userNo;
	}
	
	public QuestionReply(int questionReplyNo) {
		super();
		this.questionReplyNo = questionReplyNo;
	}

	public int getQuestionReplyNo() {
		return questionReplyNo;
	}
	public void setQuestionReplyNo(int questionReplyNo) {
		this.questionReplyNo = questionReplyNo;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getQuestionReplyContent() {
		return questionReplyContent;
	}
	public void setQuestionReplyContent(String questionReplyContent) {
		this.questionReplyContent = questionReplyContent;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Date getQuestionReplyEnter() {
		return questionReplyEnter;
	}
	public void setQuestionReplyEnter(Date questionReplyEnter) {
		this.questionReplyEnter = questionReplyEnter;
	}
	public String getQuestionReplyStatus() {
		return questionReplyStatus;
	}
	public void setQuestionReplyStatus(String questionReplyStatus) {
		this.questionReplyStatus = questionReplyStatus;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "QuestionReply [questionReplyNo=" + questionReplyNo + ", questionNo=" + questionNo
				+ ", questionReplyContent=" + questionReplyContent + ", userNo=" + userNo + ", userId=" + userId
				+ ", questionReplyEnter=" + questionReplyEnter + ", questionReplyStatus=" + questionReplyStatus + "]";
	}


	


}
