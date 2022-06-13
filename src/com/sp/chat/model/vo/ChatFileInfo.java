package com.sp.chat.model.vo;

import java.sql.Date;

public class ChatFileInfo {
	private int fileNo;
	private int chatNo;
	private String fileName;
	private String path;
	private Date uploadeDate;
	private String fileStatus;
	
	public ChatFileInfo() {
		super();
	}

	public ChatFileInfo(int fileNo, int chatNo, String fileName, String path, Date uploadeDate, String fileStatus) {
		super();
		this.fileNo = fileNo;
		this.chatNo = chatNo;
		this.fileName = fileName;
		this.path = path;
		this.uploadeDate = uploadeDate;
		this.fileStatus = fileStatus;
	}

	public ChatFileInfo(int chatNo, String fileName, String path) {
		super();
		this.chatNo = chatNo;
		this.fileName = fileName;
		this.path = path;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getUploadeDate() {
		return uploadeDate;
	}

	public void setUploadeDate(Date uploadeDate) {
		this.uploadeDate = uploadeDate;
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus;
	}

	@Override
	public String toString() {
		return "ChatFileInfo [fileNo=" + fileNo + ", chatNo=" + chatNo + ", fileName=" + fileName + ", path=" + path
				+ ", uploadeDate=" + uploadeDate + ", fileStatus=" + fileStatus + "]";
	}
	
}
