package com.sp.PastSalesHistory.model.service;
import static com.sp.common.JDBCTemplate.close;
import static com.sp.common.JDBCTemplate.connect;

import java.sql.Connection;
import java.util.ArrayList;


import com.sp.PastSalesHistory.model.dao.PastSalesHistoryDao;
import com.sp.PastSalesHistory.model.vo.PastSalesHistoryList;
import com.sp.product.model.vo.PageInfo;

public class PastSalesHistoryService {

	
	//페이징 컨트롤러 
	public int selectListCount(int userNo) {
		Connection conn = connect();
		
		int listCount = new PastSalesHistoryDao().selectListCount(conn,userNo);
		
		close(conn);
		
		return listCount;
	}


	public ArrayList<PastSalesHistoryList> PastSaleList(PageInfo pi, int userNo) {
		Connection conn = connect();
		
//		new PastSalesHistoryDao().PastSaleList(conn,pi,userNo);
	
		
		ArrayList<PastSalesHistoryList> list = new PastSalesHistoryDao().PastSaleList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}
	
	
	public ArrayList<PastSalesHistoryList> HistoryCount(int userNo) {
		Connection conn = connect();
	
		ArrayList<PastSalesHistoryList> PastlistCount = new PastSalesHistoryDao().HistoryCountList(conn, userNo);
		
		close(conn);
		
		return PastlistCount;
	}

}
