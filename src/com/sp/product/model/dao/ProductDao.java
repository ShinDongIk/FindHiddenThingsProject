package com.sp.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import static com.sp.common.JDBCTemplate.*;

import com.sp.product.model.vo.PageInfo;
import com.sp.product.model.vo.PickList;
import com.sp.product.model.vo.Product;
import com.sp.product.model.vo.ProductDetail;
import com.sp.product.model.vo.ProductFile;
import com.sp.product.model.vo.Report;

public class ProductDao {

	private Properties prop = new Properties();
	
	public ProductDao() {
		String fileName = ProductDao.class.getResource("/db/product/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public ArrayList<Product> productSelectList(Connection conn, String category, PageInfo page) {
		ArrayList<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProductListPaging");

		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (page.getCurrentPage()-1)*page.getBoardLimit()+1;
			int end = page.getCurrentPage()*page.getBoardLimit();
			
			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				
				list.add(new Product(rset.getInt("PRODUCT_NO")
						,rset.getString("PRODUCT_TITLE")
						,rset.getInt("PRODUCT_PRICE")
						,rset.getInt("PRODUCT_PICK")
						,rset.getString("USER_NICKNAME")
						,rset.getString("PRODUCT_STATUS")
						,rset.getString("PRODUCT_SELL_STATUS")
						,rset.getString("PRODUCT_CATEGORY")
						,rset.getInt("PRODUCT_VIEWS")
						,rset.getString("PRODUCT_TRANSACTION")
						,rset.getString("PRODUCT_NEGO")
						,rset.getString("PRODUCT_CONTENT")
						,rset.getDate("PRODUCT_ENTERDATE")
						,rset.getString("FILE_CHANGE_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public PickList productPickSelect(Connection conn, int productNo, String nickName) {
		PickList pk = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPicklist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, nickName);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pk = new PickList(rset.getInt("USER_NO")
							,rset.getInt("PRODUCT_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return pk;
	}



	public int productPickInsert(Connection conn, int productNo, String nickName) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("insertPicklist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, nickName);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public int productPickDelete(Connection conn, PickList pk) {
		PreparedStatement pstmt = null;
		int result = 0;

		String sql = prop.getProperty("deletePicklist");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pk.getProductNo());
			pstmt.setInt(2, pk.getUserNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	public ArrayList<PickList> productPickLoad(Connection conn, int userNo) {
		ArrayList<PickList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loadPickList");
		
		try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				
				rset = pstmt.executeQuery();
				while(rset.next()) {
					list.add(new PickList(rset.getInt("USER_NO")
									,rset.getInt("PRODUCT_NO")));
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}



	public int productListCount(Connection conn, String category) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String sql = prop.getProperty("productListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count=rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//조회수 증가 DAO
		public int increaseCount(Connection conn, int productNo) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("increaseCount");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				result=pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				
			}return result;
			
		}


		//물품 상세보기 데이터 가져오는 DAO
		public ProductDetail selectProduct(Connection conn, int productNo) {
			ResultSet rset = null;
			PreparedStatement pstmt = null;
			ProductDetail p = null;
			
			String sql = prop.getProperty("selectProduct");
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					p = new ProductDetail(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_TITLE"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getInt("PRODUCT_PICK"),
									rset.getInt("USER_NO"),
									rset.getString("USER_NICKNAME"),
									rset.getString("USER_NAME"),
									rset.getString("PRODUCT_CATEGORY"),
									rset.getInt("PRODUCT_VIEWS"),
									rset.getString("PRODUCT_TRANSACTION"),
									rset.getString("PRODUCT_NEGO"),
									rset.getString("PRODUCT_CONTENT"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return p;
		}

		//물품 상세보기 사진 가져오는 DAO
		public ArrayList<ProductFile> selectAttacgmentList(Connection conn, int productNo) {
			
			ArrayList<ProductFile> list = new ArrayList<>();
			
			PreparedStatement pstmt = null;
			
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectAttachment");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					ProductFile pf = new ProductFile();
					
					pf.setFileNo(rset.getInt("FILE_NO"));
					pf.setFileChangeName(rset.getString("FILE_CHANGE_NAME"));
					pf.setFileOriginName(rset.getString("FILE_ORIGIN_NAME"));
					pf.setFilePath(rset.getString("FILE_PATH"));
					
					list.add(pf);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return list;
		}



		public int productPickDeleteUpdate(Connection conn, int productNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("productPickCountDelete");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,productNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}



		public int productPickAddUpdate(Connection conn, int productNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("productPickCountAdd");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,productNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}



		public boolean amIPcik(Connection conn, int productNo, int userNo) {
			PreparedStatement pstmt = null;
			boolean pick = false;
			ResultSet rset = null;
			
			String sql = prop.getProperty("amIpick");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				pstmt.setInt(2, userNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					pick = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return pick;
		}



		public int productPickCount(Connection conn, int productNo) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int pickCount = 0;
			
			String sql = prop.getProperty("productPickNum");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					pickCount = rset.getInt("PRODUCT_PICK");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return pickCount;
		}



		public ArrayList<Product> productSelectList(Connection conn, String category) {
			ArrayList<Product> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("selectProductList");

			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, category);
				
				rset = pstmt.executeQuery();

				while(rset.next()) {
					
					list.add(new Product(rset.getInt("PRODUCT_NO")
							,rset.getString("PRODUCT_TITLE")
							,rset.getInt("PRODUCT_PRICE")
							,rset.getInt("PRODUCT_PICK")
							,rset.getString("USER_NICKNAME")
							,rset.getString("PRODUCT_STATUS")
							,rset.getString("PRODUCT_SELL_STATUS")
							,rset.getString("PRODUCT_CATEGORY")
							,rset.getInt("PRODUCT_VIEWS")
							,rset.getString("PRODUCT_TRANSACTION")
							,rset.getString("PRODUCT_NEGO")
							,rset.getString("PRODUCT_CONTENT")
							,rset.getDate("PRODUCT_ENTERDATE")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			for(Product p : list) {
				System.out.println(p.getProductTitle());
			}
			return list;
		}



		public int productSell(Connection conn, int productNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("productSelled");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}



		public int productBuy(Connection conn, int productNo, int buyUserNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("productBuy");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				pstmt.setInt(2, buyUserNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}



		public int searchProduct(Connection conn, int productNo, int buyUserNo) {
			PreparedStatement pstmt = null;
			int userNo = 0;
			ResultSet rset = null;
			
			String sql = prop.getProperty("searchProductHere");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					userNo=rset.getInt("USER_NO");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return userNo;
		}
		
		public int insertProduct(Connection conn, Product p) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertProduct");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, p.getProductTitle());
				pstmt.setInt(2, p.getProductPrice());
				pstmt.setString(3, p.getProductContent());
				pstmt.setInt(4, p.getUserNo());
				pstmt.setString(5, p.getCategory());
				pstmt.setString(6, p.getProductTransaction());
				
				result = pstmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
			
		}


		public int insertProductFile(Connection conn, ArrayList<ProductFile> list) {
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("insertProductFile");
			
			try {
				for(ProductFile pf : list) {
					
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, pf.getFileOriginName());
					pstmt.setString(2, pf.getFileChangeName());
					pstmt.setString(3, pf.getFilePath());
					pstmt.setInt(4, pf.getFileLevel());
					
					result = pstmt.executeUpdate();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
			
		}



		public int updateProduct(Connection conn, ProductDetail pd, ProductFile pf) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("updateProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, pd.getProductTitle());
				pstmt.setInt(2, pd.getProductPrice());
				pstmt.setString(3, pd.getProductTransaction());
				pstmt.setString(4, pd.getCategory());
				pstmt.setString(5, pd.getProductContent());
				pstmt.setInt(6, pd.getProductNo());
				
				result = pstmt.executeUpdate();
				
				if(result>0&&pf!=null) {
					sql = prop.getProperty("updateProductFile");
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pf.getFileOriginName());
					pstmt.setString(2, pf.getFileChangeName());
					pstmt.setString(3, pf.getFilePath());
					pstmt.setInt(4, pf.getFileNo());
					
					result = pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}



		public int productDelete(Connection conn, int productNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("deleteProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}



		public int productFileDelete(Connection conn, int productNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			
			String sql = prop.getProperty("deleteFileProduct");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, productNo);
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}
		
		public int menubarSearchCount(Connection conn, String keyword) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int count = 0;
			
			String sql = prop.getProperty("menubarSearchCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, keyword);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					count=rset.getInt("COUNT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

		public ArrayList<Product> menubarSearchList(Connection conn, String keyword, PageInfo page) {
			ArrayList<Product> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("menubarSearchListPaging");

			try {
				pstmt = conn.prepareStatement(sql);
				
				int start = (page.getCurrentPage()-1)*page.getBoardLimit()+1;
				int end = page.getCurrentPage()*page.getBoardLimit();
				
				pstmt.setString(1, keyword);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rset = pstmt.executeQuery();

				while(rset.next()) {
					
					list.add(new Product(rset.getInt("PRODUCT_NO")
							,rset.getString("PRODUCT_TITLE")
							,rset.getInt("PRODUCT_PRICE")
							,rset.getInt("PRODUCT_PICK")
							,rset.getString("USER_NICKNAME")
							,rset.getString("PRODUCT_STATUS")
							,rset.getString("PRODUCT_SELL_STATUS")
							,rset.getString("PRODUCT_CATEGORY")
							,rset.getInt("PRODUCT_VIEWS")
							,rset.getString("PRODUCT_TRANSACTION")
							,rset.getString("PRODUCT_NEGO")
							,rset.getString("PRODUCT_CONTENT")
							,rset.getDate("PRODUCT_ENTERDATE")
							,rset.getString("FILE_CHANGE_NAME")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			
			return list;
		}
		
		public ArrayList<Product> pickSelectList(Connection conn, int userNo, PageInfo pi) {
			PreparedStatement pstmt = null;
			ArrayList<Product> list = new ArrayList<>();
			ResultSet rset = null;
			
			String sql = prop.getProperty("showPickList");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				int start = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
				int end = pi.getCurrentPage()*pi.getBoardLimit();
				
				pstmt.setInt(1, userNo);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					
					list.add(new Product(rset.getInt("PRODUCT_NO")
							            ,rset.getString("PRODUCT_TITLE")
							            ,rset.getInt("PRODUCT_PRICE")
							            ,rset.getString("USER_NICKNAME")
							            ,rset.getString("FILE_CHANGE_NAME")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return list;
		}


		public int productPickListCount(Connection conn,int userNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			ResultSet rset = null;
			
			String sql = prop.getProperty("productPickListCount");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					result=rset.getInt("COUNT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return result;
			
			
		}



		public int productSubListCount(Connection conn, String category, String subKeyword) {
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			int count = 0;
			
			String sql = prop.getProperty("productSubListCount");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category);
				pstmt.setString(2, subKeyword);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					count=rset.getInt("COUNT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}



		public ArrayList<Product> productSelectSubList(Connection conn, String category, String categorySub, String subKeyword, PageInfo page) {
			ArrayList<Product> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = "";
			if(categorySub.equals("title")) {
				sql = prop.getProperty("selectProductSubTitlePaging");
			}else {
				sql = prop.getProperty("selectProductSubNickNamePaging");
			}

			try {
				pstmt = conn.prepareStatement(sql);
				
				int start = (page.getCurrentPage()-1)*page.getBoardLimit()+1;
				int end = page.getCurrentPage()*page.getBoardLimit();
				pstmt.setString(1, category);
				pstmt.setString(2, subKeyword);
				pstmt.setInt(3, start);
				pstmt.setInt(4, end);
				
				rset = pstmt.executeQuery();

				while(rset.next()) {
					
					list.add(new Product(rset.getInt("PRODUCT_NO")
							,rset.getString("PRODUCT_TITLE")
							,rset.getInt("PRODUCT_PRICE")
							,rset.getInt("PRODUCT_PICK")
							,rset.getString("USER_NICKNAME")
							,rset.getString("PRODUCT_STATUS")
							,rset.getString("PRODUCT_SELL_STATUS")
							,rset.getString("PRODUCT_CATEGORY")
							,rset.getInt("PRODUCT_VIEWS")
							,rset.getString("PRODUCT_TRANSACTION")
							,rset.getString("PRODUCT_NEGO")
							,rset.getString("PRODUCT_CONTENT")
							,rset.getDate("PRODUCT_ENTERDATE")
							,rset.getString("FILE_CHANGE_NAME")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}
		
		public int purchaseListCount(Connection conn, int userNo) {
			PreparedStatement pstmt = null;
			int result = 0;
			ResultSet rset = null;
			
			String sql = prop.getProperty("purchaseListCount");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					result=rset.getInt("COUNT");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return result;
			
		}


		public ArrayList<Product> purchaseList(Connection conn, int userNo, PageInfo pi) {
			ArrayList<Product> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("purchaseList");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				int start = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
				int end = pi.getCurrentPage()*pi.getBoardLimit();
				
				pstmt.setInt(1, userNo);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rset = pstmt.executeQuery();

				while(rset.next()) {
					list.add(new Product(rset.getInt("PRODUCT_NO")
							            ,rset.getString("PRODUCT_TITLE")
							            ,rset.getInt("PRODUCT_PRICE")
							            ,rset.getString("NICKNAME")
							            ,rset.getDate("PAY_DATE")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);

			}return list;
			
		}


		public ArrayList<Product> purchaseFileName(Connection conn, int userNo) {
			ArrayList<Product> list2 = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("purchaseFileName");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, userNo);
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					list2.add(new Product(rset.getInt("PRODUCT_NO")
							            ,rset.getString("FILE_CHANGE_NAME")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return list2;
			
		}



		public ArrayList<Product> productMainList(Connection conn, String category) {
			ArrayList<Product> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("productMainList");

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category);
				
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Product(rset.getInt("PRODUCT_NO")
							,rset.getString("PRODUCT_TITLE")
							,rset.getInt("PRODUCT_PRICE")
							,rset.getInt("PRODUCT_PICK")
							,rset.getString("USER_NICKNAME")
							,rset.getString("PRODUCT_STATUS")
							,rset.getString("PRODUCT_SELL_STATUS")
							,rset.getString("PRODUCT_CATEGORY")
							,rset.getInt("PRODUCT_VIEWS")
							,rset.getString("PRODUCT_TRANSACTION")
							,rset.getString("PRODUCT_NEGO")
							,rset.getString("PRODUCT_CONTENT")
							,rset.getDate("PRODUCT_ENTERDATE")
							,rset.getString("FILE_CHANGE_NAME")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return list;
		}
		
		public int insertReport(Connection conn, Report r) {
			
			int result = 0;
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertReport");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, r.getReporterUserNo());
				pstmt.setInt(2, r.getRespondentUserNo());
				pstmt.setString(3, r.getReportTab());
				pstmt.setString(4, r.getReportContent());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
			
		}


		public int reportListCount(Connection conn) {
			int result = 0;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("reportListCount");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					result=rset.getInt("COUNT");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
			
		}


		public ArrayList<Report> reportList(Connection conn, PageInfo pi) {
			ArrayList<Report> list = new ArrayList<>();
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("reportList");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				int start = (pi.getCurrentPage()-1)*pi.getBoardLimit()+1;
				int end = pi.getCurrentPage()*pi.getBoardLimit();
				
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				
				rset=pstmt.executeQuery();
				
				while(rset.next()) {
					list.add(new Report(rset.getInt("REPORT_NO")
							    	   ,rset.getString("REPORTER")
							    	   ,rset.getString("REPORTED")
							    	   ,rset.getString("REPORT_REASON")
							    	   ,rset.getString("REPORT_CONTENT")
							    	   ,rset.getDate("REPORT_NUMER")));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return list;
			
		}


		public Report reportDetailView(Connection conn, int reportNo) {
			Report r = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("reportDetailView");
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, reportNo);
				rset=pstmt.executeQuery();
				
				if(rset.next()) {
					r = new Report(rset.getInt("REPORT_NO")
							      ,rset.getString("REPORTER")
							      ,rset.getString("REPORTED")
						    	  ,rset.getString("REPORT_REASON")
						    	  ,rset.getString("REPORT_CONTENT")
						    	  ,rset.getDate("REPORT_NUMER"));			
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}return r;
			
		}
}
