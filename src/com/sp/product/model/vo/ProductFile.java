package com.sp.product.model.vo;

import java.sql.Date;

public class ProductFile {
	private int fileNo;
	private int productNo;
	private String fileOriginName;
	private String fileChangeName;
	private String filePath;
	private int fileLevel;
	private Date uploadDate;
	private String fileStatus;
	public ProductFile() {
		super();
	}
	public ProductFile(int fileNo, int productNo, String fileOriginName, String fileChangeName, String filePath,
			int fileLevel, Date uploadDate, String fileStatus) {
		super();
		this.fileNo = fileNo;
		this.productNo = productNo;
		this.fileOriginName = fileOriginName;
		this.fileChangeName = fileChangeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.uploadDate = uploadDate;
		this.fileStatus = fileStatus;
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
	public String getFileStatus() {
		return fileStatus;
	}
	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}
	@Override
	public String toString() {
		return "productFile [fileNo=" + fileNo + ", productNo=" + productNo + ", fileOriginName=" + fileOriginName
				+ ", fileChangeName=" + fileChangeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel
				+ ", uploadDate=" + uploadDate + ", fileStatus=" + fileStatus + "]";
	}
	
	
}
