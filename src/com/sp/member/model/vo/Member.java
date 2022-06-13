package com.sp.member.model.vo;

import java.sql.Date;

public class Member {
	private int userNo;	
	private String userName;
	private String userId;
	private String userPwd;
	private String userNickName;
	private String userEmail;
	private String userPhone;
	private Date userEnterDate;
	private int userReport;
	private int userLike;
	private String userStatus;
	
	public Member() {
		
	}

	public Member(int userNo, String userName, String userId, String userPwd, String userNickName, String userEmail,
			String userPhone, Date userEnterDate, int userReport, int userLike, String userStatus) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickName = userNickName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userEnterDate = userEnterDate;
		this.userReport = userReport;
		this.userLike = userLike;
		this.userStatus = userStatus;
	}
	
	public Member(String userName, String userId, String userPwd, String userNickName, String userEmail,
			String userPhone) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNickName = userNickName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getUserEnterDate() {
		return userEnterDate;
	}

	public void setUserEnterDate(Date userEnterDate) {
		this.userEnterDate = userEnterDate;
	}

	public int getUserReport() {
		return userReport;
	}

	public void setUserReport(int userReport) {
		this.userReport = userReport;
	}

	public int getUserLike() {
		return userLike;
	}

	public void setUserLike(int userLike) {
		this.userLike = userLike;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd
				+ ", userNickName=" + userNickName + ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", userEnterDate=" + userEnterDate + ", userReport=" + userReport + ", userLike=" + userLike
				+ ", userStatus=" + userStatus + "]";
	}

	
}
