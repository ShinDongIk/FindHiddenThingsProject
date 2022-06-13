package com.sp.payment.model.dao;

import static com.sp.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.sp.payment.model.vo.Payment;
import com.sp.product.model.vo.PageInfo;

public class PaymentDao {

	private Properties prop = new Properties();
	
	public PaymentDao() {
		String fileName = PaymentDao.class.getResource("/db/payment/payment-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertPaymentList(Connection conn, Payment p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertPaymentList");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, p.getImpUid());
			pstmt.setInt(2, p.getProductNo());
			pstmt.setInt(3, p.getBuyerNo());
			pstmt.setString(4, p.getApplyNo());
			pstmt.setString(5, p.getMerchantUid());
			
			
			result = pstmt.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	public ArrayList<Payment> selectPaymentList(Connection conn,PageInfo pi,String searchTab,String input) {
		ArrayList<Payment> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = "";
		try {
			if(searchTab==null) {
			sql = "SELECT*\r\n" + 
					"		FROM(\r\n" + 
					"		     SELECT ROWNUM RNUM,A.*\r\n" + 
					"		     FROM\r\n" + 
					"		     (\r\n" + 
					"		SELECT PRODUCT_NO,PRODUCT_TITLE,USER_NAME,BUYER_NO,IMP_UID,MERCHANT_UID,PAY_DATE,APPLY_NO,PRODUCT_PRICE\r\n" + 
					"				FROM PAYMENT_LIST\r\n" + 
					"				LEFT JOIN PRODUCT_LIST USING(PRODUCT_NO)\r\n" + 
					"				JOIN MEMBER_LIST M ON(BUYER_NO = M.USER_NO)	\r\n" + 
					"		        ORDER BY PAY_DATE DESC\r\n" + 
					"		        ) A\r\n" + 
					"		     )\r\n" + 
					"		    WHERE RNUM BETWEEN ? AND ?";
			pstmt=conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
			int endRow = pi.getCurrentPage()*pi.getBoardLimit();
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset=pstmt.executeQuery();
		

			while(rset.next()) {
				list.add(new Payment(rset.getInt("PRODUCT_NO")
						            ,rset.getString("PRODUCT_TITLE")
						            ,rset.getString("USER_NAME")
						            ,rset.getInt("BUYER_NO")
						            ,rset.getString("IMP_UID")
						            ,rset.getString("MERCHANT_UID")
						            ,rset.getDate("PAY_DATE")
						            ,rset.getString("APPLY_NO")
						            ,rset.getInt("PRODUCT_PRICE")));
			}
		
			
			}else if(searchTab.equals("product_no")){
				sql = "SELECT*\r\n" + 
						"		FROM(\r\n" + 
						"		     SELECT ROWNUM RNUM,A.*\r\n" + 
						"		     FROM\r\n" + 
						"		     (\r\n" + 
						"		SELECT PRODUCT_NO,PRODUCT_TITLE,USER_NAME,BUYER_NO,IMP_UID,MERCHANT_UID,PAY_DATE,APPLY_NO,PRODUCT_PRICE\r\n" + 
						"				FROM PAYMENT_LIST\r\n" + 
						"				LEFT JOIN PRODUCT_LIST USING(PRODUCT_NO)\r\n" + 
						"				JOIN MEMBER_LIST M ON(BUYER_NO = M.USER_NO)	\r\n" + 
						"               WHERE PRODUCT_NO = ? \r\n"+
						"		        ORDER BY PAY_DATE DESC\r\n" + 
						"		        ) A\r\n" + 
						"		     )\r\n" + 
						"		    WHERE RNUM BETWEEN ? AND ?";
				pstmt=conn.prepareStatement(sql);
				int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
				int endRow = pi.getCurrentPage()*pi.getBoardLimit();
				
				pstmt.setString(1, input);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset=pstmt.executeQuery();
			

				while(rset.next()) {
					list.add(new Payment(rset.getInt("PRODUCT_NO")
							            ,rset.getString("PRODUCT_TITLE")
							            ,rset.getString("USER_NAME")
							            ,rset.getInt("BUYER_NO")
							            ,rset.getString("IMP_UID")
							            ,rset.getString("MERCHANT_UID")
							            ,rset.getDate("PAY_DATE")
							            ,rset.getString("APPLY_NO")
							            ,rset.getInt("PRODUCT_PRICE")));
				}
			}else if(searchTab.equals("merchant_uid")) {
				sql = "SELECT*\r\n" + 
						"		FROM(\r\n" + 
						"		     SELECT ROWNUM RNUM,A.*\r\n" + 
						"		     FROM\r\n" + 
						"		     (\r\n" + 
						"		SELECT PRODUCT_NO,PRODUCT_TITLE,USER_NAME,BUYER_NO,IMP_UID,MERCHANT_UID,PAY_DATE,APPLY_NO,PRODUCT_PRICE\r\n" + 
						"				FROM PAYMENT_LIST\r\n" + 
						"				LEFT JOIN PRODUCT_LIST USING(PRODUCT_NO)\r\n" + 
						"				JOIN MEMBER_LIST M ON(BUYER_NO = M.USER_NO)	\r\n" + 
						"               WHERE MERCHANT_UID = ? \r\n"+
						"		        ORDER BY PAY_DATE DESC\r\n" + 
						"		        ) A\r\n" + 
						"		     )\r\n" + 
						"		    WHERE RNUM BETWEEN ? AND ?";
				pstmt=conn.prepareStatement(sql);
				int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
				int endRow = pi.getCurrentPage()*pi.getBoardLimit();
				
				pstmt.setString(1, input);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset=pstmt.executeQuery();
			

				while(rset.next()) {
					list.add(new Payment(rset.getInt("PRODUCT_NO")
							            ,rset.getString("PRODUCT_TITLE")
							            ,rset.getString("USER_NAME")
							            ,rset.getInt("BUYER_NO")
							            ,rset.getString("IMP_UID")
							            ,rset.getString("MERCHANT_UID")
							            ,rset.getDate("PAY_DATE")
							            ,rset.getString("APPLY_NO")
							            ,rset.getInt("PRODUCT_PRICE")));
				}
			}else if(searchTab.equals("imp_uid")) {
				sql = "SELECT*\r\n" + 
						"		FROM(\r\n" + 
						"		     SELECT ROWNUM RNUM,A.*\r\n" + 
						"		     FROM\r\n" + 
						"		     (\r\n" + 
						"		SELECT PRODUCT_NO,PRODUCT_TITLE,USER_NAME,BUYER_NO,IMP_UID,MERCHANT_UID,PAY_DATE,APPLY_NO,PRODUCT_PRICE\r\n" + 
						"				FROM PAYMENT_LIST\r\n" + 
						"				LEFT JOIN PRODUCT_LIST USING(PRODUCT_NO)\r\n" + 
						"				JOIN MEMBER_LIST M ON(BUYER_NO = M.USER_NO)	\r\n" + 
						"               WHERE IMP_UID = ? \r\n"+
						"		        ORDER BY PAY_DATE DESC\r\n" + 
						"		        ) A\r\n" + 
						"		     )\r\n" + 
						"		    WHERE RNUM BETWEEN ? AND ?";
				pstmt=conn.prepareStatement(sql);
				int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
				int endRow = pi.getCurrentPage()*pi.getBoardLimit();
				
				pstmt.setString(1, input);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				
				rset=pstmt.executeQuery();
			

				while(rset.next()) {
					list.add(new Payment(rset.getInt("PRODUCT_NO")
							            ,rset.getString("PRODUCT_TITLE")
							            ,rset.getString("USER_NAME")
							            ,rset.getInt("BUYER_NO")
							            ,rset.getString("IMP_UID")
							            ,rset.getString("MERCHANT_UID")
							            ,rset.getDate("PAY_DATE")
							            ,rset.getString("APPLY_NO")
							            ,rset.getInt("PRODUCT_PRICE")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}return list;
		
	}

	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt=conn.prepareStatement(sql);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}return listCount;
		
	}

	
		
	


	

	
	
	
	
	
	
	
}
