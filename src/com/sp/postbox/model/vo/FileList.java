package com.sp.postbox.model.vo;

import java.sql.Date;

public class FileList {
	private int fileNo;	//	FILE_NO	NUMBER
	private int productNo;	//	PRODUCT_NO	NUMBER
	private String fileOriginName;	//	FILE_ORIGIN_NAME	VARCHAR2(100 BYTE)
	private String fileChangeName;	//	FILE_CHANGE_NAME	VARCHAR2(100 BYTE)
	private String filePath;	//	FILE_PATH	VARCHAR2(100 BYTE)
	private int fileLevel;	//	FILE_LEVEL	NUMBER
	private Date uploadDate;	//	UPLOAD_DATE	DATE
	private char fileStatus;	//	FILE_STATUS	VARCHAR2(1 BYTE)
	private String titleImg;
	public FileList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileList(int fileNo, int productNo, String fileOriginName, String fileChangeName, String filePath,
			int fileLevel, Date uploadDate, char fileStatus, String titleImg) {
		super();
		this.fileNo = fileNo;
		this.productNo = productNo;
		this.fileOriginName = fileOriginName;
		this.fileChangeName = fileChangeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.uploadDate = uploadDate;
		this.fileStatus = fileStatus;
		this.titleImg = titleImg;
	}
	
	public FileList(int productNo, String titleImg) {
		super();
		this.productNo = productNo;
		this.titleImg = titleImg;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getFileOriginName() {
		return fileOriginName;
	}
	public void setFileOriginName(String fileOriginName) {
		this.fileOriginName = fileOriginName;
	}
	public String getFileChangeName() {
		return fileChangeName;
	}
	public void setFileChangeName(String fileChangeName) {
		this.fileChangeName = fileChangeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public char getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(char fileStatus) {
		this.fileStatus = fileStatus;
	}
	public String getTitleImg() {
		return titleImg;
	}
	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	@Override
	public String toString() {
		return "FileList [fileNo=" + fileNo + ", productNo=" + productNo + ", fileOriginName=" + fileOriginName
				+ ", fileChangeName=" + fileChangeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel
				+ ", uploadDate=" + uploadDate + ", fileStatus=" + fileStatus + ", titleImg=" + titleImg + "]";
	}
	
	
	
	
}
