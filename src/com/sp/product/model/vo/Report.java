package com.sp.product.model.vo;

import java.sql.Date;

public class Report {
	
	private int reportNo;
	private int reporterUserNo;
	private int respondentUserNo;
	private String reportTab;
	private String reportContent;
	private Date reportDate;
	private String reporterId;
	private String reportedId;
	
	public Report() {
		super();
	}
	
	
	

	public Report(int reportNo, int reporterUserNo, int respondentUserNo, String reportTab, String reportContent,
			Date reportDate) {
		super();
		this.reportNo = reportNo;
		this.reporterUserNo = reporterUserNo;
		this.respondentUserNo = respondentUserNo;
		this.reportTab = reportTab;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
	}




	public Report(int reportNo,String reporterId,String reportedId, String reportTab, String reportContent, Date reportDate 
			) {
		super();
		this.reportNo = reportNo;
		this.reportTab = reportTab;
		this.reportContent = reportContent;
		this.reportDate = reportDate;
		this.reporterId = reporterId;
		this.reportedId = reportedId;
	}




	public int getRespondentUserNo() {
		return respondentUserNo;
	}
	public void setRespondentUserNo(int respondentUserNo) {
		this.respondentUserNo = respondentUserNo;
	}
	public int getReporterUserNo() {
		return reporterUserNo;
	}
	public void setReporterUserNo(int reporterUserNo) {
		this.reporterUserNo = reporterUserNo;
	}
	public String getReportTab() {
		return reportTab;
	}
	public void setReportTab(String reportTab) {
		this.reportTab = reportTab;
	}
	public String getReportContent() {
		return reportContent;
	}
	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}
	
	
	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}




	public String getReporterId() {
		return reporterId;
	}




	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}




	public String getReportedId() {
		return reportedId;
	}




	public void setReportedId(String reportedId) {
		this.reportedId = reportedId;
	}




	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reporterUserNo=" + reporterUserNo + ", respondentUserNo="
				+ respondentUserNo + ", reportTab=" + reportTab + ", reportContent=" + reportContent + ", reportDate="
				+ reportDate + "]";
	}

	

	
	
	
}
