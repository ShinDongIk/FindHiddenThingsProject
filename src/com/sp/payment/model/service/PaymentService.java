package com.sp.payment.model.service;

import static com.sp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;


import com.sp.payment.model.dao.PaymentDao;
import com.sp.payment.model.vo.Payment;
import com.sp.product.model.vo.PageInfo;

public class PaymentService {

	public int insertPaymentList(Payment p) {
		Connection conn= connect();
		
		int result = new PaymentDao().insertPaymentList(conn,p);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public ArrayList<Payment> selectPaymentList(PageInfo pi,String searchTab,String input) {
		Connection conn= connect();
		
		ArrayList<Payment> list = new PaymentDao().selectPaymentList(conn,pi,searchTab,input);
		
		close(conn);
		
		return list;
		
		
	}

	public int selectListCount() {
		Connection conn= connect();
		
		int listCount = new PaymentDao().selectListCount(conn);
		
		close(conn);
				
		return listCount;
	}

	
		
	








}
