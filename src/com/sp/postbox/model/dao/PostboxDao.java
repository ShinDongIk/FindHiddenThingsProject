package com.sp.postbox.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.sp.common.JDBCTemplate;
import com.sp.postbox.model.vo.Company;
import com.sp.postbox.model.vo.ProductList;
import com.sp.postbox.model.vo.Tracking;
import com.sp.postbox.model.vo.TrackingList;
import com.sp.product.model.vo.PageInfo;

public class PostboxDao {
	
	private Properties prop = new Properties();
	
	public PostboxDao() {
		String fileName = PostboxDao.class.getResource("/db/postbox/postbox-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public int selectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Company> selectCompany(Connection conn) {
		
		ArrayList<Company> company = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next())  {
				company.add(new Company(rset.getInt("POSTBOX_COMPANY_KEY"),
									 rset.getInt("POSTBOX_COMPANY_CODE"),
									 rset.getString("POSTBOX_COMPANY_NAME")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return company;
	}

	public ArrayList<ProductList> selectViewList(Connection conn, PageInfo pi) {
		ArrayList<ProductList> list = new ArrayList<>();
		ResultSet rset1 = null;
		ResultSet rset2 = null;
		PreparedStatement pstmt = null;
		int[] productNo = null;
		int i = 0;
		boolean isTrue = false;
		
//		String sql1 = prop.getProperty("isTherePostNum");
		
		String sql2 = prop.getProperty("selectViewList");
		
		try {
//			pstmt = conn.prepareStatement(sql1); // 등록여부 조회
//			rset1 = pstmt.executeQuery();
			
//			while(rset1.next()) {
//				productNo[i] = rset1.getInt("PRODUCT_NO");
//				i++;
//			} 
			
			pstmt = conn.prepareStatement(sql2); // 등록해야할 게시물 조회
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			pstmt.setInt(1, pi.getUserNo());
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rset2 = pstmt.executeQuery();
			
			while(rset2.next()) {
//				for(int j=0; j<productNo.length; j++) {
//					if(rset2.getInt("PRODUCT_NO")!=productNo[i]) {
//						isTrue = true; 
//					}else {
//						isTrue = false; 
//					}
//				}
//				if(isTrue) {
					list.add(new ProductList(rset2.getInt("PRODUCT_NO"),
						     rset2.getString("PRODUCT_TITLE"),
						     rset2.getString("PRODUCT_CONTENT"),
						     rset2.getInt("PRODUCT_PRICE"),
						 	 rset2.getDate("PRODUCT_ENTERDATE"),
						 	 rset2.getString("USER_NAME"),
						 	 rset2.getInt("PRODUCT_PICK"),
						 	 rset2.getInt("PRODUCT_VIEWS"),
						 	 rset2.getString("TITLEIMG")));
//				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset2);
			JDBCTemplate.close(rset1);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}


	public ArrayList<ProductList> selectImageList(Connection conn, int[] pno) {
		ArrayList<ProductList> imageList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectImageList");
		
		try {
			for(int i=0; i<pno.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno[i]);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					imageList.add(new ProductList(rset.getInt("PRODUCT_NO"),
											   rset.getString("TITLEIMG")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return imageList;
	}

	public ProductList selectRegisterProduct(Connection conn, int mapValue) {
		ProductList product = new ProductList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRegisterProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mapValue);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				product = (new ProductList(rset.getInt("PRODUCT_NO"),
					     				   rset.getString("PRODUCT_TITLE"),
					     				   rset.getString("PRODUCT_CONTENT"),
					     				   rset.getInt("PRODUCT_PRICE"),
					     				   rset.getDate("PRODUCT_ENTERDATE"),
					     				   rset.getInt("USER_NO"),
					     				   rset.getString("USER_NAME"),
					     				   rset.getInt("PRODUCT_PICK"),
					     				   rset.getInt("PRODUCT_VIEWS"),
					     				   rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset); 
			JDBCTemplate.close(pstmt); 
		}
		return product;
	}

	public int InsertTracking(Connection conn, Tracking tk) {
		int insertTracking = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertTracking");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, tk.getTrackingNumber());
			pstmt.setInt(2, tk.getProductNo());
			pstmt.setInt(3, tk.getBuyerNo());
			pstmt.setString(4, tk.getPostboxCompany());
			
			insertTracking = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return insertTracking;
	}

	public Tracking selectProductNo(Connection conn, String productName) {
		Tracking productNo = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				productNo = new Tracking(rset.getInt("PRODUCT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return productNo;
	}

	public int selectTrackingListCount(Connection conn) {
		int trackingListCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTrackingListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				trackingListCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return trackingListCount;
	}

	public ArrayList<ProductList> selectTrackingViewList(Connection conn, PageInfo pi) {
		ArrayList<ProductList> list = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTrackingViewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
			int endRow = pi.getCurrentPage() * pi.getBoardLimit();
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProductList pl = new ProductList();
				
				pl.setProductNo(rset.getInt("PRODUCT_NO"));
				pl.setProductTitle(rset.getString("PRODUCT_TITLE"));
				pl.setProductContent(rset.getString("PRODUCT_CONTENT"));
				pl.setProductPrice(rset.getInt("PRODUCT_PRICE"));
				pl.setProductDate(rset.getDate("PRODUCT_ENTERDATE"));
				pl.setUserName(rset.getString("USER_NAME"));
				pl.setPostboxNumber(rset.getLong("POSTBOX_NUMBER"));
				pl.setPostboxCompanyName(rset.getString("POSTBOX_COMPANY_NAME"));
				pl.setTitleImg(rset.getString("TITLEIMG"));
				
				list.add(pl);
				
//				list.add(new ProductList(rset.getInt("PRODUCT_NO"),
//									     rset.getString("PRODUCT_TITLE"),
//									     rset.getString("PRODUCT_CONTENT"),
//									     rset.getInt("PRODUCT_PRICE"),
//									 	 rset.getDate("PRODUCT_ENTERDATE"),
//									 	 rset.getString("USER_NAME"),
//									 	 rset.getInt("POSTBOX_NUMBER"),
//									 	 rset.getInt("POSTBOX_COMPANY_NAME"),
//									 	 rset.getString("TITLEIMG")));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<TrackingList> selectTrackingImageList(Connection conn, int[] pno) {
		ArrayList<TrackingList> imageList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTrackingImageList");
		
		try {
			for(int i=0; i<pno.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno[i]);
				rset = pstmt.executeQuery();
				if(rset.next()) {
					imageList.add(new TrackingList(rset.getInt("PRODUCT_NO"),
											   rset.getString("TITLEIMG")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return imageList;
	}

	public Company selectTrackingCompany(Connection conn, Long mapValue) {
		Company companyInfo = new Company();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTrackingCompany");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, mapValue);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				companyInfo.setCompanyCode(rset.getInt("POSTBOX_COMPANY_CODE"));
				companyInfo.setCompanyName(rset.getString("POSTBOX_COMPANY_NAME"));
				companyInfo.setCompanyNumber(rset.getLong("POSTBOX_NUMBER"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return companyInfo;
	}

	public ArrayList<ProductList> selectBuyerNo(Connection conn, int[] pno) {
		ArrayList<ProductList> buyerNo = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBuyerNo");
		
		try {
			for(int i=0; i<pno.length; i++) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno[i]);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					buyerNo.add(new ProductList(rset.getInt("PRODUCT_NO"),
												rset.getInt("USER_NO")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return buyerNo;
	}

	public ArrayList<ProductList> buyerTrackingViewList(Connection conn, PageInfo pi, int userNo) {
		ArrayList<ProductList> list2 = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("buyerTrackingViewList");
		
		try {
				pstmt = conn.prepareStatement(sql);
				int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() + 1;
				int endRow = pi.getCurrentPage() * pi.getBoardLimit();
				pstmt.setInt(1, userNo);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					ProductList pl = new ProductList();
					
					pl.setProductNo(rset.getInt("PRODUCT_NO"));
					pl.setProductTitle(rset.getString("PRODUCT_TITLE"));
					pl.setProductContent(rset.getString("PRODUCT_CONTENT"));
					pl.setProductPrice(rset.getInt("PRODUCT_PRICE"));
					pl.setProductDate(rset.getDate("PRODUCT_ENTERDATE"));
					pl.setUserName(rset.getString("USER_NAME"));
					pl.setPostboxNumber(rset.getLong("POSTBOX_NUMBER"));
					pl.setPostboxCompanyName(rset.getString("POSTBOX_COMPANY_NAME"));
					pl.setTitleImg(rset.getString("TITLEIMG"));
					
					list2.add(pl);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list2;
	}

	public int InsertPurchase(Connection conn, Tracking tk) {
		int InsertPurchase = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertPurchase");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tk.getProductNo());
			pstmt.setInt(2, tk.getBuyerNo());
			
			InsertPurchase = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return InsertPurchase;
	}


}
