package com.sp.product.model.vo;

public class PickList {
	private int userNo;
	private int productNo;
	
	public PickList() {
		super();
	}

	public PickList(int userNo, int productNo) {
		super();
		this.userNo = userNo;
		this.productNo = productNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	@Override
	public String toString() {
		return "PickList [userNo=" + userNo + ", productNo=" + productNo + "]";
	}
	
}
