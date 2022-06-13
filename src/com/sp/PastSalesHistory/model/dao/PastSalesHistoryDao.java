package com.sp.PastSalesHistory.model.dao;

import static com.sp.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.sp.PastSalesHistory.model.vo.PastSalesHistoryList;
import com.sp.product.model.vo.PageInfo;

public class PastSalesHistoryDao {
	
private Properties prop = new Properties();
	
	public PastSalesHistoryDao() {
		String PastSalesHistoryDao = PastSalesHistoryDao.class.getResource("/db/pastSalesHistory/pastSalesHistory-mapper.xml").getPath();
	
		try {	
			prop.loadFromXML(new FileInputStream(PastSalesHistoryDao));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int selectListCount(Connection conn, int userNo) {
		//페이징기법 / 전체게시글 몇개인지 알고자 하는것 
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				rset=pstmt.executeQuery();
			
			if(rset.next()) {
				listCount=rset.getInt("COUNT"); //나올 행이 하나뿐이기 때문에 while문이 아닌 if문 사용 
			}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
		
		
		return listCount;
	}

	
	//조회된 결과 가져오기 
	//조회된 결과 가져오기 
		public ArrayList<PastSalesHistoryList> PastSaleList(Connection conn, PageInfo pi, int userNo) {
			
				ArrayList<PastSalesHistoryList> list = new ArrayList<>();
				
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("PastSalesHistoryList");
				try {
					pstmt = conn.prepareStatement(sql);
					//위치 홀더에 넣어줄 범위를 구해야함
					//boardLimit = 10; 10개씩
					//currentPage= 1 -> 시작값   1 끝 10
					//currentPage= 2 -> 시작값 11 끝 20
					//currentPage= 3 -> 시작값 21 끝 30
					
					//시작값 = (currentPage-1)*boardLimit+1
					// 끝값 = currentPage*boardLimit
					
					int startRow = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
//					int endRow = startRow*pi.getBoardLimit();
					int endRow = pi.getCurrentPage()*pi.getBoardLimit();
					
					pstmt.setInt(1, userNo);
					pstmt.setInt(2, userNo);
					
					pstmt.setInt(3, startRow);
					pstmt.setInt(4, endRow);
					
					rset=pstmt.executeQuery();
					
					//
					while(rset.next()) {
						list.add(new PastSalesHistoryList(rset.getInt("PRODUCT_NO")
								,rset.getString("PRODUCT_TITLE")
								,rset.getInt("PRODUCT_PRICE")
								,rset.getDate("PRODUCT_ENTERDATE")
//								,rset.getInt("CHAT_COUNT")
								,rset.getInt("PRODUCT_PICK")
								,rset.getInt("PRODUCT_VIEWS")
								,rset.getString("PRODUCT_SELL_STATUS")));
								
					}
					
				
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
				return list;
			}
	
	
	// 판매중 판매완료 리스트 가져오기  
		public ArrayList<PastSalesHistoryList> HistoryCountList(Connection conn, int userNo) {
			
				ArrayList<PastSalesHistoryList> PastlistCount = new ArrayList<>();
				
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("HistoryCountList");
				
				try {
					pstmt = conn.prepareStatement(sql);
					//위치 홀더에 넣어줄 범위를 구해야함
					//boardLimit = 10; 10개씩
					//currentPage= 1 -> 시작값   1 끝 10
					//currentPage= 2 -> 시작값 11 끝 20
					//currentPage= 3 -> 시작값 21 끝 30
					
					//시작값 = (currentPage-1)*boardLimit+1
					// 끝값 = currentPage*boardLimit
					
					
					pstmt.setInt(1, userNo);
					pstmt.setInt(2, userNo);
					
//					pstmt.setInt(3, startRow);
//					pstmt.setInt(4, endRow);
					
					rset=pstmt.executeQuery();
					
					//
					while(rset.next()) {
						PastlistCount.add(new PastSalesHistoryList(rset.getInt("PRODUCT_NO")
								,rset.getString("PRODUCT_TITLE")
								,rset.getInt("PRODUCT_PRICE")
								,rset.getDate("PRODUCT_ENTERDATE")
//								,rset.getInt("CHAT_COUNT")
								,rset.getInt("PRODUCT_PICK")
								,rset.getInt("PRODUCT_VIEWS")
								,rset.getString("PRODUCT_SELL_STATUS")));
								
					}
					
				
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				
				return PastlistCount;
					
			}
		
		
		
	}


