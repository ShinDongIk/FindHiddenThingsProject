package com.sp.postbox.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sp.common.JDBCTemplate;
import com.sp.postbox.model.dao.PostboxDao;
import com.sp.postbox.model.vo.Company;
import com.sp.postbox.model.vo.ProductList;
import com.sp.postbox.model.vo.Tracking;
import com.sp.postbox.model.vo.TrackingList;
import com.sp.product.model.vo.PageInfo;

public class PostboxService {
	
	public int selectListCount() {
		Connection conn = JDBCTemplate.connect();
		
		int listCount = new PostboxDao().selectListCount(conn);
		
		JDBCTemplate.close(conn);
		return listCount;
	}

	public ArrayList<Company> selectCompany() {
		Connection conn = JDBCTemplate.connect();
		
		ArrayList<Company> company = new PostboxDao().selectCompany(conn);
		JDBCTemplate.close(conn);
		return company;
	}

	public ArrayList<ProductList> selectViewList(PageInfo pi) {
		Connection conn = JDBCTemplate.connect();
		
		ArrayList<ProductList> list = new PostboxDao().selectViewList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<ProductList> selectImageList(int[] pno) {
		Connection conn = JDBCTemplate.connect();
		ArrayList<ProductList> imageList = new PostboxDao().selectImageList(conn,pno);
		
		JDBCTemplate.close(conn);
		return imageList;
	}

	public ProductList selectRegisterProduct(int mapValue) {
		Connection conn = JDBCTemplate.connect();
		ProductList product = new PostboxDao().selectRegisterProduct(conn,mapValue);
		JDBCTemplate.close(conn);
		return product;
	}

	public int InsertTracking(Tracking tk) {
		Connection conn = JDBCTemplate.connect();
		int insertNumber = new PostboxDao().InsertTracking(conn, tk);
		
		if(insertNumber>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return insertNumber;
	}

	public Tracking selectProductNo(String productName) {
		Connection conn = JDBCTemplate.connect();
		Tracking productNo = new PostboxDao().selectProductNo(conn, productName);
		JDBCTemplate.close(conn);
		return productNo;
	}

	public int selectTrackingListCount() {
		Connection conn = JDBCTemplate.connect();
		
		int trackingListCount = new PostboxDao().selectTrackingListCount(conn);
		
		JDBCTemplate.close(conn);
		return trackingListCount;
	}

	public ArrayList<ProductList> selectTrackingViewList(PageInfo pi) {
		Connection conn = JDBCTemplate.connect();
		
		ArrayList<ProductList> list = new PostboxDao().selectTrackingViewList(conn, pi);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<TrackingList> selectTrackingImageList(int[] pno) {
		Connection conn = JDBCTemplate.connect();
		ArrayList<TrackingList> imageList = new PostboxDao().selectTrackingImageList(conn,pno);
		
		JDBCTemplate.close(conn);
		return imageList;
	}

	public Company selectTrackingCompany(Long mapValue) {
		Connection conn = JDBCTemplate.connect();
		Company companyInfo = new PostboxDao().selectTrackingCompany(conn, mapValue);
		JDBCTemplate.close(conn);
		return companyInfo;
	}

	public ArrayList<ProductList> selectBuyerNo(int[] pno) {
		Connection conn = JDBCTemplate.connect();
		ArrayList<ProductList> buyerNo = new PostboxDao().selectBuyerNo(conn, pno);
		JDBCTemplate.close(conn);
		return buyerNo;
	}

	public ArrayList<ProductList> buyerTrackingViewList(PageInfo pi, int userNo) {
		Connection conn = JDBCTemplate.connect();
		ArrayList<ProductList> list2 = new PostboxDao().buyerTrackingViewList(conn, pi, userNo);
		JDBCTemplate.close(conn);
		return list2;
	}

	public int InsertPurchase(Tracking tk) {
		Connection conn = JDBCTemplate.connect();
		int InsertPurchase = new PostboxDao().InsertPurchase(conn, tk);
		
		if(InsertPurchase>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return InsertPurchase;
	}



}
