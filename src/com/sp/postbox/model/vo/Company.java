package com.sp.postbox.model.vo;

import java.sql.Date;

public class Company {
	private int companyKey;	// 	POSTBOX_COMPANY_KEY	NUMBER
	private int companyCode;	//	POSTBOX_COMPANY_CODE	NUMBER
	private String companyName;	//	POSTBOX_COMPANY_NAME	VARCHAR2(100 BYTE)
	private String companyCountry;	//	POSTBOX_COMPANY_COUNTRY	VARCHAR2(100 BYTE)
	private Long companyNumber;
	private static String ApiKey = "EKL2nAiQVFQ2A7JPt4ZJMQ";
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Company(int companyKey, int companyCode, String companyName, String companyCountry) {
		super();
		this.companyKey = companyKey;
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCountry = companyCountry;
	}
	public Company(int companyKey, int companyCode, String companyName) {
		super();
		this.companyKey = companyKey;
		this.companyCode = companyCode;
		this.companyName = companyName;
	}
	public int getCompanyKey() {
		return companyKey;
	}
	public void setCompanyKey(int companyKey) {
		this.companyKey = companyKey;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCountry() {
		return companyCountry;
	}
	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}
	public Long getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(Long companyNumber) {
		this.companyNumber = companyNumber;
	}
	public static String getApiKey() {
		return ApiKey;
	}
	@Override
	public String toString() {
		return "Company [companyKey=" + companyKey + ", companyCode=" + companyCode + ", companyName=" + companyName
				+ ", companyCountry=" + companyCountry + ", companyNumber=" + companyNumber + ", ApiKey=" + ApiKey +  "]";
	}


}
